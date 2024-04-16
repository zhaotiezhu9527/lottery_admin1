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
          type="primary"
          plain
          size="mini"
          @click="handleAdd"
          v-hasPermi="['lottery:openresultHklhc:add']"
        >新增排期</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:openresultHklhc:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="openresultList">
      <el-table-column label="期号" align="center" prop="qs" />
      <el-table-column label="开奖号码" align="center" prop="openResult" />
      <el-table-column label="开奖状态" align="center" prop="openStatus" >
        <template slot-scope="scope">
          <div v-if="scope.row.openStatus === 0">已开奖</div>
          <div v-else-if="scope.row.openStatus === 1">未开奖</div>
        </template>
      </el-table-column>
      <el-table-column label="开盘时间" align="center" prop="openTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="封盘时间" align="center" prop="closeTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.closeTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开奖时间" align="center" prop="openResultTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.openResultTime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:openresultHklhc:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:openresultHklhc:remove']"
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

    <!-- 修改开奖结果对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="期号" prop="qs">
          <el-input v-model="form.qs" :disabled="true" placeholder="请输入期号" />
        </el-form-item>
        <el-form-item label="开奖号码" prop="openResult">
          <el-input v-model="form.openResult" placeholder="请输入开奖号码" />
        </el-form-item>
        <el-form-item label="开盘时间" prop="openTime">
          <el-date-picker clearable
            v-model="form.openTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="封盘时间" prop="closeTime">
          <el-date-picker clearable
            v-model="form.closeTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开奖时间" prop="openResultTime">
          <el-date-picker clearable
            v-model="form.openResultTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加对话框 -->
    <el-dialog :title="title" :visible.sync="addOpen" width="500px" append-to-body>
      <el-form ref="addForm" :model="addForm" :rules="rules" label-width="80px">
        <el-form-item label="期号" prop="qs">
          <el-input v-model="addForm.qs" placeholder="请输入期号" />
        </el-form-item>
        <el-form-item label="开盘时间" prop="openTime">
          <el-date-picker clearable
            v-model="addForm.openTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="封盘时间" prop="closeTime">
          <el-date-picker clearable
            v-model="addForm.closeTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="开奖时间" prop="openResultTime">
          <el-date-picker clearable
            v-model="addForm.openResultTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="请选择开盘时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFormAdd">确 定</el-button>
        <el-button @click="addOpen = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOpenresultHklhc, getOpenresultHklhc, delOpenresultHklhc,updateOpenresultHklhc,addOpenresultHklhc } from "@/api/lottery/openresultHklhc";
import { dateFormat,pickerOptions } from '@/utils/auth'

export default {
  name: "OpenresultHklhc",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 开奖结果表格数据
      openresultList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        qs: null,
        isAsc:'desc',
        orderByColumn:'open_result_time'
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        qs: [
          { required: true, message: "期号不能为空", trigger: "blur" }
        ],
        openTime: [
          { required: true, message: "请选择开盘时间", trigger: "blur" }
        ],
        closeTime: [
          { required: true, message: "请选择封盘时间", trigger: "blur" }
        ],
        openResultTime: [
          { required: true, message: "请选择开奖时间", trigger: "blur" }
        ],
      },
      pickerOptions: pickerOptions,
      // 时间
      dateRange:[],
      addOpen: false,//新增排期弹窗状态
      // 新增排期表单参数
      addForm: {},
    };
  },
  created() {
    // this.getDefaultTime();
    this.getList();
  },
  methods: {
    /** 查询开奖结果(快3)列表 */
    getList() {
      this.loading = true;
      listOpenresultHklhc(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.openresultList = response.rows;
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
        openResult: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.addOpen = true;
      this.title = "新增排期";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOpenresultHklhc(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改开奖结果";
      });
    },
    /** 提交按钮 */
    submitForm() {
      let obj = {
        id:this.form.id,
        openResult:this.form.openResult,
        openTime:this.form.openTime,
        closeTime:this.form.closeTime,
        openResultTime:this.form.openResultTime,
      }
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOpenresultHklhc(obj).then(response => {
              this.$modal.msgSuccess("修改成功");
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
      this.$modal.confirm('是否确认删除开奖结果编号为"' + ids + '"的数据项？').then(function() {
        return delOpenresultHklhc(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/openresultHklhc/export', {
        ...this.queryParams
      }, `openresultHklhc_${new Date().getTime()}.xlsx`)
    },
    getDefaultTime() {
      let end = new Date();
      let start = new Date();
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
      this.dateRange[0] = dateFormat("YYYY-mm-dd" , end) + ' 00:00:00'
      this.dateRange[1] = dateFormat("YYYY-mm-dd" , end) + ' 23:59:59'
    },
    /** 新增排期 */
    submitFormAdd() {
      this.$refs["addForm"].validate(valid => {
        if (valid) {
          addOpenresultHklhc(this.addForm).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.addOpen = false;
            this.getList();
          });
        }
      });
    },
  }
};
</script>
