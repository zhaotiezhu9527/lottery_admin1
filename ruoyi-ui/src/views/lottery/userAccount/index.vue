<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名"
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:userAccount:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="userAccountList">
      <!-- <el-table-column label="id" align="center" prop="id" /> -->
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="类型" align="center" prop="accountType" >
        <template slot-scope="scope">
          <div v-if="scope.row.accountType === 1">银行卡</div>
          <div v-else-if="scope.row.accountType === 2">微信</div>
          <div v-else-if="scope.row.accountType === 3">支付宝</div>
          <div v-else-if="scope.row.accountType === 4">虚拟货币</div>
        </template>
      </el-table-column>
      <el-table-column label="通道名称" align="center" prop="channelName" />
      <el-table-column label="账号地址" align="center" prop="accountNo" />
      <el-table-column label="开户网点" align="center" prop="address" />
      <el-table-column label="持卡人姓名" align="center" prop="realName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:userAccount:remove']"
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

  </div>
</template>

<script>
import { listUserAccount, delUserAccount, } from "@/api/lottery/userAccount";

export default {
  name: "UserAccount",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 收款方式表格数据
      userAccountList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        isAsc:'desc',
        orderByColumn:'id'
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询收款方式列表 */
    getList() {
      this.loading = true;
      listUserAccount(this.queryParams).then(response => {
        this.userAccountList = response.rows;
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
        userName: null,
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除收款方式编号为"' + ids + '"的数据项？').then(function() {
        return delUserAccount(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/userAccount/export', {
        ...this.queryParams
      }, `userAccount_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
