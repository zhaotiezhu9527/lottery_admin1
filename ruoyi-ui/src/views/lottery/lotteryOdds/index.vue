<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="号码代码" prop="hmCode">
        <el-input
          v-model="queryParams.hmCode"
          placeholder="请输入号码代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="号码名称" prop="hmName">
        <el-input
          v-model="queryParams.hmName"
          placeholder="请输入号码名称"
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
      <el-form-item label="彩种代码" prop="lotteryCode">
        <el-input
          v-model="queryParams.lotteryCode"
          placeholder="请输入彩种代码"
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
      <el-form-item label="盘口名称" prop="handicapName">
        <el-input
          v-model="queryParams.handicapName"
          placeholder="请输入盘口名称"
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
      <el-form-item label="排序号" prop="pxh">
        <el-input
          v-model="queryParams.pxh"
          placeholder="请输入排序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="号码分组" prop="groupName">
        <el-input
          v-model="queryParams.groupName"
          placeholder="请输入号码分组"
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
          v-hasPermi="['lottery:lotteryOdds:add']"
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
          v-hasPermi="['lottery:lotteryOdds:edit']"
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
          v-hasPermi="['lottery:lotteryOdds:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:lotteryOdds:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lotteryOddsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="号码代码" align="center" prop="hmCode" />
      <el-table-column label="号码名称" align="center" prop="hmName" />
      <el-table-column label="赔率" align="center" prop="odds" />
      <el-table-column label="0:启用 1:停用" align="center" prop="status" />
      <el-table-column label="彩种代码" align="center" prop="lotteryCode" />
      <el-table-column label="盘口代码" align="center" prop="handicapCode" />
      <el-table-column label="盘口名称" align="center" prop="handicapName" />
      <el-table-column label="玩法代码" align="center" prop="playCode" />
      <el-table-column label="玩法名称" align="center" prop="playName" />
      <el-table-column label="排序号" align="center" prop="pxh" />
      <el-table-column label="号码分组" align="center" prop="groupName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:lotteryOdds:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:lotteryOdds:remove']"
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

    <!-- 添加或修改赔率设置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="号码代码" prop="hmCode">
          <el-input v-model="form.hmCode" placeholder="请输入号码代码" />
        </el-form-item>
        <el-form-item label="号码名称" prop="hmName">
          <el-input v-model="form.hmName" placeholder="请输入号码名称" />
        </el-form-item>
        <el-form-item label="赔率" prop="odds">
          <el-input v-model="form.odds" placeholder="请输入赔率" />
        </el-form-item>
        <el-form-item label="彩种代码" prop="lotteryCode">
          <el-input v-model="form.lotteryCode" placeholder="请输入彩种代码" />
        </el-form-item>
        <el-form-item label="盘口代码" prop="handicapCode">
          <el-input v-model="form.handicapCode" placeholder="请输入盘口代码" />
        </el-form-item>
        <el-form-item label="盘口名称" prop="handicapName">
          <el-input v-model="form.handicapName" placeholder="请输入盘口名称" />
        </el-form-item>
        <el-form-item label="玩法代码" prop="playCode">
          <el-input v-model="form.playCode" placeholder="请输入玩法代码" />
        </el-form-item>
        <el-form-item label="玩法名称" prop="playName">
          <el-input v-model="form.playName" placeholder="请输入玩法名称" />
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号" />
        </el-form-item>
        <el-form-item label="号码分组" prop="groupName">
          <el-input v-model="form.groupName" placeholder="请输入号码分组" />
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
import { listLotteryOdds, getLotteryOdds, delLotteryOdds, addLotteryOdds, updateLotteryOdds } from "@/api/lottery/lotteryOdds";

export default {
  name: "LotteryOdds",
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
      // 赔率设置表格数据
      lotteryOddsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        hmCode: null,
        hmName: null,
        odds: null,
        status: null,
        lotteryCode: null,
        handicapCode: null,
        handicapName: null,
        playCode: null,
        playName: null,
        pxh: null,
        groupName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        hmCode: [
          { required: true, message: "号码代码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询赔率设置列表 */
    getList() {
      this.loading = true;
      listLotteryOdds(this.queryParams).then(response => {
        this.lotteryOddsList = response.rows;
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
        hmCode: null,
        hmName: null,
        odds: null,
        status: null,
        lotteryCode: null,
        handicapCode: null,
        handicapName: null,
        playCode: null,
        playName: null,
        createTime: null,
        updateTime: null,
        pxh: null,
        groupName: null
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
      this.title = "添加赔率设置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLotteryOdds(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改赔率设置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLotteryOdds(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLotteryOdds(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除赔率设置编号为"' + ids + '"的数据项？').then(function() {
        return delLotteryOdds(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/lotteryOdds/export', {
        ...this.queryParams
      }, `lotteryOdds_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
