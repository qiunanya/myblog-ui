package com.ruoyi.web.controller.app;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.blog.domain.BlogArticle;
import com.ruoyi.blog.service.IBlogArticleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * APP 访问接口
 * 文章Controller
 * 
 * @author ruoyi
 * @date 2021-01-31
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("app/blog/article" )
public class AppBlogArticleController extends BaseController {
    @Autowired
    IBlogArticleService iBlogArticleService;

    @ApiOperation("查询文章列表")
    @GetMapping("/list")
    public TableDataInfo list(BlogArticle blogArticle) {
        startPage();
        List<BlogArticle> list = iBlogArticleService.queryList(blogArticle);
        return getDataTable(list);
    }

    @ApiOperation("导出文章列表")
    @Log(title = "文章" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(BlogArticle blogArticle) {
        List<BlogArticle> list = iBlogArticleService.queryList(blogArticle);
        ExcelUtil<BlogArticle> util = new ExcelUtil<BlogArticle>(BlogArticle.class);
        return util.exportExcel(list, "article" );
    }

    @ApiOperation("获取文章详细信息")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping(value = "/{articleId}" )
    public AjaxResult getInfo(@PathVariable("articleId" ) Long articleId) {
        return AjaxResult.success(iBlogArticleService.getById(articleId));
    }

    @ApiOperation("新增文章")
    @ApiImplicitParam(name = "blogArticle", value = "文章实体", required = true, dataType = "Object")
    @Log(title = "新增文章" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogArticle blogArticle) {
        return toAjax(iBlogArticleService.save(blogArticle) ? 1 : 0);
    }

    @ApiOperation("修改文章")
    @ApiImplicitParam(name = "blogArticle", value = "文章实体", required = true, dataType = "Object")
    @Log(title = "修改文章" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogArticle blogArticle) {
        return toAjax(iBlogArticleService.updateById(blogArticle) ? 1 : 0);
    }

    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long", paramType = "path")
    @Log(title = "删除文章" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{articleIds}" )
    public AjaxResult remove(@PathVariable Long[] articleIds) {
        return iBlogArticleService.removeArticleByIds(articleIds);
    }

    @ApiOperation("测试接口")
    @GetMapping(value = "/test")
    public AjaxResult test() {
        return AjaxResult.success("测试接口访问成功啦，，，");
    }
}
