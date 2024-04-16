<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="90px">
      <el-form-item label="用户名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平台订单号" prop="orderNo">
        <el-input
          v-model="queryParams.orderNo"
          placeholder="请输入平台订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="三方订单号" prop="platOrderNo">
        <el-input
          v-model="queryParams.platOrderNo"
          placeholder="请输入三方订单号"
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
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:eduOrder:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="eduOrderList">
      <el-table-column label="用户名" align="center" prop="userName" />
      <el-table-column label="平台订单号" align="center" prop="orderNo" />
      <el-table-column label="三方订单号" align="center" prop="platOrderNo" />
      <el-table-column label="转换金额" align="center" prop="amount" >
        <template slot-scope="scope">
          <span v-if="scope.row.eduType == 1" class="red-text">{{ scope.row.amount }}</span>
          <span v-else-if="scope.row.eduType == 0" class="green-text">{{ scope.row.amount }}</span>
        </template>
      </el-table-column>
      <el-table-column label="类型" align="center" prop="eduType" >
        <template slot-scope="scope">
          <span v-if="scope.row.eduType == 1">转出</span>
          <span v-else-if="scope.row.eduType == 0">转入</span>
        </template>
      </el-table-column>
      <el-table-column label="平台代码" align="center" prop="platCode" />
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-tag type="warning" v-if="scope.row.status == -1">异常</el-tag>
          <el-tag type="success" v-else-if="scope.row.status == 0">成功</el-tag>
          <el-tag type="danger" v-else-if="scope.row.status == 1">失败</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作时间" align="center" prop="createTime" />
      <el-table-column label="备注" align="center" prop="remark" />
      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:eduOrder:remove']"
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
import { listEduOrder, getEduOrder, delEduOrder, updateEduOrder } from "@/api/lottery/eduOrder";
import { dateFormat,pickerOptions } from '@/utils/auth'

export default {
  name: "EduOrder",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 额度转换表格数据
      eduOrderList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        orderNo: null,
        platOrderNo: null,
        isAsc:'desc',
        orderByColumn:'id'
      },
      pickerOptions: pickerOptions,
      // 时间
      dateRange:[],
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询额度转换列表 */
    getList() {
      this.loading = true;
      listEduOrder(this.queryParams).then(response => {
        this.eduOrderList = response.rows;
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
        platOrderNo: null,
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
      this.$modal.confirm('是否确认删除额度转换编号为"' + ids + '"的数据项？').then(function() {
        return delEduOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/eduOrder/export', {
        ...this.queryParams
      }, `eduOrder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
