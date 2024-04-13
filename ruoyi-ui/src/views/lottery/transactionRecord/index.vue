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
      <el-form-item label="流水号" prop="trxId">
        <el-input
          v-model="queryParams.trxId"
          placeholder="请输入流水号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收支" prop="payType">
        <el-select v-model="queryParams.payType" placeholder="请选择">
          <el-option
            v-for="item in shouzhiList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="类型" prop="businessType">
        <el-select v-model="queryParams.businessType" placeholder="请选择">
          <el-option
            v-for="item in moneyTypeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="订单时间" prop="orderTime">
        <el-date-picker
          v-model="dateRange"
          style="width: 340px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
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
          v-hasPermi="['lottery:transactionRecord:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="transactionRecordList" >
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="流水号" align="center" prop="trxId" />
      <el-table-column label="金额" align="center" prop="amount" />
      <el-table-column label="操作前余额" align="center" prop="beforeAmount" />
      <el-table-column label="操作后余额" align="center" prop="afterAmount" />
      <el-table-column label="收支" align="center" prop="payType" >
        <template slot-scope="scope">
          <el-tag type="success" v-if="scope.row.payType === 1">支出</el-tag>
          <el-tag type="danger" v-else-if="scope.row.payType === 0">收入</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="businessType" >
        <template slot-scope="scope">
          <div v-if="scope.row.businessType === 0">充值</div>
          <div v-else-if="scope.row.businessType === 1">提现</div>
          <div v-else-if="scope.row.businessType === 2">彩票投注</div>
          <div v-else-if="scope.row.businessType === 3">彩票奖金</div>
          <div v-else-if="scope.row.businessType === 4">彩票撤单</div>
          <div v-else-if="scope.row.businessType === 5">额度转入</div>
          <div v-else-if="scope.row.businessType === 6">额度转出</div>
          <div v-else-if="scope.row.businessType === 7">返水</div>
          <div v-else-if="scope.row.businessType === 8">优惠活动</div>
          <div v-else-if="scope.row.businessType === 9">后台入款</div>
          <div v-else-if="scope.row.businessType === 10">后台扣款</div>
          <div v-else-if="scope.row.businessType === 11">彩票和局退还</div>
        </template>
      </el-table-column>
      <el-table-column label="业务订单号" align="center" prop="businessOrder" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作人" align="center" prop="operName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:transactionRecord:remove']"
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
import { listTransactionRecord, delTransactionRecord } from "@/api/lottery/transactionRecord";
import { dateFormat } from '@/utils/auth'

export default {
  name: "TransactionRecord",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 账变记录表格数据
      transactionRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 20,
        userName: null,
        trxId: null,
        payType: "",
        businessType: "",
        isAsc:'desc',
        orderByColumn:'create_time'
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
      },
      shouzhiList: [
        { label: '全部', value: ''},
        { label: '收入', value: 0},
        { label: '支出', value: 1},
      ],//状态
      moneyTypeList: [
        { label: '全部', value: ''},
        { label: '充值', value: 0},
        { label: '提现', value: 1},
        { label: '彩票投注', value: 2},
        { label: '彩票奖金', value: 3},
        { label: '彩票撤单', value: 4},
        { label: '额度转入', value: 5},
        { label: '额度转出', value: 6},
        { label: '返水', value: 7},
        { label: '优惠活动', value: 8},
        { label: '后台入款', value: 9},
        { label: '后台扣款', value: 10},
        { label: '彩票和局退款', value: 11},
      ],//状态
      // 时间
      dateRange:[],
    };
  },
  created() {
    this.getDefaultTime();
    this.getList();
  },
  methods: {
    /** 查询账变记录列表 */
    getList() {
      this.loading = true;
      listTransactionRecord(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.transactionRecordList = response.rows;
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
        trxId: null,
        payType: null,
        businessType: null,
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
      this.$modal.confirm('是否确认删除账变记录编号为"' + ids + '"的数据项？').then(function() {
        return delTransactionRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/transactionRecord/export', {
        ...this.queryParams
      }, `transactionRecord_${new Date().getTime()}.xlsx`)
    },
    getDefaultTime() {
      let end = new Date();
      let start = new Date();
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
      this.dateRange[0] = dateFormat("YYYY-mm-dd" , end) + ' 00:00:00'
      this.dateRange[1] = dateFormat("YYYY-mm-dd" , end) + ' 23:59:59'
    },
  }
};
</script>
