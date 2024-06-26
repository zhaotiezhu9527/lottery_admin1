<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="账户名称" prop="accountName">
        <el-input
          v-model="queryParams.accountName"
          placeholder="请输入账户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="accountNo">
        <el-select v-model="queryParams.type" placeholder="请选择">
          <el-option
            v-for="item in statusList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="支付类型">
        <el-select v-model="queryParams.type" placeholder="请选择">
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
          v-hasPermi="['lottery:companyAccount:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="companyAccountList">
      <el-table-column label="账户名称" align="center" prop="accountName" />
      <el-table-column label="收款人" align="center" prop="payeeName" />
      <el-table-column label="收款账号" align="center" prop="accountNo" />
      <el-table-column label="开户网点" align="center" prop="address" />
      <el-table-column label="最小金额" align="center" prop="minAmount" />
      <el-table-column label="最大金额" align="center" prop="maxAmount" />
      <el-table-column label="支付类型" align="center" prop="type" >
        <template slot-scope="scope">
          <div v-if="scope.row.type === 1">银行卡</div>
          <div v-else-if="scope.row.type === 2">微信</div>
          <div v-else-if="scope.row.type === 3">支付宝</div>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
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
      <el-table-column label="值越大越靠前" align="center" prop="pxh" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:companyAccount:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:companyAccount:remove']"
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

    <!-- 添加或修改公司入款账号对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="账户名称" prop="accountName">
          <el-input v-model="form.accountName" placeholder="请输入账户名称" />
        </el-form-item>
        <el-form-item label="收款人" prop="payeeName">
          <el-input v-model="form.payeeName" placeholder="请输入收款人" />
        </el-form-item>
        <el-form-item label="收款账号" prop="accountNo">
          <el-input v-model="form.accountNo" placeholder="请输入收款账号" />
        </el-form-item>
        <el-form-item label="开户网点" prop="address">
          <el-input v-model="form.address" placeholder="请输入开户网点" />
        </el-form-item>
        <el-form-item label="最小金额" prop="minAmount">
          <el-input v-model="form.minAmount" placeholder="请输入最小金额" />
        </el-form-item>
        <el-form-item label="最大金额" prop="maxAmount">
          <el-input v-model="form.maxAmount" placeholder="请输入最大金额" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="值越大越靠前" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入值越大越靠前" />
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
import { listCompanyAccount, getCompanyAccount, delCompanyAccount, addCompanyAccount, updateCompanyAccount } from "@/api/lottery/companyAccount";

export default {
  name: "CompanyAccount",
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
      // 公司入款账号表格数据
      companyAccountList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        accountName: null,
        type: "",
        status: "",
        isAsc:'desc',
        orderByColumn:'id'
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      typeList: [
        { label: '全部', value: ''},
        { label: '银行卡', value: 1},
        { label: '微信', value: 2},
        { label: '支付宝', value: 3},
      ],//类型
      statusList: [
        { label: '全部', value: ''},
        { label: '启用', value: 0},
        { label: '停用', value: 2},
      ],//类型
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询公司入款账号列表 */
    getList() {
      this.loading = true;
      listCompanyAccount(this.queryParams).then(response => {
        this.companyAccountList = response.rows;
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
        accountName: null,
        type: "",
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加公司入款账号";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCompanyAccount(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改公司入款账号";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCompanyAccount(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCompanyAccount(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除公司入款账号编号为"' + ids + '"的数据项？').then(function() {
        return delCompanyAccount(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/companyAccount/export', {
        ...this.queryParams
      }, `companyAccount_${new Date().getTime()}.xlsx`)
    },
    // 停启用状态
    changeStatus(id,status){
      updateCompanyAccount({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
  }
};
</script>
