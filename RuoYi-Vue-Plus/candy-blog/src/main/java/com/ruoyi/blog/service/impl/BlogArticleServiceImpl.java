package com.ruoyi.blog.service.impl;

import cn.hutool.core.util.ArrayUtil;
import com.ruoyi.blog.domain.BlogArticle;
import com.ruoyi.blog.mapper.BlogArticleMapper;
import com.ruoyi.blog.service.IBlogArticleService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 文章Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-31
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements IBlogArticleService {

    @Override
    public List<BlogArticle> queryList(BlogArticle blogArticle) {
        LambdaQueryWrapper<BlogArticle> lqw = Wrappers.lambdaQuery();
        if (StringUtils.isNotBlank(blogArticle.getArticleTitle())){
            lqw.eq(BlogArticle::getArticleTitle ,blogArticle.getArticleTitle());
        }
        if (StringUtils.isNotBlank(blogArticle.getArticleContent())){
            lqw.eq(BlogArticle::getArticleContent ,blogArticle.getArticleContent());
        }
        if (StringUtils.isNotBlank(blogArticle.getArticleStar())){
            lqw.eq(BlogArticle::getArticleStar ,blogArticle.getArticleStar());
        }
        if (blogArticle.getArticleViews() != null){
            lqw.eq(BlogArticle::getArticleViews ,blogArticle.getArticleViews());
        }
        if (StringUtils.isNotBlank(blogArticle.getArticleStatus())){
            lqw.eq(BlogArticle::getArticleStatus ,blogArticle.getArticleStatus());
        }
        if (blogArticle.getArticleReleaseTime() != null){
            lqw.eq(BlogArticle::getArticleReleaseTime ,blogArticle.getArticleReleaseTime());
        }
        if (StringUtils.isNotBlank(blogArticle.getArticleUser())){
            lqw.eq(BlogArticle::getArticleUser ,blogArticle.getArticleUser());
        }
        if (blogArticle.getArticleReplyCount() != null){
            lqw.eq(BlogArticle::getArticleReplyCount ,blogArticle.getArticleReplyCount());
        }
        return this.list(lqw);
    }

    @Override
    public AjaxResult removeArticleByIds(Long[] articleIds) {
        LambdaQueryWrapper<BlogArticle> lqw = Wrappers.lambdaQuery();
        // 逻辑删除
        if (ArrayUtil.isNotEmpty(articleIds)){
           try {
               for (Long id : articleIds){
                   BlogArticle article = this.getOne(lqw.eq(BlogArticle::getArticleId, id));
                   article.setArticleStatus(Constants.ONE);
                   this.updateById(article);
               }
               return AjaxResult.success();
           }catch (Exception e){
               return AjaxResult.error(e.getMessage());
           }
        }
        else {
            return AjaxResult.error("删除id不能为空");
        }
    }
}
