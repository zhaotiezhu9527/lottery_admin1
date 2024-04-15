<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="活动标题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入活动标题"
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
          v-hasPermi="['lottery:activity:add']"
        >新增</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="activityList">
      
      <el-table-column label="活动标题" align="center" prop="title" />
      <el-table-column label="封面图" align="center" prop="img1" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.img1" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="内容图" align="center" prop="img2" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.img2" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            @change="changeStatus(scope.row.id,scope.row.status)"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作人" align="center" prop="operName" />
      <el-table-column label="排序号" align="center" prop="pxh" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:activity:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:activity:remove']"
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

    <!-- 添加或修改活动配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="活动标题">
          <el-input v-model="form.title" placeholder="请输入活动标题" />
        </el-form-item>
        <el-form-item label="封面图" prop="img1" v-loading="loading">
          <el-upload
              class="avatar-uploader"
              :action="upload.url"
              :file-list="upload.fileList"
              :headers="upload.headers"
              :show-file-list="false"
              :on-success="
                (res) => {
                  return successHandle(res,'title')
                }"
              :before-upload="beforeUploadHandle">
              <img v-if="form.img1" :src="resourceDomain + form.img1" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="内容图" prop="img2" v-loading="loading">
          <el-upload
              class="avatar-uploader"
              :action="upload.url"
              :file-list="upload.fileList"
              :headers="upload.headers"
              :show-file-list="false"
              :on-success="
                (res) => {
                  return successHandle(res,'content')
                }"
              :before-upload="beforeUploadHandle">
              <img v-if="form.img2" :src="resourceDomain + form.img2" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号" />
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
import { listActivity, getActivity, delActivity, addActivity, updateActivity } from "@/api/lottery/activity";
import Cookies from "js-cookie";
import { getToken } from "@/utils/auth"; 

export default {
  name: "Activity",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 活动配置表格数据
      activityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        status: null,
        operName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        title: [
          { required: true, message: "活动标题不能为空", trigger: "blur" }
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
    /** 查询活动配置列表 */
    getList() {
      this.loading = true;
      listActivity(this.queryParams).then(response => {
        this.activityList = response.rows;
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
        title: null,
        img1: null,
        img2: null,
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
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加活动配置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getActivity(id).then(response => {
        this.form.id = response.data.id;
        this.form.title = response.data.title;
        this.form.img1 = response.data.img1;
        this.form.img2 = response.data.img2;
        this.form.pxh = response.data.pxh;
        this.open = true;
        this.title = "修改活动配置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateActivity(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addActivity(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除活动配置编号为"' + ids + '"的数据项？').then(function() {
        return delActivity(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/activity/export', {
        ...this.queryParams
      }, `activity_${new Date().getTime()}.xlsx`)
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
    successHandle (response,type) {
      if (response && response.code === 200) {
        if(type === 'title'){
          this.form.img1 = response.data ;
        }else if(type === 'content'){
          this.form.img2 = response.data ;
        }
        this.loading = false
      } else {
        // this.$message.error(response.msg)
        this.loading = false
      }
      // this.open = false
    },
     // 获取域名
    getCookie() {
      this.resourceDomain = Cookies.get("resourceDomain");
    },
    // 停启用状态
    changeStatus(id,status){
      updateActivity({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
  }
};
</script>
