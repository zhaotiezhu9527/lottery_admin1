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
          v-hasPermi="['lottery:companyVirtual:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:companyVirtual:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="companyVirtualList">
      <el-table-column label="通道名称" align="center" prop="channelName" />
      <el-table-column label="提现网络" align="center" prop="channelType" >
        <template slot-scope="scope">
          <div v-if="scope.row.channelType === 1">trc20</div>
          <div v-else-if="scope.row.channelType === 2">erc20</div>
        </template>
      </el-table-column>
      <el-table-column label="收款账户" align="center" prop="accountNo" width="180"/>
      <el-table-column label="汇率" align="center" prop="exchangeRate" />
      <el-table-column label="最小金额" align="center" prop="minAmount" />
      <el-table-column label="最大金额" align="center" prop="maxAmount" />
      <el-table-column label="状态" align="center" prop="status" >
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
      <el-table-column label="创建时间" align="center" prop="createTime" width="180"/>
      <el-table-column label="排序号" align="center" prop="pxh" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:companyVirtual:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:companyVirtual:remove']"
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

    <!-- 添加或修改公司U地址对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="通道名称" prop="channelName">
          <el-input v-model="form.channelName" placeholder="请输入通道名称" />
        </el-form-item>
        <el-form-item label="提现网络" prop="channelType">
            <el-select v-model="form.channelType" placeholder="请选择">
            <el-option
              v-for="item in channelList"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="收款账户" prop="accountNo">
          <el-input v-model="form.accountNo" placeholder="请输入收款账户" />
        </el-form-item>
        <el-form-item label="汇率" prop="exchangeRate">
          <el-input v-model="form.exchangeRate" placeholder="请输入汇率" />
        </el-form-item>
        <el-form-item label="最小金额" prop="minAmount">
          <el-input v-model="form.minAmount" placeholder="请输入最小金额" />
        </el-form-item>
        <el-form-item label="最大金额" prop="maxAmount">
          <el-input v-model="form.maxAmount" placeholder="请输入最大金额" />
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号(值越大越靠前)" />
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
import { listCompanyVirtual, getCompanyVirtual, delCompanyVirtual, addCompanyVirtual, updateCompanyVirtual } from "@/api/lottery/companyVirtual";

export default {
  name: "CompanyVirtual",
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
      // 公司U地址表格数据
      companyVirtualList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        channelName: null,
        isAsc:'desc',
        orderByColumn:'id'
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      channelList: [
        {
          value: 1,
          label: 'trc20',
        },
        {
          value: 2,
          label: 'erc20',
        }
      ],//提现网络列表
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询公司U地址列表 */
    getList() {
      this.loading = true;
      listCompanyVirtual(this.queryParams).then(response => {
        this.companyVirtualList = response.rows;
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
        channelType: null,
        accountNo: null,
        exchangeRate: null,
        createTime: null,
        updateTime: null,
        operName: null,
        pxh: null,
        status: null,
        remark: null,
        minAmount: null,
        maxAmount: null
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加公司U地址";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCompanyVirtual(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改公司U地址";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCompanyVirtual(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCompanyVirtual(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除公司U地址编号为"' + ids + '"的数据项？').then(function() {
        return delCompanyVirtual(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/companyVirtual/export', {
        ...this.queryParams
      }, `companyVirtual_${new Date().getTime()}.xlsx`)
    },
     // 停启用状态
     changeStatus(id,status){
      updateCompanyVirtual({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
  }
};
</script>
