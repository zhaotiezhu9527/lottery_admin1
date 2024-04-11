<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商户代码" prop="merchantCode">
        <el-input
          v-model="queryParams.merchantCode"
          placeholder="请输入商户代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商户名称" prop="merchantName">
        <el-input
          v-model="queryParams.merchantName"
          placeholder="请输入商户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回调地址" prop="callbackUrl">
        <el-input
          v-model="queryParams.callbackUrl"
          placeholder="请输入回调地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回调IP" prop="callbackIp">
        <el-input
          v-model="queryParams.callbackIp"
          placeholder="请输入回调IP"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付网关地址" prop="payUrl">
        <el-input
          v-model="queryParams.payUrl"
          placeholder="请输入支付网关地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['lottery:payMerchant:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['lottery:payMerchant:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['lottery:payMerchant:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:payMerchant:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="payMerchantList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="商户代码" align="center" prop="merchantCode" />
      <el-table-column label="商户名称" align="center" prop="merchantName" />
      <el-table-column label="商户信息详情" align="center" prop="merchantDetail" />
      <el-table-column label="0:启用 1:停用" align="center" prop="status" />
      <el-table-column label="回调地址" align="center" prop="callbackUrl" />
      <el-table-column label="回调IP" align="center" prop="callbackIp" />
      <el-table-column label="支付网关地址" align="center" prop="payUrl" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:payMerchant:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:payMerchant:remove']"
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

    <!-- 添加或修改商家配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商户代码" prop="merchantCode">
          <el-input v-model="form.merchantCode" placeholder="请输入商户代码" />
        </el-form-item>
        <el-form-item label="商户名称" prop="merchantName">
          <el-input v-model="form.merchantName" placeholder="请输入商户名称" />
        </el-form-item>
        <el-form-item label="商户信息详情" prop="merchantDetail">
          <el-input v-model="form.merchantDetail" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="回调地址" prop="callbackUrl">
          <el-input v-model="form.callbackUrl" placeholder="请输入回调地址" />
        </el-form-item>
        <el-form-item label="回调IP" prop="callbackIp">
          <el-input v-model="form.callbackIp" placeholder="请输入回调IP" />
        </el-form-item>
        <el-form-item label="支付网关地址" prop="payUrl">
          <el-input v-model="form.payUrl" placeholder="请输入支付网关地址" />
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
import { listPayMerchant, getPayMerchant, delPayMerchant, addPayMerchant, updatePayMerchant } from "@/api/lottery/payMerchant";

export default {
  name: "PayMerchant",
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
      // 商家配置表格数据
      payMerchantList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        merchantCode: null,
        merchantName: null,
        merchantDetail: null,
        status: null,
        callbackUrl: null,
        callbackIp: null,
        payUrl: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        merchantCode: [
          { required: true, message: "商户代码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询商家配置列表 */
    getList() {
      this.loading = true;
      listPayMerchant(this.queryParams).then(response => {
        this.payMerchantList = response.rows;
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
        merchantCode: null,
        merchantName: null,
        merchantDetail: null,
        createTime: null,
        updateTime: null,
        status: null,
        callbackUrl: null,
        callbackIp: null,
        payUrl: null
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商家配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPayMerchant(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改商家配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePayMerchant(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPayMerchant(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
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
      this.$modal.confirm('是否确认删除商家配置编号为"' + ids + '"的数据项？').then(function() {
        return delPayMerchant(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/payMerchant/export', {
        ...this.queryParams
      }, `payMerchant_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
