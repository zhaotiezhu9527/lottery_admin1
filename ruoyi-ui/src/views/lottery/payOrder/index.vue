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
      <el-form-item label="订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="三方订单" prop="payOrderNo">
        <el-input
          v-model="queryParams.payOrderNo"
          placeholder="请输入三方订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商户名称">
        <el-select v-model="queryParams.merchantCode" placeholder="请选择">
          <el-option value="" label="所有商户"></el-option>
          <el-option
            v-for="item in payMerchantList"
            :key="item.merchantCode"
            :label="item.merchantName"
            :value="item.merchantCode">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.status" placeholder="请选择">
          <el-option
            v-for="item in typeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:payOrder:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="payOrderList" @selection-change="handleSelectionChange">
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="订单号" align="center" prop="orderNo" />
      <el-table-column label="商户名称" align="center" prop="merchantName" />
      <el-table-column label="通道名称" align="center" prop="channelName" />
      <el-table-column label="三方订单号" align="center" prop="payOrderNo" />
      <el-table-column label="金额" align="center" prop="amount" >
        <template slot-scope="scope">
          <span class="red-text">{{ scope.row.amount }}</span>
        </template>
      </el-table-column>
      <el-table-column label="支付状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-tag type="warning" v-if="scope.row.status === 0">未支付</el-tag>
          <el-tag type="success" v-else-if="scope.row.status === 1">支付成功</el-tag>
          <el-tag type="danger" v-else-if="scope.row.status === 2">支付失败</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="备注" align="center" prop="remark" />
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:payOrder:remove']"
          >删除</el-button>
        </template>
      </el-table-column> -->
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
import { listPayOrder, delPayOrder } from "@/api/lottery/payOrder";
import { listPayMerchant } from "@/api/lottery/payMerchant";
import { pickerOptions } from '@/utils/auth'

export default {
  name: "PayOrder",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 支付订单表格数据
      payOrderList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        payOrderNo: null,
        status: "",
        merchantCode: "",
        isAsc:'desc',
        orderByColumn:'id'
      },
      typeList: [
        { label: '全部', value: ''},
        { label: '启用', value: 0},
        { label: '停用', value: 2},
      ],//状态
      pickerOptions: pickerOptions,
      // 时间
      dateRange:[],
    };
  },
  created() {
    this.getMerchantList();
  },
  methods: {
    /** 查询支付订单列表 */
    getList() {
      this.loading = true;
      listPayOrder(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.payOrderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        userName: null,
        orderNo: null,
        payOrderNo: null,
        amount: null,
        createTime: null,
        updateTime: null,
        status: null,
        remark: null,
        errorMsg: null,
        merchantCode: null,
        channelCode: null,
        merchantName: null,
        channelName: null,
        sign: null
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
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除支付订单编号为"' + ids + '"的数据项？').then(function() {
        return delPayOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/payOrder/export', {
        ...this.queryParams
      }, `payOrder_${new Date().getTime()}.xlsx`)
    },
     /** 查询商家列表 */
     getMerchantList() {
      this.loading = true;
      listPayMerchant({
        pageNum: 1,
        pageSize: 1000,
      }).then(response => {
        this.payMerchantList = response.rows;
        this.getList();
      });
    },
  }
};
</script>
