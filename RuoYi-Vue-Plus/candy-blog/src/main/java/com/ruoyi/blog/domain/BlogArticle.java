package com.ruoyi.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.ruoyi.common.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

/**
 * 文章对象 blog_article
 * 
 * @author ruoyi
 * @date 2021-01-31
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("blog_article")
public class BlogArticle implements Serializable {

private static final long serialVersionUID=1L;


    /** 博文ID */
    @TableId(value = "article_id")
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
    @Excel(name = "状态" , readConverterExp = "0=存在,1=删除")
    private String articleStatus;

    /** 发布日期 */
    @Excel(name = "发布日期" , width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleReleaseTime;

    /** 发表用户 */
    @Excel(name = "发表用户")
    private String articleUser;

    /** 回复数 */
    @Excel(name = "回复数")
    private Long articleReplyCount;

    @TableField(exist = false)
    private Map<String, Object> params = new HashMap<>();
}
