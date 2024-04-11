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
      <el-form-item label="昵称" prop="nickName">
        <el-input
          v-model="queryParams.nickName"
          placeholder="请输入昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="真实姓名" prop="realName">
        <el-input
          v-model="queryParams.realName"
          placeholder="请输入真实姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="余额" prop="balance">-->
<!--        <el-input-->
<!--          v-model="queryParams.balance"-->
<!--          placeholder="请输入余额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="余额宝余额" prop="yebBalance">-->
<!--        <el-input-->
<!--          v-model="queryParams.yebBalance"-->
<!--          placeholder="请输入余额宝余额"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="余额宝利息" prop="yebInterest">-->
<!--        <el-input-->
<!--          v-model="queryParams.yebInterest"-->
<!--          placeholder="请输入余额宝利息"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="登录密码" prop="loginPwd">-->
<!--        <el-input-->
<!--          v-model="queryParams.loginPwd"-->
<!--          placeholder="请输入登录密码"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="支付密码" prop="payPwd">-->
<!--        <el-input-->
<!--          v-model="queryParams.payPwd"-->
<!--          placeholder="请输入支付密码"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="手机号" prop="userPhone">
        <el-input
          v-model="queryParams.userPhone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上级代理" prop="userAgent">
        <el-input
          v-model="queryParams.userAgent"
          placeholder="请输入上级代理"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="邀请码" prop="referralCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.referralCode"-->
<!--          placeholder="请输入邀请码"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="用户头像ID" prop="avatarId">-->
<!--        <el-input-->
<!--          v-model="queryParams.avatarId"-->
<!--          placeholder="请输入用户头像ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="等级ID" prop="levelId">
        <el-input
          v-model="queryParams.levelId"
          placeholder="请输入等级ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="分组ID" prop="groupId">-->
<!--        <el-input-->
<!--          v-model="queryParams.groupId"-->
<!--          placeholder="请输入分组ID"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="最后登录时间" prop="lastTime">-->
<!--        <el-date-picker clearable-->
<!--          v-model="queryParams.lastTime"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="请选择最后登录时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="最后登录IP" prop="lastIp">-->
<!--        <el-input-->
<!--          v-model="queryParams.lastIp"-->
<!--          placeholder="请输入最后登录IP"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="注册IP" prop="registerIp">-->
<!--        <el-input-->
<!--          v-model="queryParams.registerIp"-->
<!--          placeholder="请输入注册IP"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['lottery:userInfo:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['lottery:userInfo:edit']"
        >修改</el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['lottery:userInfo:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:userInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="昵称" align="center" prop="nickName" />
      <el-table-column label="真实姓名" align="center" prop="realName" />
      <el-table-column label="余额" align="center" prop="balance" />
      <el-table-column label="余额宝余额" align="center" prop="yebBalance" />
      <el-table-column label="余额宝利息" align="center" prop="yebInterest" />
      <el-table-column label="状态" align="center" prop="loginStatus" >
        <template v-slot="scope">
          {{ scope.row.loginStatus === 0 ? '正常' : '停用' }}
        </template>
      </el-table-column>
      <el-table-column label="支付状态" align="center" prop="payStatus" >
        <template v-slot="scope">
          {{ scope.row.payStatus === 0 ? '正常' : '停用' }}
        </template>
      </el-table-column>>
      <el-table-column label="手机号" :formatter="formatPhoneNumber" align="center" prop="userPhone" />
      <el-table-column label="上级代理" align="center" prop="userAgent" />
      <el-table-column label="邀请码" align="center" prop="referralCode" />
      <el-table-column label="用户头像ID" align="center" prop="avatarId" />
      <el-table-column label="等级ID" align="center" prop="levelId" />
      <el-table-column label="分组ID" align="center" prop="groupId" />
      <el-table-column label="最后登录时间" align="center" prop="lastTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.lastTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最后登录IP" align="center" prop="lastIp" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="注册IP" align="center" prop="registerIp" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:userInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:userInfo:remove']"
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

    <!-- 添加或修改会员列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="真实姓名" prop="realName">
          <el-input v-model="form.realName" placeholder="请输入真实姓名" />
        </el-form-item>
        <el-form-item label="余额" prop="balance">
          <el-input v-model="form.balance" placeholder="请输入余额" />
        </el-form-item>
        <el-form-item label="余额宝余额" prop="yebBalance">
          <el-input v-model="form.yebBalance" placeholder="请输入余额宝余额" />
        </el-form-item>
        <el-form-item label="余额宝利息" prop="yebInterest">
          <el-input v-model="form.yebInterest" placeholder="请输入余额宝利息" />
        </el-form-item>
        <el-form-item label="手机号" prop="userPhone">
          <el-input v-model="form.userPhone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="上级代理" prop="userAgent">
          <el-input v-model="form.userAgent" placeholder="请输入上级代理" />
        </el-form-item>
        <el-form-item label="邀请码" prop="referralCode">
          <el-input v-model="form.referralCode" placeholder="请输入邀请码" />
        </el-form-item>
        <el-form-item label="用户头像ID" prop="avatarId">
          <el-input v-model="form.avatarId" placeholder="请输入用户头像ID" />
        </el-form-item>
        <el-form-item label="等级ID" prop="levelId">
          <el-input v-model="form.levelId" placeholder="请输入等级ID" />
        </el-form-item>
        <el-form-item label="分组ID" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入分组ID" />
        </el-form-item>
        <el-form-item label="最后登录时间" prop="lastTime">
          <el-date-picker clearable
            v-model="form.lastTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最后登录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最后登录IP" prop="lastIp">
          <el-input v-model="form.lastIp" placeholder="请输入最后登录IP" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="注册IP" prop="registerIp">
          <el-input v-model="form.registerIp" placeholder="请输入注册IP" />
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
import { listUserInfo, getUserInfo, delUserInfo, addUserInfo, updateUserInfo } from "@/api/lottery/userInfo";

export default {
  name: "UserInfo",
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
      // 会员列表表格数据
      userInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        nickName: null,
        realName: null,
        balance: null,
        yebBalance: null,
        yebInterest: null,
        loginPwd: null,
        payPwd: null,
        loginStatus: null,
        payStatus: null,
        userPhone: null,
        userAgent: null,
        referralCode: null,
        avatarId: null,
        levelId: null,
        groupId: null,
        lastTime: null,
        lastIp: null,
        registerIp: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        loginPwd: [
          { required: true, message: "登录密码不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    formatPhoneNumber(row) {
      // 将中间四位数字替换为星号
      const maskedNumber = row.userPhone.replace(/^(\d{3})\d{4}(\d{4})$/, '$1****$2');
      return maskedNumber;
    },
    /** 查询会员列表列表 */
    getList() {
      this.loading = true;
      listUserInfo(this.queryParams).then(response => {
        this.userInfoList = response.rows;
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
        nickName: null,
        realName: null,
        balance: null,
        yebBalance: null,
        yebInterest: null,
        loginPwd: null,
        payPwd: null,
        loginStatus: null,
        payStatus: null,
        userPhone: null,
        userAgent: null,
        referralCode: null,
        avatarId: null,
        levelId: null,
        groupId: null,
        createTime: null,
        updateTime: null,
        lastTime: null,
        lastIp: null,
        remark: null,
        registerIp: null
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
      this.title = "添加会员列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUserInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateUserInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除会员列表编号为"' + ids + '"的数据项？').then(function() {
        return delUserInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/userInfo/export', {
        ...this.queryParams
      }, `userInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
