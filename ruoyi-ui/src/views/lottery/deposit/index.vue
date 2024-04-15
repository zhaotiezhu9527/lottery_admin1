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
      <el-form-item label="充值金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入充值金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="支付类型">
        <el-select v-model="queryParams.depositType" placeholder="请选择">
          <el-option
            v-for="item in payList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.status" placeholder="请选择">
          <el-option
            v-for="item in statusList"
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
          v-hasPermi="['lottery:deposit:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="depositList">
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="充值金额" align="center" prop="amount" />
      <el-table-column label="支付类型" align="center" prop="depositType">
        <template slot-scope="scope">
          <div v-if="scope.row.depositType === 1">银行卡</div>
          <div v-else-if="scope.row.depositType === 2">微信</div>
          <div v-else-if="scope.row.depositType === 3">支付宝</div>
          <div v-else-if="scope.row.depositType === 4">虚拟货币</div>
          <div v-else-if="scope.row.depositType === 5">在线支付</div>
          <div v-else-if="scope.row.depositType === 6">后台加钱</div>
        </template>
      </el-table-column>
      <el-table-column label="充值账户详情" align="center" prop="accountDetail" />
      <el-table-column label="用户充值信息详情" align="center" prop="depositDetail" />
      <el-table-column label="审核状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-tag type="warning" v-if="scope.row.status === 0">待审核</el-tag>
          <el-tag type="success" v-else-if="scope.row.status === 1">审核成功</el-tag>
          <el-tag type="danger" v-else-if="scope.row.status === 2">审核失败</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="时间" prop="lastTime" width="200">
        <template slot-scope="scope">
          <div>申请：{{ parseTime(scope.row.createTime, '{y}-{m}-{d} {h}:{i}:{s}')  || '-'}}</div>
          <div>审核：{{ parseTime(scope.row.checkTime, '{y}-{m}-{d} {h}:{i}:{s}')  || '-'}}</div>
        </template>
      </el-table-column>
      <el-table-column label="操作人" align="center" prop="operName" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="handleCheck(scope.row.id)"
            v-hasPermi="['lottery:deposit:check']"
            v-if="scope.row.status === 0"
          >审核</el-button>
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

    <!-- 审核 -->
    <el-dialog title="提交审核" :visible.sync="examineOpen" width="400px" append-to-body>
      <el-form ref="examineform" :model="examineForm" :rules="rules" label-width="80px">
        <el-form-item label="审核" prop="status">
          <el-select v-model="examineForm.status" placeholder="请选择审核状态">
            <el-option label="通过" :value="1"></el-option>
            <el-option label="拒绝" :value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="examineForm.remark" placeholder="请输入审核备注描述，没有可不填" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="examineSub">确 定</el-button>
        <el-button @click="examineOpen = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDeposit,depositCheck } from "@/api/lottery/deposit";
import { dateFormat } from '@/utils/auth'

export default {
  name: "Deposit",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 充值订单表格数据
      depositList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        amount: null,
        depositType: "",
        status: "",
        isAsc:'desc',
        orderByColumn:'id'
      },
      // 表单校验
      rules: {
        status: [
          { required: true, message: "请选择审核状态", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "请输入备注", trigger: "blur" }
        ],
      },
      payList: [
        { label: '全部', value: ''},
        { label: '银行卡', value: 1},
        { label: '微信', value: 2},
        { label: '支付宝', value: 3},
        { label: '虚拟货币', value: 4},
        { label: '在线支付', value: 5},
        { label: '后台加钱', value: 6},
      ],//状态
      statusList: [
        { label: '全部', value: ''},
        { label: '待审核', value: 0},
        { label: '成功', value: 1},
        { label: '失败', value: 2},
      ],//状态
      // 时间
      dateRange:[],
      listId: "",//操作id
      examineOpen: false,//审核状态
      examineForm: {},//审核提交数据
    };
  },
  created() {
    // this.getDefaultTime();
    this.getList();
  },
  methods: {
    /** 查询充值订单列表 */
    getList() {
      this.loading = true;
      listDeposit(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.depositList = response.rows;
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
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/deposit/export', {
        ...this.queryParams
      }, `deposit_${new Date().getTime()}.xlsx`)
    },
    // 默认时间
    getDefaultTime() {
      let end = new Date();
      let start = new Date();
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
      this.dateRange[0] = dateFormat("YYYY-mm-dd" , end) + ' 00:00:00'
      this.dateRange[1] = dateFormat("YYYY-mm-dd" , end) + ' 23:59:59'
    },
    // 审核
    handleCheck(id){
      this.listId = id
      this.examineForm.id = id
      this.examineOpen = true
    },
    // 审核提交
    examineSub(){
      this.$refs["examineform"].validate(valid => {
        if (valid) {
          depositCheck(this.examineForm).then(response => {
            this.$modal.msgSuccess("操作成功");
            this.examineOpen = false;
            this.getList();
          });
        }
      });
    },
  }
};
</script>
