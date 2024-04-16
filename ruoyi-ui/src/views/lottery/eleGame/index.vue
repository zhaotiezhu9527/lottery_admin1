<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="游戏名称" prop="gameName">
        <el-input
          v-model="queryParams.gameName"
          placeholder="请输入游戏名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平台名称">
        <el-select v-model="queryParams.platSubCode" placeholder="请选择">
          <el-option
            v-for="item in codeList"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryParams.status" placeholder="请选择">
          <el-option
            v-for="item in statusList"
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

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['lottery:eleGame:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eleGameList">
      <el-table-column label="平台名称" align="center" prop="platSubCode" >
        <template slot-scope="scope">
          <div v-if="scope.row.platSubCode === 'AGFISH'">AG捕鱼</div>
          <div v-else-if="scope.row.platSubCode === 'KY'">开元棋牌</div>
          <div v-else-if="scope.row.platSubCode === 'AGELE'">AG电子</div>
          <div v-else-if="scope.row.platSubCode === 'LY'">乐游棋牌</div>
          <div v-else-if="scope.row.platSubCode === 'BBINELE'">BBIN电子</div>
          <div v-else-if="scope.row.platSubCode === 'BBINFISH'">BBIN捕鱼</div>
        </template>
      </el-table-column>
      <el-table-column label="游戏代码" align="center" prop="gameCode" />
      <el-table-column label="游戏名称" align="center" prop="gameName" />
      <el-table-column label="游戏图标" align="center" prop="img" >
        <template slot-scope="scope">
          <image-preview :src="scope.row.img" :width="50" :height="50"/>
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
      <el-table-column label="排序号" align="center" prop="pxh" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['lottery:eleGame:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['lottery:eleGame:remove']"
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

    <!-- 添加或修改游戏列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="游戏名称" prop="gameName">
          <el-input v-model="form.gameName" placeholder="请输入游戏名称" />
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
import { listEleGame, getEleGame, delEleGame, updateEleGame } from "@/api/lottery/eleGame";

export default {
  name: "EleGame",
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
      // 游戏列表表格数据
      eleGameList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 20,
        gameName: null,
        status:"",
        platSubCode: '',//子平台code
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
       
      },
      statusList: [
        { label: '全部', value: ''},
        { label: '启用', value: 0},
        { label: '停用', value: 1},
      ],//状态
      codeList: [
        { label: '全部', value: ''},
        { label: 'AG捕鱼', value: 'AGFISH'},
        { label: '开元棋牌', value: 'KY'},
        { label: 'AG电子', value: 'AGELE'},
        { label: '乐游棋牌', value: 'LY'},
        { label: 'BBIN电子', value: 'BBINELE'},
        { label: 'BBIN捕鱼', value: 'BBINFISH'},
      ],//状态
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询游戏列表列表 */
    getList() {
      this.loading = true;
      listEleGame(this.queryParams).then(response => {
        this.eleGameList = response.rows;
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
        gameName: null,
        status: '',
        platSubCode: '',
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
      this.title = "添加游戏列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEleGame(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改游戏列表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      let obj = {
        id: this.form.id,
        gameName: this.form.gameName,
        pxh: this.form.pxh,
      }
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEleGame(obj).then(response => {
              this.$modal.msgSuccess("修改成功");
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
      this.$modal.confirm('是否确认删除游戏列表编号为"' + ids + '"的数据项？').then(function() {
        return delEleGame(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('lottery/eleGame/export', {
        ...this.queryParams
      }, `eleGame_${new Date().getTime()}.xlsx`)
    },
    // 停启用状态
    changeStatus(id,status){
      updateEleGame({
        id:id,
        status:status,
      }).then(response => {
        this.$modal.msgSuccess("修改成功");
      });
    },
  }
};
</script>
