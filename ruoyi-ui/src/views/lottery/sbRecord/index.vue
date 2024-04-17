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
      <el-form-item label="平台用户名(vendor_member_id)" prop="platUserName">
        <el-input
          v-model="queryParams.platUserName"
          placeholder="请输入平台用户名(vendor_member_id)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="游戏局号(trans_id)" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入游戏局号(trans_id)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="sportname" prop="gameName">
        <el-input
          v-model="queryParams.gameName"
          placeholder="请输入sportname"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="主队名称hometeamname" prop="tnameHome">
        <el-input
          v-model="queryParams.tnameHome"
          placeholder="请输入主队名称hometeamname"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="客队名称awayteamname" prop="tnameAway">
        <el-input
          v-model="queryParams.tnameAway"
          placeholder="请输入客队名称awayteamname"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联赛名称leaguename" prop="league">
        <el-input
          v-model="queryParams.league"
          placeholder="请输入联赛名称leaguename"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="赔率 odds" prop="ioratio">
        <el-input
          v-model="queryParams.ioratio"
          placeholder="请输入赔率 odds"
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
      <el-form-item label="总投注额stake" prop="allBet">
        <el-input
          v-model="queryParams.allBet"
          placeholder="请输入总投注额stake"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="此注输或赢的金额winlost_amount" prop="profit">
        <el-input
          v-model="queryParams.profit"
          placeholder="请输入此注输或赢的金额winlost_amount"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下注时间transaction_time" prop="betTime">
        <el-date-picker clearable
          v-model="queryParams.betTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下注时间transaction_time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结算时间settlement_time" prop="settleTime">
        <el-date-picker clearable
          v-model="queryParams.settleTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择结算时间settlement_time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="比分结果" prop="resultScore">
        <el-input
          v-model="queryParams.resultScore"
          placeholder="请输入比分结果"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="球头" prop="oddsFormat">
        <el-input
          v-model="queryParams.oddsFormat"
          placeholder="请输入球头"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="2:2串1 3:3串1 4:4串1" prop="parlaynum">
        <el-input
          v-model="queryParams.parlaynum"
          placeholder="请输入2:2串1 3:3串1 4:4串1"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="滚球  0:否 1:是" prop="isLive">
        <el-input
          v-model="queryParams.isLive"
          placeholder="请输入滚球  0:否 1:是"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开赛时间" prop="matchDatetime">
        <el-date-picker clearable
          v-model="queryParams.matchDatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开赛时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="下注时比分" prop="score">
        <el-input
          v-model="queryParams.score"
          placeholder="请输入下注时比分"
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
          v-hasPermi="['lottery:sbRecord:add']"
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
          v-hasPermi="['lottery:sbRecord:edit']"
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
          v-hasPermi="['lottery:sbRecord:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:sbRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sbRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="平台用户名(vendor_member_id)" align="center" prop="platUserName" />
      <el-table-column label="游戏局号(trans_id)" align="center" prop="orderNo" />
      <el-table-column label="sportname" align="center" prop="gameName" />
      <el-table-column label="滚球 非滚球" align="center" prop="wtype" />
      <el-table-column label="玩法结果bettypename" align="center" prop="rtype" />
      <el-table-column label="主队名称hometeamname" align="center" prop="tnameHome" />
      <el-table-column label="客队名称awayteamname" align="center" prop="tnameAway" />
      <el-table-column label="联赛名称leaguename" align="center" prop="league" />
      <el-table-column label="赔率 odds" align="center" prop="ioratio" />
      <el-table-column label="有效投注" align="center" prop="effectiveBet" />
      <el-table-column label="总投注额stake" align="center" prop="allBet" />
      <el-table-column label="此注输或赢的金额winlost_amount" align="center" prop="profit" />
      <el-table-column label="下注时间transaction_time" align="center" prop="betTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.betTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间settlement_time" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="0:未结算 1:已结算" align="center" prop="settleStatus" />
      <el-table-column label="waiting(等待中) running(进行中)void(作废)refund(退款)reject(已取消)lose(输)won(赢)draw(和局)half won(半赢)half lose(半输)" align="center" prop="resultStatus" />
      <el-table-column label="比分结果" align="center" prop="resultScore" />
      <el-table-column label="球头" align="center" prop="oddsFormat" />
      <el-table-column label="2:2串1 3:3串1 4:4串1" align="center" prop="parlaynum" />
      <el-table-column label="串数内容 ParlayData" align="center" prop="parlaysub" />
      <el-table-column label="返回的原始数据 一般是json" align="center" prop="rawData" />
      <el-table-column label="重新结算信息" align="center" prop="resettlementinfo" />
      <el-table-column label="滚球  0:否 1:是" align="center" prop="isLive" />
      <el-table-column label="开赛时间" align="center" prop="matchDatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.matchDatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="下注内容" align="center" prop="betContent" />
      <el-table-column label="下注时比分" align="center" prop="score" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:sbRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:sbRecord:remove']"
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

    <!-- 添加或修改沙巴体育注单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="平台用户名(vendor_member_id)" prop="platUserName">
          <el-input v-model="form.platUserName" placeholder="请输入平台用户名(vendor_member_id)" />
        </el-form-item>
        <el-form-item label="游戏局号(trans_id)" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入游戏局号(trans_id)" />
        </el-form-item>
        <el-form-item label="sportname" prop="gameName">
          <el-input v-model="form.gameName" placeholder="请输入sportname" />
        </el-form-item>
        <el-form-item label="主队名称hometeamname" prop="tnameHome">
          <el-input v-model="form.tnameHome" placeholder="请输入主队名称hometeamname" />
        </el-form-item>
        <el-form-item label="客队名称awayteamname" prop="tnameAway">
          <el-input v-model="form.tnameAway" placeholder="请输入客队名称awayteamname" />
        </el-form-item>
        <el-form-item label="联赛名称leaguename" prop="league">
          <el-input v-model="form.league" placeholder="请输入联赛名称leaguename" />
        </el-form-item>
        <el-form-item label="赔率 odds" prop="ioratio">
          <el-input v-model="form.ioratio" placeholder="请输入赔率 odds" />
        </el-form-item>
        <el-form-item label="有效投注" prop="effectiveBet">
          <el-input v-model="form.effectiveBet" placeholder="请输入有效投注" />
        </el-form-item>
        <el-form-item label="总投注额stake" prop="allBet">
          <el-input v-model="form.allBet" placeholder="请输入总投注额stake" />
        </el-form-item>
        <el-form-item label="此注输或赢的金额winlost_amount" prop="profit">
          <el-input v-model="form.profit" placeholder="请输入此注输或赢的金额winlost_amount" />
        </el-form-item>
        <el-form-item label="下注时间transaction_time" prop="betTime">
          <el-date-picker clearable
            v-model="form.betTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下注时间transaction_time">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结算时间settlement_time" prop="settleTime">
          <el-date-picker clearable
            v-model="form.settleTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结算时间settlement_time">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="比分结果" prop="resultScore">
          <el-input v-model="form.resultScore" placeholder="请输入比分结果" />
        </el-form-item>
        <el-form-item label="球头" prop="oddsFormat">
          <el-input v-model="form.oddsFormat" placeholder="请输入球头" />
        </el-form-item>
        <el-form-item label="2:2串1 3:3串1 4:4串1" prop="parlaynum">
          <el-input v-model="form.parlaynum" placeholder="请输入2:2串1 3:3串1 4:4串1" />
        </el-form-item>
        <el-form-item label="串数内容 ParlayData" prop="parlaysub">
          <el-input v-model="form.parlaysub" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="返回的原始数据 一般是json" prop="rawData">
          <el-input v-model="form.rawData" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="重新结算信息" prop="resettlementinfo">
          <el-input v-model="form.resettlementinfo" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="滚球  0:否 1:是" prop="isLive">
          <el-input v-model="form.isLive" placeholder="请输入滚球  0:否 1:是" />
        </el-form-item>
        <el-form-item label="开赛时间" prop="matchDatetime">
          <el-date-picker clearable
            v-model="form.matchDatetime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开赛时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="下注内容">
          <editor v-model="form.betContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="下注时比分" prop="score">
          <el-input v-model="form.score" placeholder="请输入下注时比分" />
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
import { listSbRecord, getSbRecord, delSbRecord, addSbRecord, updateSbRecord } from "@/api/lottery/sbRecord";

