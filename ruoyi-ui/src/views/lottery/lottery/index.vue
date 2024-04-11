<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
      <el-form-item label="9:00-23:50(全天开奖不用填)" prop="dayOpen">
        <el-input
          v-model="queryParams.dayOpen"
          placeholder="请输入9:00-23:50(全天开奖不用填)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="彩种图标" prop="img">
        <el-input
          v-model="queryParams.img"
          placeholder="请输入彩种图标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提前封盘时间" prop="closeTime">
        <el-input
          v-model="queryParams.closeTime"
          placeholder="请输入提前封盘时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序号(值越大越靠前)" prop="pxh">
        <el-input
          v-model="queryParams.pxh"
          placeholder="请输入排序号(值越大越靠前)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="一天多少期" prop="dayCount">
        <el-input
          v-model="queryParams.dayCount"
          placeholder="请输入一天多少期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第一期开奖时间" prop="firstQsTime">
        <el-input
          v-model="queryParams.firstQsTime"
          placeholder="请输入第一期开奖时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="多少分钟一期" prop="qsTime">
        <el-input
          v-model="queryParams.qsTime"
          placeholder="请输入多少分钟一期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="昨天最后一期期号" prop="yesterdayQs">
        <el-input
          v-model="queryParams.yesterdayQs"
          placeholder="请输入昨天最后一期期号"
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
          v-hasPermi="['lottery:lottery:add']"
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
          v-hasPermi="['lottery:lottery:edit']"
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
          v-hasPermi="['lottery:lottery:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:lottery:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lotteryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="彩种代码" align="center" prop="lotteryCode" />
      <el-table-column label="彩种名称" align="center" prop="lotteryName" />
      <el-table-column label="9:00-23:50(全天开奖不用填)" align="center" prop="dayOpen" />
      <el-table-column label="0:启用 1:停用" align="center" prop="status" />
      <el-table-column label="彩种图标" align="center" prop="img" />
      <el-table-column label="提前封盘时间" align="center" prop="closeTime" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="排序号(值越大越靠前)" align="center" prop="pxh" />
      <el-table-column label="1:快3 2:时时彩 3:PK10 4:六合彩 5:PC蛋蛋 6:11选5 7:福彩3D 8:快乐8" align="center" prop="lotteryType" />
      <el-table-column label="一天多少期" align="center" prop="dayCount" />
      <el-table-column label="第一期开奖时间" align="center" prop="firstQsTime" />
      <el-table-column label="多少分钟一期" align="center" prop="qsTime" />
      <el-table-column label="昨天最后一期期号" align="center" prop="yesterdayQs" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:lottery:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:lottery:remove']"
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

    <!-- 添加或修改彩种管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="彩种代码" prop="lotteryCode">
          <el-input v-model="form.lotteryCode" placeholder="请输入彩种代码" />
        </el-form-item>
        <el-form-item label="彩种名称" prop="lotteryName">
          <el-input v-model="form.lotteryName" placeholder="请输入彩种名称" />
        </el-form-item>
        <el-form-item label="9:00-23:50(全天开奖不用填)" prop="dayOpen">
          <el-input v-model="form.dayOpen" placeholder="请输入9:00-23:50(全天开奖不用填)" />
        </el-form-item>
        <el-form-item label="彩种图标" prop="img">
          <el-input v-model="form.img" placeholder="请输入彩种图标" />
        </el-form-item>
        <el-form-item label="提前封盘时间" prop="closeTime">
          <el-input v-model="form.closeTime" placeholder="请输入提前封盘时间" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="排序号(值越大越靠前)" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号(值越大越靠前)" />
        </el-form-item>
        <el-form-item label="一天多少期" prop="dayCount">
          <el-input v-model="form.dayCount" placeholder="请输入一天多少期" />
        </el-form-item>
        <el-form-item label="第一期开奖时间" prop="firstQsTime">
          <el-input v-model="form.firstQsTime" placeholder="请输入第一期开奖时间" />
        </el-form-item>
        <el-form-item label="多少分钟一期" prop="qsTime">
          <el-input v-model="form.qsTime" placeholder="请输入多少分钟一期" />
        </el-form-item>
        <el-form-item label="昨天最后一期期号" prop="yesterdayQs">
          <el-input v-model="form.yesterdayQs" placeholder="请输入昨天最后一期期号" />
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
import { listLottery, getLottery, delLottery, addLottery, updateLottery } from "@/api/lottery/lottery";

export default {
  name: "Lottery",
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
      // 彩种管理表格数据
      lotteryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lotteryCode: null,
        lotteryName: null,
        dayOpen: null,
        status: null,
        img: null,
        closeTime: null,
        pxh: null,
        lotteryType: null,
        dayCount: null,
        firstQsTime: null,
        qsTime: null,
        yesterdayQs: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        lotteryCode: [
          { required: true, message: "彩种代码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询彩种管理列表 */
    getList() {
      this.loading = true;
      listLottery(this.queryParams).then(response => {
        this.lotteryList = response.rows;
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
        lotteryCode: null,
        lotteryName: null,
        dayOpen: null,
        status: null,
        img: null,
        closeTime: null,
        createTime: null,
        updateTime: null,
        remark: null,
        pxh: null,
        lotteryType: null,
        dayCount: null,
        firstQsTime: null,
        qsTime: null,
        yesterdayQs: null
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
      this.title = "添加彩种管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLottery(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改彩种管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLottery(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLottery(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除彩种管理编号为"' + ids + '"的数据项？').then(function() {
        return delLottery(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/lottery/export', {
        ...this.queryParams
      }, `lottery_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
