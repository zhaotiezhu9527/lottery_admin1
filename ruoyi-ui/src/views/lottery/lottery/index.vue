<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-form-item label="彩种名称" prop="lotteryName">
        <el-input
          v-model="queryParams.lotteryName"
          placeholder="请输入彩种名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型">
        <el-select v-model="queryParams.lotteryType" placeholder="请选择">
          <el-option
            v-for="item in typeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="lotteryList" >
      <el-table-column label="彩种名称" align="center" prop="lotteryName" />
      <el-table-column label="彩种图标" align="center" prop="img">
        <template slot-scope="scope">
          <image-preview :src="scope.row.img" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="lotteryType" >
        <template slot-scope="scope">
          <div v-if="scope.row.lotteryType === 1">快三</div>
          <div v-else-if="scope.row.lotteryType === 2">时时彩</div>
          <div v-else-if="scope.row.lotteryType === 3">PK10</div>
          <div v-else-if="scope.row.lotteryType === 4">六合彩</div>
          <div v-else-if="scope.row.lotteryType === 5">PC蛋蛋</div>
          <div v-else-if="scope.row.lotteryType === 6">十一选五</div>
          <div v-else-if="scope.row.lotteryType === 8">快乐八</div>
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
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="排序号(值越大越靠前)" align="center" prop="pxh" />
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
        <el-form-item label="彩种名称" prop="lotteryName">
          <el-input v-model="form.lotteryName" placeholder="请输入彩种名称" />
        </el-form-item>
        <el-form-item label="图标" prop="img" v-loading="loading">
          <el-upload
              class="avatar-uploader"
              :action="upload.url"
              :file-list="upload.fileList"
              :headers="upload.headers"
              :show-file-list="false"
              :on-success="successHandle"
              :before-upload="beforeUploadHandle">
              <img v-if="form.img" :src="resourceDomain + form.img" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="排序号" prop="pxh">
          <el-input v-model="form.pxh" placeholder="请输入排序号(值越大越靠前)" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
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
import Cookies from "js-cookie";
import { getToken } from "@/utils/auth"; 

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
        lotteryName: null,
        lotteryType: "",
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        lotteryCode: [
          { required: true, message: "彩种代码不能为空", trigger: "blur" }
        ],
      },
      typeList: [
        { label: '全部', value: ''},
        { label: '快三', value: 1},
        { label: '时时彩', value: 2},
        { label: 'PK10', value: 3},
        { label: '六合彩', value: 4},
        { label: 'PC蛋蛋', value: 5},
        { label: '快乐八', value: 6},
        { label: '十一选五', value: 8},
      ],//状态
      resourceDomain:"",//域名
      // 上传参数
      upload: {
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/sysFileInfo/upload?pathType=2",
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
        lotteryName: null,
        lotteryType: "",
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
      this.title = "添加彩种管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLottery(id).then(response => {
        this.form.id = response.data.id;
        this.form.lotteryName = response.data.lotteryName;
        this.form.img = response.data.img;
        this.form.pxh = response.data.pxh;
        this.form.remark = response.data.remark;
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
    },
    // 获取域名
    getCookie() {
      this.resourceDomain = Cookies.get("resourceDomain");
    },
    // 停启用状态
    changeStatus(id,status){
      updateLottery({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
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
        this.form.img = response.data ;
      } else {
        // this.$message.error(response.msg)
      }
      // this.open = false
    },
  }
};
</script>
