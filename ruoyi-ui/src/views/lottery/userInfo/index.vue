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
      <el-form-item label="时间" prop="orderTime">
        <el-date-picker
          v-model="dateRange"
          style="width: 340px"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
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
         icon="el-icon-plus"
         size="mini"
         @click="handleAdd"
         v-hasPermi="['lottery:userInfo:add']"
       >新增会员</el-button>
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

    <el-table v-loading="loading" :data="userInfoList">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="昵称" align="center" prop="nickName" />
      <el-table-column label="余额" align="center" prop="balance" />
      <el-table-column label="登录状态" align="center" prop="loginStatus" >
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.loginStatus"
            @change="changeStatus(scope.row.id,scope.row.loginStatus,'login')"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="支付状态" align="center" prop="payStatus" >
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.payStatus"
            @change="changeStatus(scope.row.id,scope.row.payStatus,'pay')"
            :active-value="0"
            :inactive-value="1"
            active-color="#13ce66"
            inactive-color="#ff4949">
          </el-switch>
        </template>
      </el-table-column>
      <el-table-column label="上级代理" align="center" prop="userAgent" />
      <el-table-column label="邀请码" align="center" prop="referralCode" />
      <el-table-column label="IP/时间信息" align="center" prop="lastTime" width="180">
        <template slot="header">
          <div>注册IP</div>
          <div>注册时间</div>
        </template>
        <template slot-scope="scope">
          <div><a class="curpor" :href="'https://ip138.com/iplookup.php?ip=' + scope.row.registerIp" target="_blank">{{ scope.row.registerIp }}</a></div>
          <div>{{ scope.row.createTime }}</div>
        </template>
      </el-table-column>
      <el-table-column label="IP/时间信息" align="center" prop="lastTime" width="180">
        <template slot="header">
          <div>最后登陆IP</div>
          <div>最后登陆时间</div>
        </template>
        <template slot-scope="scope">
          <div><a class="curpor" :href="'https://ip138.com/iplookup.php?ip=' + scope.row.lastIp" target="_blank">{{ scope.row.lastIp }}</a></div>
          <div>{{ scope.row.lastTime }}</div>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:userInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            v-hasPermi="['lottery:userInfo:optMoney']"
            @click="moneyUpdate(scope.row,'up')"
          >上分</el-button>
          <el-button
            size="mini"
            type="text"
            @click="moneyUpdate(scope.row,'down')"
            v-hasPermi="['lottery:userInfo:optMoney']"
          >下分</el-button>
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
        <el-form-item label="登录密码">
          <el-input v-model="form.loginPwd" placeholder="不输入表示不修改" />
        </el-form-item>
        <el-form-item label="支付密码">
          <el-input v-model="form.payPwd" placeholder="不输入表示不修改" />
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
    <!-- 增减余额对话框 -->
    <el-dialog :title="moneyTitle" :visible.sync="balanceOpen" width="500px" append-to-body>
      <el-form ref="balanceform" :model="balanceForm" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="userName">
          <el-input :disabled="true" v-model="balanceForm.userName" placeholder="请输入4-12位数字或字母" />
        </el-form-item>
        <el-form-item label="金额" prop="money">
          <!-- <el-input v-model="balanceForm.money" placeholder="请输入金额" /> -->
          <el-input-number v-model="balanceForm.money" :min="1" label="请输入金额"></el-input-number>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="balanceForm.remark" placeholder="请填写备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="balanceSub">确 定</el-button>
        <el-button @click="balanceOpen = false">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 添加对话框 -->
    <el-dialog title="添加会员" :visible.sync="addOpen" width="500px" append-to-body>
      <el-form ref="addform" :model="addForm" :rules="rules" label-width="120px">
        <!-- <el-form-item label="代理用户名">
          <el-input v-model="addForm.userAgent" placeholder="请输入推荐人用户名" />
        </el-form-item> -->
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="addForm.userName" placeholder="请输入4-12位数字或字母" />
        </el-form-item>
        <!-- <el-form-item label="昵称" prop="nickName">
          <el-input v-model="addForm.nickName" placeholder="请输入4-12位数字或字母" />
        </el-form-item> -->
        <el-form-item label="密码" prop="loginPwd">
          <el-input v-model="addForm.loginPwd" placeholder="请输入6-12位数字或字母" />
        </el-form-item>
        <!-- <el-form-item label="支付密码" prop="payPwd">
          <el-input v-model="addForm.payPwd" placeholder="请输入6位数字" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="addSub">确 定</el-button>
        <el-button @click="addCancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listUserInfo, getUserInfo, delUserInfo, addUserInfo, updateUserInfo,userInfoOptMoney } from "@/api/lottery/userInfo";
