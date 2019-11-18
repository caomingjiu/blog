package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.domain.VO.ArticleVo;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Date 22:49 2019/11/11
 * @Version 1.0
 **/
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);


    @Override
    public List<ArticleVo> getHotArticles() {
        List<ArticleVo> articleVoList = new ArrayList<>(20);
        try {
            articleVoList = articleDao.selectHotArticles();
        } catch (SQLException e) {
            logger.error("查询热门文章出现异常");
        }
        return articleVoList;
    }
}