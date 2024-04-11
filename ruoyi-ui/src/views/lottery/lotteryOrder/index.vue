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
      <el-form-item label="彩种代码" prop="lotteryCode">
        <el-input
          v-model="queryParams.lotteryCode"
          placeholder="请输入彩种代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="彩种名称" prop="lotteryName">
        <el-input
          v-model="queryParams.lotteryName"
          placeholder="请输入彩种名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="盘口代码" prop="handicapCode">
        <el-input
          v-model="queryParams.handicapCode"
          placeholder="请输入盘口代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="玩法代码" prop="playCode">
        <el-input
          v-model="queryParams.playCode"
          placeholder="请输入玩法代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="玩法名称" prop="playName">
        <el-input
          v-model="queryParams.playName"
          placeholder="请输入玩法名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赔率" prop="odds">
        <el-input
          v-model="queryParams.odds"
          placeholder="请输入赔率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="期号" prop="qs">
        <el-input
          v-model="queryParams.qs"
          placeholder="请输入期号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投注金额" prop="betAmount">
        <el-input
          v-model="queryParams.betAmount"
          placeholder="请输入投注金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="中奖金额(未中奖为0)" prop="bonusAmount">
        <el-input
          v-model="queryParams.bonusAmount"
          placeholder="请输入中奖金额(未中奖为0)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="盈利金额" prop="profitAmount">
        <el-input
          v-model="queryParams.profitAmount"
          placeholder="请输入盈利金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="投注时间" prop="betTime">
        <el-date-picker clearable
          v-model="queryParams.betTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择投注时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结算时间" prop="settleTime">
        <el-date-picker clearable
          v-model="queryParams.settleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结算时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="开奖结果" prop="openResult">
        <el-input
          v-model="queryParams.openResult"
          placeholder="请输入开奖结果"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预计开奖时间" prop="openResultTime">
        <el-date-picker clearable
          v-model="queryParams.openResultTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预计开奖时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="随机分组,结算用" prop="settleGroup">
        <el-input
          v-model="queryParams.settleGroup"
          placeholder="请输入随机分组,结算用"
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
          v-hasPermi="['lottery:lotteryOrder:add']"
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
          v-hasPermi="['lottery:lotteryOrder:edit']"
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
          v-hasPermi="['lottery:lotteryOrder:remove']"
        >删除</el-button>
      </el-col>
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

    <el-table v-loading="loading" :data="lotteryOrderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="彩种代码" align="center" prop="lotteryCode" />
      <el-table-column label="彩种名称" align="center" prop="lotteryName" />
      <el-table-column label="盘口代码" align="center" prop="handicapCode" />
      <el-table-column label="玩法代码" align="center" prop="playCode" />
      <el-table-column label="玩法名称" align="center" prop="playName" />
      <el-table-column label="投注内容" align="center" prop="betContent" />
      <el-table-column label="赔率" align="center" prop="odds" />
      <el-table-column label="期号" align="center" prop="qs" />
      <el-table-column label="投注金额" align="center" prop="betAmount" />
      <el-table-column label="中奖金额(未中奖为0)" align="center" prop="bonusAmount" />
      <el-table-column label="盈利金额" align="center" prop="profitAmount" />
      <el-table-column label="投注时间" align="center" prop="betTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.betTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="0:待结算 1:结算中(未使用) 2:已结算 3:已撤单 4:结算异常" align="center" prop="settleStatus" />
      <el-table-column label="0:待结算 1:已中奖 2:未中奖 3:已撤单 4:和局" align="center" prop="orderStatus" />
      <el-table-column label="开奖结果" align="center" prop="openResult" />
      <el-table-column label="预计开奖时间" align="center" prop="openResultTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openResultTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="随机分组,结算用" align="center" prop="settleGroup" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:lotteryOrder:edit']"
          >修改</el-button>
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

    <!-- 添加或修改投注记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="订单号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="彩种代码" prop="lotteryCode">
          <el-input v-model="form.lotteryCode" placeholder="请输入彩种代码" />
        </el-form-item>
        <el-form-item label="彩种名称" prop="lotteryName">
          <el-input v-model="form.lotteryName" placeholder="请输入彩种名称" />
        </el-form-item>
        <el-form-item label="盘口代码" prop="handicapCode">
          <el-input v-model="form.handicapCode" placeholder="请输入盘口代码" />
        </el-form-item>
        <el-form-item label="玩法代码" prop="playCode">
          <el-input v-model="form.playCode" placeholder="请输入玩法代码" />
        </el-form-item>
        <el-form-item label="玩法名称" prop="playName">
          <el-input v-model="form.playName" placeholder="请输入玩法名称" />
        </el-form-item>
        <el-form-item label="投注内容">
          <editor v-model="form.betContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="赔率" prop="odds">
          <el-input v-model="form.odds" placeholder="请输入赔率" />
        </el-form-item>
        <el-form-item label="期号" prop="qs">
          <el-input v-model="form.qs" placeholder="请输入期号" />
        </el-form-item>
        <el-form-item label="投注金额" prop="betAmount">
          <el-input v-model="form.betAmount" placeholder="请输入投注金额" />
        </el-form-item>
        <el-form-item label="中奖金额(未中奖为0)" prop="bonusAmount">
          <el-input v-model="form.bonusAmount" placeholder="请输入中奖金额(未中奖为0)" />
        </el-form-item>
        <el-form-item label="盈利金额" prop="profitAmount">
          <el-input v-model="form.profitAmount" placeholder="请输入盈利金额" />
        </el-form-item>
        <el-form-item label="投注时间" prop="betTime">
          <el-date-picker clearable
            v-model="form.betTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择投注时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结算时间" prop="settleTime">
          <el-date-picker clearable
            v-model="form.settleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结算时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开奖结果" prop="openResult">
          <el-input v-model="form.openResult" placeholder="请输入开奖结果" />
        </el-form-item>
        <el-form-item label="预计开奖时间" prop="openResultTime">
          <el-date-picker clearable
            v-model="form.openResultTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预计开奖时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="随机分组,结算用" prop="settleGroup">
          <el-input v-model="form.settleGroup" placeholder="请输入随机分组,结算用" />
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
import { listLotteryOrder, getLotteryOrder, delLotteryOrder, addLotteryOrder, updateLotteryOrder } from "@/api/lottery/lotteryOrder";

