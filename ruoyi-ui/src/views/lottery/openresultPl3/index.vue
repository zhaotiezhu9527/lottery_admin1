<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="期号" prop="qs">
        <el-input
          v-model="queryParams.qs"
          placeholder="请输入期号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="三方期号" prop="platQs">
        <el-input
          v-model="queryParams.platQs"
          placeholder="请输入三方期号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开奖号码" prop="openResult">
        <el-input
          v-model="queryParams.openResult"
          placeholder="请输入开奖号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前第N期" prop="currCount">
        <el-input
          v-model="queryParams.currCount"
          placeholder="请输入当前第N期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开盘时间" prop="openTime">
        <el-date-picker clearable
          v-model="queryParams.openTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开盘时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="封盘时间" prop="closeTime">
        <el-date-picker clearable
          v-model="queryParams.closeTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择封盘时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="开奖时间" prop="openResultTime">
        <el-date-picker clearable
          v-model="queryParams.openResultTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开奖时间">
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
          v-hasPermi="['lottery:openresultPl3:add']"
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
          v-hasPermi="['lottery:openresultPl3:edit']"
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
          v-hasPermi="['lottery:openresultPl3:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:openresultPl3:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="openresultPl3List" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="期号" align="center" prop="qs" />
      <el-table-column label="三方期号" align="center" prop="platQs" />
      <el-table-column label="开奖号码" align="center" prop="openResult" />
      <el-table-column label="0:已开奖 1:未开奖" align="center" prop="openStatus" />
      <el-table-column label="当前第N期" align="center" prop="currCount" />
      <el-table-column label="开盘时间" align="center" prop="openTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="封盘时间" align="center" prop="closeTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.closeTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开奖时间" align="center" prop="openResultTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openResultTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:openresultPl3:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:openresultPl3:remove']"
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

    <!-- 添加或修改排列3对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="期号" prop="qs">
          <el-input v-model="form.qs" placeholder="请输入期号" />
        </el-form-item>
        <el-form-item label="三方期号" prop="platQs">
          <el-input v-model="form.platQs" placeholder="请输入三方期号" />
        </el-form-item>
        <el-form-item label="开奖号码" prop="openResult">
          <el-input v-model="form.openResult" placeholder="请输入开奖号码" />
        </el-form-item>
        <el-form-item label="当前第N期" prop="currCount">
          <el-input v-model="form.currCount" placeholder="请输入当前第N期" />
        </el-form-item>
        <el-form-item label="开盘时间" prop="openTime">
          <el-date-picker clearable
            v-model="form.openTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="封盘时间" prop="closeTime">
          <el-date-picker clearable
            v-model="form.closeTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择封盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开奖时间" prop="openResultTime">
          <el-date-picker clearable
            v-model="form.openResultTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开奖时间">
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
import { listOpenresultPl3, getOpenresultPl3, delOpenresultPl3, addOpenresultPl3, updateOpenresultPl3 } from "@/api/lottery/openresultPl3";

export default {
  name: "OpenresultPl3",
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
      // 排列3表格数据
      openresultPl3List: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        qs: null,
        platQs: null,
        openResult: null,
        openStatus: null,
        currCount: null,
        openTime: null,
        closeTime: null,
        openResultTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        qs: [
          { required: true, message: "期号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询排列3列表 */
    getList() {
      this.loading = true;
      listOpenresultPl3(this.queryParams).then(response => {
        this.openresultPl3List = response.rows;
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
        qs: null,
        platQs: null,
        openResult: null,
        openStatus: null,
        currCount: null,
        openTime: null,
        closeTime: null,
        openResultTime: null,
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
      this.title = "添加排列3";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOpenresultPl3(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改排列3";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOpenresultPl3(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOpenresultPl3(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除排列3编号为"' + ids + '"的数据项？').then(function() {
        return delOpenresultPl3(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/openresultPl3/export', {
        ...this.queryParams
      }, `openresultPl3_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
