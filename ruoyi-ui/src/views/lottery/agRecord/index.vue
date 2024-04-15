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
      <el-form-item label="平台用户名" prop="platUserName">
        <el-input
          v-model="queryParams.platUserName"
          placeholder="请输入平台用户名"
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
      <el-form-item label="游戏ID" prop="gameId">
        <el-input
          v-model="queryParams.gameId"
          placeholder="请输入游戏ID"
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
      <el-form-item label="有效投注" prop="effectiveBet">
        <el-input
          v-model="queryParams.effectiveBet"
          placeholder="请输入有效投注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总投注额" prop="allBet">
        <el-input
          v-model="queryParams.allBet"
          placeholder="请输入总投注额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="派彩金额(不包含本金)" prop="profit">
        <el-input
          v-model="queryParams.profit"
          placeholder="请输入派彩金额(不包含本金)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下注时间">
        <el-date-picker
          v-model="daterangeBetTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="下注时间美东" prop="wagersDate">
        <el-date-picker clearable
          v-model="queryParams.wagersDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下注时间美东">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结算时间">
        <el-date-picker
          v-model="daterangeSettleTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="结算时间美东" prop="modifiedDate">
        <el-date-picker clearable
          v-model="queryParams.modifiedDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结算时间美东">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="局号gameCode" prop="serialId">
        <el-input
          v-model="queryParams.serialId"
          placeholder="请输入局号gameCode"
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
          v-hasPermi="['lottery:agRecord:add']"
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
          v-hasPermi="['lottery:agRecord:edit']"
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
          v-hasPermi="['lottery:agRecord:remove']"
        >删除</el-button>
      </el-col>
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
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="agRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="平台用户名" align="center" prop="platUserName" />
      <el-table-column label="注单号码" align="center" prop="orderNo" />
      <el-table-column label="游戏ID" align="center" prop="gameId" />
      <el-table-column label="游戏名称" align="center" prop="gameName" />
      <el-table-column label="有效投注" align="center" prop="effectiveBet" />
      <el-table-column label="总投注额" align="center" prop="allBet" />
      <el-table-column label="派彩金额(不包含本金)" align="center" prop="profit" />
      <el-table-column label="下注时间" align="center" prop="betTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.betTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下注时间美东" align="center" prop="wagersDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.wagersDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间美东" align="center" prop="modifiedDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifiedDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="0：异常(请联系客服) 1：已派彩 -8：取消指定局注单 -9：取消指定注单" align="center" prop="resultStatus" />
      <el-table-column label="局号gameCode" align="center" prop="serialId" />
      <el-table-column label="1:视讯 2:电子 3:捕鱼" align="center" prop="gameType" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:agRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:agRecord:remove']"
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

    <!-- 添加或修改AG注单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="平台用户名" prop="platUserName">
          <el-input v-model="form.platUserName" placeholder="请输入平台用户名" />
        </el-form-item>
        <el-form-item label="注单号码" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入注单号码" />
        </el-form-item>
        <el-form-item label="游戏ID" prop="gameId">
          <el-input v-model="form.gameId" placeholder="请输入游戏ID" />
        </el-form-item>
        <el-form-item label="游戏名称" prop="gameName">
          <el-input v-model="form.gameName" placeholder="请输入游戏名称" />
        </el-form-item>
        <el-form-item label="有效投注" prop="effectiveBet">
          <el-input v-model="form.effectiveBet" placeholder="请输入有效投注" />
        </el-form-item>
        <el-form-item label="总投注额" prop="allBet">
          <el-input v-model="form.allBet" placeholder="请输入总投注额" />
        </el-form-item>
        <el-form-item label="派彩金额(不包含本金)" prop="profit">
          <el-input v-model="form.profit" placeholder="请输入派彩金额(不包含本金)" />
        </el-form-item>
        <el-form-item label="下注时间" prop="betTime">
          <el-date-picker clearable
            v-model="form.betTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下注时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下注时间美东" prop="wagersDate">
          <el-date-picker clearable
            v-model="form.wagersDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下注时间美东">
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
        <el-form-item label="结算时间美东" prop="modifiedDate">
          <el-date-picker clearable
            v-model="form.modifiedDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结算时间美东">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="局号gameCode" prop="serialId">
          <el-input v-model="form.serialId" placeholder="请输入局号gameCode" />
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
import { listAgRecord, getAgRecord, delAgRecord, addAgRecord, updateAgRecord } from "@/api/lottery/agRecord";

export default {
  name: "AgRecord",
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
      // AG注单表格数据
      agRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 1:视讯 2:电子 3:捕鱼时间范围
      daterangeBetTime: [],
      // 1:视讯 2:电子 3:捕鱼时间范围
      daterangeSettleTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        platUserName: null,
        orderNo: null,
        gameId: null,
        gameName: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        betTime: null,
        wagersDate: null,
        settleTime: null,
        modifiedDate: null,
        resultStatus: null,
        serialId: null,
        gameType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        platUserName: [
          { required: true, message: "平台用户名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询AG注单列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeBetTime && '' != this.daterangeBetTime) {
        this.queryParams.params["beginBetTime"] = this.daterangeBetTime[0];
        this.queryParams.params["endBetTime"] = this.daterangeBetTime[1];
      }
      if (null != this.daterangeSettleTime && '' != this.daterangeSettleTime) {
        this.queryParams.params["beginSettleTime"] = this.daterangeSettleTime[0];
        this.queryParams.params["endSettleTime"] = this.daterangeSettleTime[1];
      }
      listAgRecord(this.queryParams).then(response => {
        this.agRecordList = response.rows;
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
        platUserName: null,
        orderNo: null,
        gameId: null,
        gameName: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        betTime: null,
        wagersDate: null,
        settleTime: null,
        modifiedDate: null,
        resultStatus: null,
        serialId: null,
        gameType: null,
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
      this.daterangeBetTime = [];
      this.daterangeSettleTime = [];
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
      this.title = "添加AG注单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAgRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改AG注单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAgRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAgRecord(this.form).then(response => {
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
