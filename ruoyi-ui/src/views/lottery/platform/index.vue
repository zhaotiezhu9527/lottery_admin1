<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="平台大类" prop="platCode">
        <el-input
          v-model="queryParams.platCode"
          placeholder="请输入平台大类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平台名称" prop="platName">
        <el-input
          v-model="queryParams.platName"
          placeholder="请输入平台名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平台子类" prop="subPlatCode">
        <el-input
          v-model="queryParams.subPlatCode"
          placeholder="请输入平台子类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="子平台名称" prop="subPlatName">
        <el-input
          v-model="queryParams.subPlatName"
          placeholder="请输入子平台名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="返水比例" prop="ratio">
        <el-input
          v-model="queryParams.ratio"
          placeholder="请输入返水比例"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="维护信息" prop="maintenanceMsg">
        <el-input
          v-model="queryParams.maintenanceMsg"
          placeholder="请输入维护信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图标" prop="img1">
        <el-input
          v-model="queryParams.img1"
          placeholder="请输入图标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="排序(值越大越靠前)" prop="pxh">
        <el-input
          v-model="queryParams.pxh"
          placeholder="请输入排序(值越大越靠前)"
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
          v-hasPermi="['lottery:platform:add']"
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
          v-hasPermi="['lottery:platform:edit']"
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
          v-hasPermi="['lottery:platform:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:platform:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="platformList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="平台大类" align="center" prop="platCode" />
      <el-table-column label="平台名称" align="center" prop="platName" />
      <el-table-column label="平台子类" align="center" prop="subPlatCode" />
      <el-table-column label="子平台名称" align="center" prop="subPlatName" />
      <el-table-column label="平台类型 1:真人 2:电子 3:体育 4:棋牌 5:捕鱼" align="center" prop="platType" />
      <el-table-column label="返水比例" align="center" prop="ratio" />
      <el-table-column label="0:启用 1:停用" align="center" prop="status" />
      <el-table-column label="0:正常 1:维护" align="center" prop="maintenanceStatus" />
      <el-table-column label="维护信息" align="center" prop="maintenanceMsg" />
      <el-table-column label="图标" align="center" prop="img1" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="排序(值越大越靠前)" align="center" prop="pxh" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:platform:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:platform:remove']"
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

    <!-- 添加或修改平台管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="平台大类" prop="platCode">
          <el-input v-model="form.platCode" placeholder="请输入平台大类" />
        </el-form-item>
        <el-form-item label="平台名称" prop="platName">
          <el-input v-model="form.platName" placeholder="请输入平台名称" />
        </el-form-item>
        <el-form-item label="平台子类" prop="subPlatCode">
          <el-input v-model="form.subPlatCode" placeholder="请输入平台子类" />
        </el-form-item>
        <el-form-item label="子平台名称" prop="subPlatName">
          <el-input v-model="form.subPlatName" placeholder="请输入子平台名称" />
        </el-form-item>
        <el-form-item label="返水比例" prop="ratio">
          <el-input v-model="form.ratio" placeholder="请输入返水比例" />
        </el-form-item>
        <el-form-item label="维护信息" prop="maintenanceMsg">
          <el-input v-model="form.maintenanceMsg" placeholder="请输入维护信息" />
        </el-form-item>
        <el-form-item label="图标" prop="img1">
          <el-input v-model="form.img1" placeholder="请输入图标" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="排序(值越大越靠前)" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序(值越大越靠前)" />
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
import { listPlatform, getPlatform, delPlatform, addPlatform, updatePlatform } from "@/api/lottery/platform";

export default {
  name: "Platform",
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
      // 平台管理表格数据
      platformList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        platCode: null,
        platName: null,
        subPlatCode: null,
        subPlatName: null,
        platType: null,
        ratio: null,
        status: null,
        maintenanceStatus: null,
        maintenanceMsg: null,
        img1: null,
        pxh: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        platCode: [
          { required: true, message: "平台大类不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询平台管理列表 */
    getList() {
      this.loading = true;
      listPlatform(this.queryParams).then(response => {
        this.platformList = response.rows;
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
        platCode: null,
        platName: null,
        subPlatCode: null,
        subPlatName: null,
        platType: null,
        ratio: null,
        status: null,
        maintenanceStatus: null,
        maintenanceMsg: null,
        img1: null,
        createTime: null,
        updateTime: null,
        remark: null,
        pxh: null
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
      this.title = "添加平台管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPlatform(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改平台管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePlatform(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPlatform(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除平台管理编号为"' + ids + '"的数据项？').then(function() {
        return delPlatform(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/platform/export', {
        ...this.queryParams
      }, `platform_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