export default {
  name: "SbRecord",
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
      // 沙巴体育注单表格数据
      sbRecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        platUserName: null,
        orderNo: null,
        gameName: null,
        wtype: null,
        rtype: null,
        tnameHome: null,
        tnameAway: null,
        league: null,
        ioratio: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        betTime: null,
        settleTime: null,
        settleStatus: null,
        resultStatus: null,
        resultScore: null,
        oddsFormat: null,
        parlaynum: null,
        parlaysub: null,
        rawData: null,
        resettlementinfo: null,
        isLive: null,
        matchDatetime: null,
        betContent: null,
        score: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        platUserName: [
          { required: true, message: "平台用户名(vendor_member_id)不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询沙巴体育注单列表 */
    getList() {
      this.loading = true;
      listSbRecord(this.queryParams).then(response => {
        this.sbRecordList = response.rows;
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
        gameName: null,
        wtype: null,
        rtype: null,
        tnameHome: null,
        tnameAway: null,
        league: null,
        ioratio: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        betTime: null,
        settleTime: null,
        settleStatus: null,
        resultStatus: null,
        resultScore: null,
        oddsFormat: null,
        parlaynum: null,
        parlaysub: null,
        rawData: null,
        resettlementinfo: null,
        isLive: null,
        createTime: null,
        updateTime: null,
        matchDatetime: null,
        betContent: null,
        score: null
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
      this.title = "添加沙巴体育注单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSbRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改沙巴体育注单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateSbRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSbRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除沙巴体育注单编号为"' + ids + '"的数据项？').then(function() {
        return delSbRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/sbRecord/export', {
        ...this.queryParams
      }, `sbRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
