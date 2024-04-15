<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="通道名称" prop="channelName">
        <el-input
          v-model="queryParams.channelName"
          placeholder="请输入通道名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商户名称">
        <el-select v-model="queryParams.merchantCode" placeholder="请选择">
          <el-option value="" label="所有商户"></el-option>
          <el-option
            v-for="item in payMerchantList"
            :key="item.merchantCode"
            :label="item.merchantName"
            :value="item.merchantCode">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.status" placeholder="请选择">
          <el-option
            v-for="item in typeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:payChannel:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="payChannelList">
      <el-table-column label="通道名称" align="center" prop="channelName" />
      <el-table-column label="商户名称" align="center" prop="merchantName" />
      <el-table-column label="最小金额" align="center" prop="minAmount" />
      <el-table-column label="最大金额" align="center" prop="maxAmount" />
      <el-table-column label="支付类型" align="center" prop="type" >
        <template slot-scope="scope">
          <div v-if="scope.row.type === 1">钱包</div>
          <div v-else-if="scope.row.type === 2">微信</div>
          <div v-else-if="scope.row.type === 3">支付宝</div>
          <div v-else-if="scope.row.type === 4">QQ</div>
          <div v-else-if="scope.row.type === 5">数字人民币</div>
          <div v-else-if="scope.row.type === 6">银联</div>
          <div v-else-if="scope.row.type === 7">手机银行</div>
          <div v-else-if="scope.row.type === 8">云闪付</div>
        </template>
      </el-table-column>
      <el-table-column label="排序号" align="center" prop="pxh" />
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            @change="changeStatus(scope.row.id,scope.row.status)"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:payChannel:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:payChannel:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改渠道管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="通道名称" prop="channelName">
          <el-input v-model="form.channelName" placeholder="请输入通道名称" />
        </el-form-item>
        <el-form-item label="最小金额" prop="minAmount">
          <el-input v-model="form.minAmount" placeholder="请输入最小金额" />
        </el-form-item>
        <el-form-item label="最大金额" prop="maxAmount">
          <el-input v-model="form.maxAmount" placeholder="请输入最大金额" />
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPayChannel, getPayChannel, delPayChannel, addPayChannel, updatePayChannel } from "@/api/lottery/payChannel";
import { listPayMerchant } from "@/api/lottery/payMerchant";

export default {
  name: "PayChannel",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 渠道管理表格数据
      payChannelList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        channelName: null,
        merchantCode: "",
        status: "",
      },
      // 表单参数
      form: {
        id:"",
        channelName:"",
        minAmount:"",
        maxAmount:"",
        pxh:"",
        remark:"",
      },
      // 表单校验
      rules: {
        channelCode: [
          { required: true, message: "通道代码不能为空", trigger: "blur" }
        ],
      },
      payMerchantList: [],//商户列表
      typeList: [
        { label: '全部', value: ''},
        { label: '启用', value: 0},
        { label: '停用', value: 2},
      ],//状态
    };
  },
  created() {
    this.getMerchantList()
    
  },
  methods: {
    /** 查询渠道管理列表 */
    getList() {
      this.loading = true;
      listPayChannel(this.queryParams).then(response => {
        this.payChannelList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        channelName: null,
        merchantCode: "",
        status: "",
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id
      getPayChannel(id).then(response => {
        this.form = response.data
        // this.form.id = response.data.id;
        // this.form.channelName = response.data.channelName;
        // this.form.minAmount = response.data.minAmount;
        // this.form.maxAmount = response.data.maxAmount;
        // this.form.pxh = response.data.pxh;
        // this.form.remark = response.data.remark;
        this.open = true;
        this.title = "修改渠道管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      let obj = {
        id: this.form.id,
        channelName: this.form.channelName,
        minAmount: this.form.minAmount,
        maxAmount: this.form.maxAmount,
        pxh: this.form.pxh,
        remark: this.form.remark,
      }
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePayChannel(obj).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } 
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除渠道管理编号为"' + ids + '"的数据项？').then(function() {
        return delPayChannel(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/payChannel/export', {
        ...this.queryParams
      }, `payChannel_${new Date().getTime()}.xlsx`)
    },
    // 停启用状态
    changeStatus(id,status){
      updatePayChannel({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
    /** 查询商家列表 */
    getMerchantList() {
      this.loading = true;
      listPayMerchant({
        pageNum: 1,
        pageSize: 1000,
      }).then(response => {
        this.payMerchantList = response.rows;
        this.getList();
      });
    },
  }
};
</script>