import { dateFormat } from '@/utils/auth'


export default {
  name: "UserInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
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
        loginStatus: null,
        payStatus: null,
        userAgent: null,
        isAsc:'desc',
        orderByColumn:'u.create_time'
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
      },
      // 时间
      dateRange:[],
      balanceOpen: false,//上下分弹窗
      // 增减余额表单数据
      balanceForm: {
        remark:'',
      },
      moneyTitle:'',//上下分标题
      // 是否显示添加弹出层
      addOpen: false,
      // 表单参数
      addForm: {},
    };
  },
  created() {
    // this.getDefaultTime();
    this.getList();
  },
  methods: {
    // formatPhoneNumber(row) {
    //   // 将中间四位数字替换为星号
    //   const maskedNumber = row.userPhone.replace(/^(\d{3})\d{4}(\d{4})$/, '$1****$2');
    //   return maskedNumber;
    // },
    /** 查询会员列表列表 */
    getList() {
      this.loading = true;
      listUserInfo(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
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
        balance: null,
        loginPwd: null,
        payPwd: null,
        userAgent: null,
        remark: null,
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
    },
    addSub(){
      this.$refs["addform"].validate(valid => {
        if (valid) {
          addUserInfo(this.addForm).then(response => {
            this.$modal.msgSuccess("新增成功");
            this.addOpen = false;
            this.getList();
          });
        }
      });
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id
      getUserInfo(id).then(response => {
        this.form = response.data;
        this.form.loginPwd = ''
        this.form.payPwd = ''
        this.open = true;
        this.title = "修改会员列表";
      });
    },
    // 添加取消按钮
    addCancel() {
      this.addOpen = false;
      this.adReset();
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
    },
    // 默认时间
    getDefaultTime() {
      let end = new Date();
      let start = new Date();
      start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
      this.dateRange[0] = dateFormat("YYYY-mm-dd" , end) + ' 00:00:00'
      this.dateRange[1] = dateFormat("YYYY-mm-dd" , end) + ' 23:59:59'
    },
    // 停启用状态
    changeStatus(id,status,type){
      let obj = { 
      }
      if(type === 'login'){
        obj = {
          id: id,
          loginStatus: status,
        }
      }else if(type === 'pay'){
        obj = {
          id: id,
          payStatus: status,
        }
      }
      updateUserInfo(obj).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
    // 增减余额
    moneyUpdate(data,type){
      // this.balanceReset();
      if(type === 'up'){
        this.moneyTitle = '会员上分'
        this.balanceForm.type = 1
      }else if(type === 'down'){
        this.moneyTitle = '会员下分'
        this.balanceForm.type = 2
      }
      this.balanceOpen = true;
      this.balanceForm.userName = data.userName
    },
    // 上下分提交
    balanceSub(){
      this.$refs["balanceform"].validate(valid => {
        if (valid) {
          userInfoOptMoney(this.balanceForm).then(response => {
            this.$modal.msgSuccess("操作成功");
            this.balanceOpen = false;
            this.getList();
          });
        }
      });
    },
  }
};
</script>
