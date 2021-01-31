package com.ruoyi.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.blog.domain.BlogArticle;
import com.ruoyi.common.core.domain.AjaxResult;

import java.util.List;

/**
 * 文章Service接口
 *
 * @author ruoyi
 * @date 2021-01-31
 */
public interface IBlogArticleService extends IService<BlogArticle> {

    /**
     * 查询列表
     */
    List<BlogArticle> queryList(BlogArticle blogArticle);

    /**
     * @Author Qiunanya
     * @Description 删除文章  包括批量删除和单个删除
     * @params articleIds 文章id集合
     * @Date 2021/1/31 16:34
     * @reture AjaxResult
     **/
    AjaxResult removeArticleByIds(Long[] articleIds);
}
