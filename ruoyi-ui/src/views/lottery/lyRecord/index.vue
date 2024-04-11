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
      <el-form-item label="游戏局号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入游戏局号"
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
      <el-form-item label="输赢金额(纯盈利,不包含本金)" prop="profit">
        <el-input
          v-model="queryParams.profit"
          placeholder="请输入输赢金额(纯盈利,不包含本金)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="游戏开始时间" prop="gameStartTime">
        <el-date-picker clearable
          v-model="queryParams.gameStartTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择游戏开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="游戏结束时间" prop="gameEndTime">
        <el-date-picker clearable
          v-model="queryParams.gameEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择游戏结束时间">
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
          v-hasPermi="['lottery:lyRecord:add']"
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
          v-hasPermi="['lottery:lyRecord:edit']"
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
          v-hasPermi="['lottery:lyRecord:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:lyRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lyRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="平台用户名" align="center" prop="platUserName" />
      <el-table-column label="游戏局号" align="center" prop="orderNo" />
      <el-table-column label="游戏ID" align="center" prop="gameId" />
      <el-table-column label="游戏名称" align="center" prop="gameName" />
      <el-table-column label="有效投注" align="center" prop="effectiveBet" />
      <el-table-column label="总投注额" align="center" prop="allBet" />
      <el-table-column label="输赢金额(纯盈利,不包含本金)" align="center" prop="profit" />
      <el-table-column label="游戏开始时间" align="center" prop="gameStartTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.gameStartTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="游戏结束时间" align="center" prop="gameEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.gameEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结算时间" align="center" prop="settleTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.settleTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:lyRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:lyRecord:remove']"
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

    <!-- 添加或修改乐游注单对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="平台用户名" prop="platUserName">
          <el-input v-model="form.platUserName" placeholder="请输入平台用户名" />
        </el-form-item>
        <el-form-item label="游戏局号" prop="orderNo">
          <el-input v-model="form.orderNo" placeholder="请输入游戏局号" />
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
        <el-form-item label="输赢金额(纯盈利,不包含本金)" prop="profit">
          <el-input v-model="form.profit" placeholder="请输入输赢金额(纯盈利,不包含本金)" />
        </el-form-item>
        <el-form-item label="游戏开始时间" prop="gameStartTime">
          <el-date-picker clearable
            v-model="form.gameStartTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择游戏开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="游戏结束时间" prop="gameEndTime">
          <el-date-picker clearable
            v-model="form.gameEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择游戏结束时间">
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listLyRecord, getLyRecord, delLyRecord, addLyRecord, updateLyRecord } from "@/api/lottery/lyRecord";

export default {
  name: "LyRecord",
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
      // 乐游注单表格数据
      lyRecordList: [],
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
        gameId: null,
        gameName: null,
        effectiveBet: null,
        allBet: null,
        profit: null,
        gameStartTime: null,
        gameEndTime: null,
        settleTime: null,
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
    /** 查询乐游注单列表 */
    getList() {
      this.loading = true;
      listLyRecord(this.queryParams).then(response => {
        this.lyRecordList = response.rows;
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
      this.title = "添加乐游注单";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLyRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改乐游注单";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLyRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLyRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除乐游注单编号为"' + ids + '"的数据项？').then(function() {
        return delLyRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/lyRecord/export', {
        ...this.queryParams
      }, `lyRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>