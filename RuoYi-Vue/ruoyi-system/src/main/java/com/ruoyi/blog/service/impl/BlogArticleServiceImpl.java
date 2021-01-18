package com.ruoyi.blog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.blog.mapper.BlogArticleMapper;
import com.ruoyi.blog.domain.BlogArticle;
import com.ruoyi.blog.service.IBlogArticleService;

/**
 * 文章Service业务层处理
 * 
 * @author NanyaQiu
 * @date 2021-01-18
 */
@Service
public class BlogArticleServiceImpl implements IBlogArticleService 
{
    @Autowired
    private BlogArticleMapper blogArticleMapper;

    /**
     * 查询文章
     * 
     * @param articleId 文章ID
     * @return 文章
     */
    @Override
    public BlogArticle selectBlogArticleById(Long articleId)
    {
        return blogArticleMapper.selectBlogArticleById(articleId);
    }

    /**
     * 查询文章列表
     * 
     * @param blogArticle 文章
     * @return 文章
     */
    @Override
    public List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle)
    {
        return blogArticleMapper.selectBlogArticleList(blogArticle);
    }

    /**
     * 新增文章
     * 
     * @param blogArticle 文章
     * @return 结果
     */
    @Override
    public int insertBlogArticle(BlogArticle blogArticle)
    {
        return blogArticleMapper.insertBlogArticle(blogArticle);
    }

    /**
     * 修改文章
     * 
     * @param blogArticle 文章
     * @return 结果
     */
    @Override
    public int updateBlogArticle(BlogArticle blogArticle)
    {
        return blogArticleMapper.updateBlogArticle(blogArticle);
    }

    /**
     * 批量删除文章
     * 
     * @param articleIds 需要删除的文章ID
     * @return 结果
     */
    @Override
    public int deleteBlogArticleByIds(Long[] articleIds)
    {
        return blogArticleMapper.deleteBlogArticleByIds(articleIds);
    }

    /**
     * 删除文章信息
     * 
     * @param articleId 文章ID
     * @return 结果
     */
    @Override
    public int deleteBlogArticleById(Long articleId)
    {
        return blogArticleMapper.deleteBlogArticleById(articleId);
    }
}
