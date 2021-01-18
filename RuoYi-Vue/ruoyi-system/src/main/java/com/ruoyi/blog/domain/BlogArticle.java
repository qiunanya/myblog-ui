package com.ruoyi.blog.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章对象 blog_article
 * 
 * @author NanyaQiu
 * @date 2021-01-18
 */
public class BlogArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 博文ID */
    private Long articleId;

    /** 博文标题 */
    @Excel(name = "博文标题")
    private String articleTitle;

    /** 博文内容 */
    @Excel(name = "博文内容")
    private String articleContent;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private String articleStar;

    /** 游览量 */
    @Excel(name = "游览量")
    private Long articleViews;

    /** 状态（0存在 1删除） */
    @Excel(name = "状态", readConverterExp = "0=存在,1=删除")
    private String articleStatus;

    /** 发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date articleReleaseTime;

    /** 发表用户 */
    @Excel(name = "发表用户")
    private String articleUser;

    /** 回复数 */
    @Excel(name = "回复数")
    private Long articleReplyCount;

    public void setArticleId(Long articleId) 
    {
        this.articleId = articleId;
    }

    public Long getArticleId() 
    {
        return articleId;
    }
    public void setArticleTitle(String articleTitle) 
    {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle() 
    {
        return articleTitle;
    }
    public void setArticleContent(String articleContent) 
    {
        this.articleContent = articleContent;
    }

    public String getArticleContent() 
    {
        return articleContent;
    }
    public void setArticleStar(String articleStar) 
    {
        this.articleStar = articleStar;
    }

    public String getArticleStar() 
    {
        return articleStar;
    }
    public void setArticleViews(Long articleViews) 
    {
        this.articleViews = articleViews;
    }

    public Long getArticleViews() 
    {
        return articleViews;
    }
    public void setArticleStatus(String articleStatus) 
    {
        this.articleStatus = articleStatus;
    }

    public String getArticleStatus() 
    {
        return articleStatus;
    }
    public void setArticleReleaseTime(Date articleReleaseTime) 
    {
        this.articleReleaseTime = articleReleaseTime;
    }

    public Date getArticleReleaseTime() 
    {
        return articleReleaseTime;
    }
    public void setArticleUser(String articleUser) 
    {
        this.articleUser = articleUser;
    }

    public String getArticleUser() 
    {
        return articleUser;
    }
    public void setArticleReplyCount(Long articleReplyCount) 
    {
        this.articleReplyCount = articleReplyCount;
    }

    public Long getArticleReplyCount() 
    {
        return articleReplyCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("articleId", getArticleId())
            .append("articleTitle", getArticleTitle())
            .append("articleContent", getArticleContent())
            .append("articleStar", getArticleStar())
            .append("articleViews", getArticleViews())
            .append("articleStatus", getArticleStatus())
            .append("articleReleaseTime", getArticleReleaseTime())
            .append("articleUser", getArticleUser())
            .append("articleReplyCount", getArticleReplyCount())
            .toString();
    }
}
