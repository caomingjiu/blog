package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.util.ResponseObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mq_xu
 * @ClassName ArticleController
 * @Description TODO
 * @Date 22:52 2019/11/11
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/articles/hot"})
    public class ArticleController extends HttpServlet {
    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new GsonBuilder().create();
        ResponseObject ro = ResponseObject.success(200, "成功", articleService.getHotArticles());
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
}