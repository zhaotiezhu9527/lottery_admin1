<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['lottery:avatar:add']"
        >新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="avatarList">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="会员头像" align="center" prop="avatarImg" width="180">
        <template slot-scope="scope">
          <image-preview :src="scope.row.avatarImg" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status">
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
      <el-table-column label="排序号(值越大越靠前)" align="center" prop="pxh" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:avatar:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:avatar:remove']"
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

    <!-- 添加或修改头像管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body :loading="loading">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="头像" prop="avatarImg">
          <el-upload
              class="avatar-uploader"
              :action="upload.url"
              :file-list="upload.fileList"
              :headers="upload.headers"
              :show-file-list="false"
              :on-success="successHandle"
              :before-upload="beforeUploadHandle">
              <img v-if="form.avatarImg" :src="resourceDomain + form.avatarImg" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号(值越大越靠前)" />
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
import { listAvatar, getAvatar, delAvatar, addAvatar, updateAvatar } from "@/api/lottery/avatar";
import Cookies from "js-cookie";
import { getToken } from "@/utils/auth"; 

export default {
  name: "Avatar",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 头像管理表格数据
      avatarList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 上传参数
      upload: {
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/sysFileInfo/upload?pathType=1",
        // 上传的文件列表
        fileList: []
      },
      resourceDomain:"",//域名
    };
  },
  created() {
    this.getList();
    this.getCookie()
  },
  methods: {
    /** 查询头像管理列表 */
    getList() {
      this.loading = true;
      listAvatar(this.queryParams).then(response => {
        this.avatarList = response.rows;
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
        avatarImg: null,
        pxh: null,
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
      this.title = "添加头像管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAvatar(id).then(response => {
        this.form.avatarImg = response.data.avatarImg
        this.form.id = response.data.id
        this.form.pxh = response.data.pxh
        this.open = true;
        this.title = "修改头像管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAvatar(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAvatar(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除头像管理编号为"' + ids + '"的数据项？').then(function() {
        return delAvatar(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/avatar/export', {
        ...this.queryParams
      }, `avatar_${new Date().getTime()}.xlsx`)
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
        this.form.avatarImg = response.data ;
      } else {
        // this.$message.error(response.msg)
      }
      // this.open = false
    },
    // 获取域名
    getCookie() {
      this.resourceDomain = Cookies.get("resourceDomain");
    },
    // 修改冻结状态
    changeStatus(id,status){
      updateAvatar({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
  }
};
</script>
