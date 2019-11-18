package com.niit.web.blog.dao;


import com.niit.web.blog.domain.VO.ArticleVo;
import com.niit.web.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName ArticleDao
 * @Description 文章Dao接口
 * @Date 7:11 2019/11/10
 * @Version 1.0
 **/
public interface ArticleDao {
    /**
     * 批量新增文章
     *
     * @param articleList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articleList) throws SQLException;

    List<ArticleVo> selectHotArticles() throws SQLException;
}