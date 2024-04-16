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
      <el-form-item label="游戏局号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入游戏局号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="游戏名称" prop="gameName">
        <el-input
          v-model="queryParams.gameName"
          placeholder="请输入游戏名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="时间" prop="orderTime">
        <el-date-picker
          v-model="dateRange"
          style="width: 340px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions"
        ></el-date-picker>
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
          v-hasPermi="['lottery:kyRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="kyRecordList" >
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="游戏局号" align="center" prop="orderNo" />
      <el-table-column label="游戏名称" align="center" prop="gameName" />
      <el-table-column label="投注额" align="center" prop="allBet" />
      <el-table-column label="有效投注" align="center" prop="effectiveBet" />
      <el-table-column label="输赢金额" align="center" prop="profit" >
        <template slot-scope="scope">
          <span v-if="scope.row.profit > 0" class="red-text">{{ scope.row.profit }}</span>
          <span v-else class="green-text">{{ scope.row.profit }}</span>
        </template>
      </el-table-column>
      <el-table-column label="时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
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
import { listKyRecord, delKyRecord } from "@/api/lottery/kyRecord";
import { dateFormat,pickerOptions } from '@/utils/auth'

export default {
  name: "KyRecord",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 开元注单表格数据
      kyRecordList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        gameName: null,
        isAsc:'desc',
        orderByColumn:'id'
      },
      // 时间
      dateRange:[],
      pickerOptions: pickerOptions,
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询开元注单列表 */
    getList() {
      this.loading = true;
      listKyRecord(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.kyRecordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userName: null,
        platUserName: null,
        orderNo: null,
        gameId: null,
        gameName: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        gameStartTime: null,
        gameEndTime: null,
        settleTime: null,
        createTime: null,
        updateTime: null
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
      this.$modal.confirm('是否确认删除开元注单编号为"' + ids + '"的数据项？').then(function() {
        return delKyRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/kyRecord/export', {
        ...this.queryParams
      }, `kyRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
