<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="博文标题" prop="articleTitle">
        <el-input
          v-model="queryParams.articleTitle"
          placeholder="请输入博文标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞数" prop="articleStar">
        <el-input
          v-model="queryParams.articleStar"
          placeholder="请输入点赞数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="游览量" prop="articleViews">
        <el-input
          v-model="queryParams.articleViews"
          placeholder="请输入游览量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="articleStatus">
        <el-select v-model="queryParams.articleStatus" placeholder="请选择状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="发布日期" prop="articleReleaseTime">
        <el-date-picker clearable size="small"
          v-model="queryParams.articleReleaseTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择发布日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="发表用户" prop="articleUser">
        <el-input
          v-model="queryParams.articleUser"
          placeholder="请输入发表用户"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="回复数" prop="articleReplyCount">
        <el-input
          v-model="queryParams.articleReplyCount"
          placeholder="请输入回复数"
          clearable
          size="small"
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
          v-hasPermi="['blog:article:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['blog:article:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['blog:article:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['blog:article:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="articleList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="博文ID" align="center" prop="articleId" />
        <el-table-column label="博文标题" align="center" prop="articleTitle" />
        <!-- <el-table-column label="博文内容" align="center" prop="articleContent" show-overflow-tooltip> 
            <template slot-scope="scope">
                <div class="article_content" v-html="scope.row.articleContent"></div>
            </template>
        </el-table-column> -->
        <el-table-column label="点赞数" align="center" prop="articleStar" />
        <el-table-column label="游览量" align="center" prop="articleViews" />
        <el-table-column label="状态" align="center" prop="articleStatus" />
        <el-table-column label="发布日期" align="center" prop="articleReleaseTime" width="180">
            <template slot-scope="scope">
            <span>{{ parseTime(scope.row.articleReleaseTime, '{y}-{m}-{d}') }}</span>
            </template>
        </el-table-column>
        <el-table-column label="发表用户" align="center" prop="articleUser" />
        <el-table-column label="回复数" align="center" prop="articleReplyCount" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
            <template slot-scope="scope">
            <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
                v-hasPermi="['blog:article:edit']"
            >修改</el-button>
            <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
                v-hasPermi="['blog:article:remove']"
            >删除</el-button>
            <el-button
                size="mini"
                type="text"
                icon="el-icon-view"
                @click="handleView(scope.row)"
            >查看详情</el-button>
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

    <!-- 添加或修改文章对话框 -->
    <el-dialog :title="title" :visible.sync="open" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="博文标题" prop="articleTitle">
          <el-input v-model="form.articleTitle" placeholder="请输入博文标题" />
        </el-form-item>
        <el-form-item label="博文内容">
          <editor v-model="form.articleContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="点赞数" prop="articleStar">
          <el-input v-model="form.articleStar" placeholder="请输入点赞数" />
        </el-form-item>
        <el-form-item label="游览量" prop="articleViews">
          <el-input v-model="form.articleViews" placeholder="请输入游览量" />
        </el-form-item>
        <el-form-item label="状态">
          <el-radio-group v-model="form.articleStatus">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="发布日期" prop="articleReleaseTime">
          <el-date-picker clearable size="small"
            v-model="form.articleReleaseTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择发布日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发表用户" prop="articleUser">
          <el-input v-model="form.articleUser" placeholder="请输入发表用户" />
        </el-form-item>
        <el-form-item label="回复数" prop="articleReplyCount">
          <el-input v-model="form.articleReplyCount" placeholder="请输入回复数" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 详情页面 -->
    <el-drawer
        title="我是标题"
        :visible.sync="drawer"
        :direction="direction"
        :before-close="handleClose">
        <span>我来啦!</span>
    </el-drawer>
  </div>
</template>

<script>
import { listArticle, getArticle, delArticle, addArticle, updateArticle, exportArticle } from "@/api/blog/article";
import Editor from '@/components/Editor';

export default {
  name: "Article",
  components: {
    Editor,
  },
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
      // 文章表格数据
      articleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        articleTitle: null,
        articleContent: null,
        articleStar: null,
        articleViews: null,
        articleStatus: null,
        articleReleaseTime: null,
        articleUser: null,
        articleReplyCount: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /**
     * 查看文章详情
     */
    handleView(row){
        console.log(row);
    },
    /** 查询文章列表 */
    getList() {
      this.loading = true;
      listArticle(this.queryParams).then(response => {
        this.articleList = response.rows;
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
        articleId: null,
        articleTitle: null,
        articleContent: null,
        articleStar: null,
        articleViews: null,
        articleStatus: "0",
        articleReleaseTime: null,
        articleUser: null,
        articleReplyCount: null
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
      this.ids = selection.map(item => item.articleId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加文章";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const articleId = row.articleId || this.ids
      getArticle(articleId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改文章";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.articleId != null) {
            updateArticle(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArticle(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const articleIds = row.articleId || this.ids;
      this.$confirm('是否确认删除文章编号为"' + articleIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delArticle(articleIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有文章数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportArticle(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
<style lang="scss">
@import url('./style.scss');
</style>