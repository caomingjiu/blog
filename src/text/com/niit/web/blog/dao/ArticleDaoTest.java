package com.niit.web.blog.dao;

import com.niit.web.blog.domain.VO.ArticleVo;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import com.niit.web.blog.dao.impl.ArticleDaoImpl;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.DataUtil;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoTest {

    private static Logger logger = LoggerFactory.getLogger(ArticleDaoTest.class);
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void batchInsert() throws SQLException {
        try {
            int[] result = articleDao.batchInsert(JSoupSpider.getArticles());
            if(result.length!=0){
                logger.info("批量新增用户成功");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void selectHotArticles() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectHotArticles();
        articleVoList.forEach(a -> System.out.println(a));
    }
}