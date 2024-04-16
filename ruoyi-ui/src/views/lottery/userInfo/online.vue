<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="在线会员">
        <span class="red-text">{{ total }}人</span>
      </el-form-item>
      <el-form-item label="用户名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="loading" :data="userList">
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="昵称" align="center" prop="nickName" />
      <el-table-column label="余额" align="center" prop="balance" >
        <template slot-scope="scope">
          <div class="red-text">{{ scope.row.balance }}</div>
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
            size="small"
            type="danger"
            icon="el-icon-warning"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:user:remove']"
          >踢下线</el-button>
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

  </div>
</template>

<script>
import { userInfoOnlineList,kickOnline } from "@/api/lottery/userInfo";

export default {
  name: "User",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 选中数组
      ids: [],
      // 总条数
      total: 0,
      // 会员列表表格数据
      userList: [],
      // 查询参数
      queryParams: {
        userName: null,
      },
      total: 0,//在线会员数量
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询会员列表列表 */
    getList() {
      this.loading = true;
      userInfoOnlineList().then(response => {
        this.userList = response.rows;
        this.total = response.total
        this.loading = false;
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      let self = this
      this.$modal.confirm('是否确认踢掉会员？').then(function() {
        kickOnline({
          userName: row.userName
        }).then(response => {
          self.$modal.msgSuccess("操作成功");
          self.getList();
        });
      })
    },
  }
};
</script>
