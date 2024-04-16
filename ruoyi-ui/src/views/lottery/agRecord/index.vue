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
      <el-form-item label="注单号码" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入注单号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="局号" prop="serialId">
        <el-input
          v-model="queryParams.serialId"
          placeholder="请输入局号"
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
      <el-form-item label="类型" prop="gameType">
        <el-select v-model="queryParams.gameType" placeholder="请选择">
          <el-option
            v-for="item in gameList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="结算时间">
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
          v-hasPermi="['lottery:agRecord:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="agRecordList">
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="注单号码" align="center" prop="orderNo" width="150"/>
      <el-table-column label="局号" align="center" prop="serialId" width="150"/>
      <el-table-column label="游戏名称" align="center" prop="gameName" />
      <el-table-column label="类型" align="center" prop="gameType" >
        <template slot-scope="scope">
          <span v-if="scope.row.gameType == 1">真人视讯</span>
          <span v-else-if="scope.row.gameType == 2">电子游戏</span>
          <span v-else-if="scope.row.gameType == 3">捕鱼</span>
        </template>
      </el-table-column>
      <el-table-column label="有效投注" align="center" prop="effectiveBet" />
      <el-table-column label="总投注额" align="center" prop="allBet" />
      <el-table-column label="输赢金额" align="center" prop="profit" >
        <template slot-scope="scope">
          <span v-if="scope.row.profit > 0" class="red-text">{{ scope.row.profit }}</span>
          <span v-else class="green-text">{{ scope.row.profit }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下注时间" align="center" prop="betTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.betTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="resultStatus" >
        <template slot-scope="scope">
          <span v-if="scope.row.resultStatus == 0">异常(请联系客服)</span>
          <span v-else-if="scope.row.resultStatus == 1">已派彩</span>
          <span v-else-if="scope.row.resultStatus == -8">取消指定局注单</span>
          <span v-else-if="scope.row.resultStatus == -9">取消指定注单</span>
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
import { listAgRecord, getAgRecord, delAgRecord, addAgRecord, updateAgRecord } from "@/api/lottery/agRecord";
import { dateFormat,pickerOptions } from '@/utils/auth'

export default {
  name: "AgRecord",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // AG注单表格数据
      agRecordList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        gameName: null,
        gameType: "",
      },
      // 时间
      dateRange:[],
      pickerOptions: pickerOptions,
      gameList: [
        { label: '全部', value: ''},
        { label: '真人视讯', value: 1},
        { label: '电子游戏', value: 2},
        { label: '捕鱼', value: 3},
      ],//游戏类型
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询AG注单列表 */
    getList() {
      this.loading = true;
      listAgRecord(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.agRecordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
      this.$modal.confirm('是否确认删除AG注单编号为"' + ids + '"的数据项？').then(function() {
        return delAgRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/agRecord/export', {
        ...this.queryParams
      }, `agRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
