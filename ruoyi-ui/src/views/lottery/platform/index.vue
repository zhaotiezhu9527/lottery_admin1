<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="平台名称" prop="platName">
        <el-input
          v-model="queryParams.platName"
          placeholder="请输入平台名称"
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

    <el-table v-loading="loading" :data="platformList">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="平台名称" align="center" prop="platName" />
      <el-table-column label="子平台名称" align="center" prop="subPlatName" />
      <el-table-column label="图标" align="center" prop="img1" >
        <template slot-scope="scope">
          <image-preview :src="scope.row.img1" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="platType">
        <template slot-scope="scope">
          <div v-if="scope.row.platType === 1">真人</div>
          <div v-else-if="scope.row.platType === 2">电子</div>
          <div v-else-if="scope.row.platType === 3">体育</div>
          <div v-else-if="scope.row.platType === 4">棋牌</div>
          <div v-else-if="scope.row.platType === 5">捕鱼</div>
        </template>
      </el-table-column>
      <el-table-column label="返水比例" align="center" prop="ratio">
        <template slot-scope="scope">
          <div>{{scope.row.ratio}}%</div>
        </template>
      </el-table-column>
      <el-table-column label="开启状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            @change="changeStatus(scope.row.id,scope.row.status,'kaiguan')"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="维护状态" align="center" prop="maintenanceStatus">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.maintenanceStatus"
            @change="changeStatus(scope.row.id,scope.row.maintenanceStatus,'weihu')"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="维护信息" align="center" prop="maintenanceMsg" />
      
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="排序" align="center" prop="pxh" />
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
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="120px">
        <el-form-item label="平台名称" prop="platName">
          <el-input v-model="form.platName" placeholder="请输入平台名称" />
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
        <el-form-item label="图标" prop="img1" v-loading="loading">
          <el-upload
              class="avatar-uploader"
              :action="upload.url"
              :file-list="upload.fileList"
              :headers="upload.headers"
              :show-file-list="false"
              :on-success="successHandle"
              :before-upload="beforeUploadHandle">
              <img v-if="form.img1" :src="resourceDomain + form.img1" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="排序" prop="pxh">
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
import Cookies from "js-cookie";
import { getToken } from "@/utils/auth"; 

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
        pageSize: 20,
        platName: null,
        platType: null,
        status: null,
        maintenanceStatus: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        platCode: [
          { required: true, message: "平台大类不能为空", trigger: "blur" }
        ],
      },
      resourceDomain:"",//域名
      // 上传参数
      upload: {
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/sysFileInfo/upload?pathType=4",
        // 上传的文件列表
        fileList: []
      },
    };
  },
  created() {
    this.getList();
    this.getCookie()
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
        platName: null,
        subPlatName: null,
        img1: null,
        remark: null,
        pxh: null,
        maintenanceMsg: null,
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
        this.form.id = response.data.id;
        this.form.platName = response.data.platName;
        this.form.subPlatName = response.data.subPlatName;
        this.form.img1 = response.data.img1;
        this.form.ratio = response.data.ratio;
        this.form.remark = response.data.remark;
        this.form.pxh = response.data.pxh;
        this.form.maintenanceMsg = response.data.maintenanceMsg;
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
    },
    // 停启用状态
    changeStatus(id,status,type){
      let obj = {}
      if(type === 'kaiguan'){
        obj = {
          id:id,
          status:status,
        }
      }else if(type === 'weihu'){
        obj = {
          id:id,
          maintenanceStatus:status,
        }
      }
      updatePlatform(obj).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
     // 获取域名
     getCookie() {
      this.resourceDomain = Cookies.get("resourceDomain");
    },
    beforeUploadHandle (file) {
      this.open = true
      this.loading = true
      if (file.type !== 'image/jpg' && file.type !== 'image/jpeg' && file.type !== 'image/png' && file.type !== 'image/gif') {
        this.$message.error('只支持jpg、png、gif格式的图片！')
        return false
      }
    },
    // 上传成功
    successHandle (response, file, fileList) {
      this.fileList = fileList
      if (response && response.code === 200) {
        this.loading = false
        this.form.img1 = response.data ;
      } else {
        // this.$message.error(response.msg)
      }
      // this.open = false
    },
  }
};
</script>
