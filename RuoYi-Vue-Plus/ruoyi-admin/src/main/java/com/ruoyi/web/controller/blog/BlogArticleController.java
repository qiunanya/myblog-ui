package com.ruoyi.web.controller.blog;

import java.util.List;
import java.util.Arrays;

import com.ruoyi.blog.domain.BlogArticle;
import com.ruoyi.blog.service.IBlogArticleService;
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
 * 文章Controller
 * 
 * @author ruoyi
 * @date 2021-01-31
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/blog/article" )
public class BlogArticleController extends BaseController {
    @Autowired
    IBlogArticleService iBlogArticleService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(BlogArticle blogArticle) {
        startPage();
        List<BlogArticle> list = iBlogArticleService.queryList(blogArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog:article:export')" )
    @Log(title = "文章" , businessType = BusinessType.EXPORT)
    @GetMapping("/export" )
    public AjaxResult export(BlogArticle blogArticle) {
        List<BlogArticle> list = iBlogArticleService.queryList(blogArticle);
        ExcelUtil<BlogArticle> util = new ExcelUtil<BlogArticle>(BlogArticle.class);
        return util.exportExcel(list, "article" );
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog:article:query')" )
    @GetMapping(value = "/{articleId}" )
    public AjaxResult getInfo(@PathVariable("articleId" ) Long articleId) {
        return AjaxResult.success(iBlogArticleService.getById(articleId));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:add')" )
    @Log(title = "文章" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogArticle blogArticle) {
        return toAjax(iBlogArticleService.save(blogArticle) ? 1 : 0);
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:edit')" )
    @Log(title = "文章" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogArticle blogArticle) {
        return toAjax(iBlogArticleService.updateById(blogArticle) ? 1 : 0);
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('blog:article:remove')" )
    @Log(title = "文章" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{articleIds}" )
    public AjaxResult remove(@PathVariable Long[] articleIds) {
        return iBlogArticleService.removeArticleByIds(articleIds);
    }

    /**
     * 测试接口
     */
    @GetMapping(value = "/test")
    public AjaxResult test() {
        return AjaxResult.success("测试接口访问成功啦，，，");
    }
}
