package com.ruoyi.blog.service;

import java.util.List;
import com.ruoyi.blog.domain.BlogArticle;

/**
 * 文章Service接口
 * 
 * @author NanyaQiu
 * @date 2021-01-18
 */
public interface IBlogArticleService 
{
    /**
     * 查询文章
     * 
     * @param articleId 文章ID
     * @return 文章
     */
    public BlogArticle selectBlogArticleById(Long articleId);

    /**
     * 查询文章列表
     * 
     * @param blogArticle 文章
     * @return 文章集合
     */
    public List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle);

    /**
     * 新增文章
     * 
     * @param blogArticle 文章
     * @return 结果
     */
    public int insertBlogArticle(BlogArticle blogArticle);

    /**
     * 修改文章
     * 
     * @param blogArticle 文章
     * @return 结果
     */
    public int updateBlogArticle(BlogArticle blogArticle);

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章ID
     * @return 结果
     */
    public int deleteBlogArticleByIds(Long[] articleIds);

    /**
     * 删除文章信息
     * 
     * @param articleId 文章ID
     * @return 结果
     */
    public int deleteBlogArticleById(Long articleId);
}