export default {
  name: "LotteryOrder",
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
      // 投注记录表格数据
      lotteryOrderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        lotteryCode: null,
        lotteryName: null,
        handicapCode: null,
        playCode: null,
        playName: null,
        betContent: null,
        odds: null,
        qs: null,
        betAmount: null,
        bonusAmount: null,
        profitAmount: null,
        betTime: null,
        settleTime: null,
        settleStatus: null,
        orderStatus: null,
        openResult: null,
        openResultTime: null,
        settleGroup: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        orderNo: [
          { required: true, message: "订单号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询投注记录列表 */
    getList() {
      this.loading = true;
      listLotteryOrder(this.queryParams).then(response => {
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
        lotteryCode: null,
        lotteryName: null,
        handicapCode: null,
        playCode: null,
        playName: null,
        betContent: null,
        odds: null,
        qs: null,
        betAmount: null,
        bonusAmount: null,
        profitAmount: null,
        betTime: null,
        settleTime: null,
        settleStatus: null,
        orderStatus: null,
        openResult: null,
        openResultTime: null,
        settleGroup: null,
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
      this.title = "添加投注记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLotteryOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改投注记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLotteryOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLotteryOrder(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除投注记录编号为"' + ids + '"的数据项？').then(function() {
        return delLotteryOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/lotteryOrder/export', {
        ...this.queryParams
      }, `lotteryOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
