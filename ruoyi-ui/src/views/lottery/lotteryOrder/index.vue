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
      <el-form-item label="订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="彩种名称" prop="lotteryCode">
        <el-select v-model="queryParams.lotteryCode" placeholder="请选择">
          <el-option value="" label="全部彩种"></el-option>
          <el-option
            v-for="item in lotteryList"
            :key="item.lotteryCode"
            :label="item.lotteryName"
            :value="item.lotteryCode">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="期号" prop="qs">
        <el-input
          v-model="queryParams.qs"
          placeholder="请输入期号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.orderStatus" placeholder="请选择">
          <el-option
            v-for="item in orderList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
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
          v-hasPermi="['lottery:lotteryOrder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lotteryOrderList" >
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="彩种名称" align="center" prop="lotteryName" />
      <el-table-column label="期号" align="center" prop="qs" />
      <el-table-column label="投注内容" align="center" prop="playName" width="150">
        <template slot-scope="scope">
          <span class="green-text">{{ scope.row.playName}}</span> &nbsp;
          <span>{{ scope.row.betContent}}</span> &nbsp;
          <span class="red-text">@{{ scope.row.odds}}</span>
        </template>
      </el-table-column>
      <el-table-column label="投注金额" align="center" prop="betAmount" />
      <el-table-column label="输赢" align="center" prop="profitAmount" >
        <template slot-scope="scope">
          <span v-if="scope.row.orderStatus == 1" class="red-text">+{{ scope.row.bonusAmount }}</span>
          <span v-else-if="scope.row.orderStatus == 2" class="green-text">{{ scope.row.profitAmount }}</span>
          <span v-else>0</span>
        </template>
      </el-table-column>
      <el-table-column label="投注时间" align="center" prop="betTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.betTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d} {h}:{i}:{s}' ) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="订单状态" align="center" prop="orderStatus" >
        <template slot-scope="scope">
          <div v-if="scope.row.orderStatus === 0">待结算</div>
          <div v-else-if="scope.row.orderStatus === 1">已中奖</div>
          <div v-else-if="scope.row.orderStatus === 2">未中奖</div>
          <div v-else-if="scope.row.orderStatus === 3">已撤单</div>
          <div v-else-if="scope.row.orderStatus === 4">和局</div>
        </template>
      </el-table-column>
      <el-table-column label="开奖结果" align="center" prop="openResult" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" fixed="right" width="120">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            v-hasPermi="['lottery:lotteryOrder:cancel']"
            v-if="scope.row.orderStatus === 0"
            @click="cancelOrder(scope.row)"
          >撤单</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:lotteryOrder:remove']"
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
import { listLotteryOrder,lotteryOrderOrder } from "@/api/lottery/lotteryOrder";
import { listLottery } from "@/api/lottery/lottery";
import { dateFormat,pickerOptions } from '@/utils/auth'


export default {
  name: "LotteryOrder",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 投注记录表格数据
      lotteryOrderList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        lotteryCode: "",
        qs: null,
        orderStatus: "",
        isAsc:'desc',
        orderByColumn:'id'
      },
      orderList: [
        { label: '全部', value: ''},
        { label: '待结算', value: 0},
        { label: '已中奖', value: 1},
        { label: '未中奖', value: 2},
        { label: '已撤单', value: 3},
        { label: '和局', value: 4},
      ],//状态
      pickerOptions: pickerOptions,
      // 时间
      dateRange:[],
      lotteryList: [],//彩种列表
    };
  },
  created() {
    this.getlotteryList()
  },
  methods: {
    /** 查询投注记录列表 */
    getList() {
      this.loading = true;
      listLotteryOrder(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.lotteryOrderList = response.rows;
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
        orderNo: null,
        lotteryCode: "",
        qs: null,
        orderStatus: "",
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
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/lotteryOrder/export', {
        ...this.queryParams
      }, `lotteryOrder_${new Date().getTime()}.xlsx`)
    },
    /** 查询彩种管理列表 */
    getlotteryList() {
      this.loading = true;
      listLottery({
        pageNum: 1,
        pageSize: 1000,
      }).then(response => {
        this.lotteryList = response.rows;
        this.getList();
      });
    },
    /** 删除按钮操作 */
    cancelOrder(row) {
      let self = this
      this.$modal.confirm('是否取消注单？').then(function() {
        lotteryOrderOrder(row.orderNo).then(response => {
          self.getList();
          self.$modal.msgSuccess("操作成功");
        });
      })
    },
  }
};
</script>
