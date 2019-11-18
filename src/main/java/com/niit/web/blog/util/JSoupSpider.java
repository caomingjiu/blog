package com.niit.web.blog.util;

import com.niit.web.blog.entity.Address;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Jianshu;
import com.niit.web.blog.entity.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);
    public static List<Address> getaddress(){
        Document document = null;
        List<Address> addressList = new ArrayList<>(100);
            try {
                document = Jsoup.connect("http://www.ip33.com/area_code.html").get();

            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("ip");
            divs.forEach(div->{
                Element element=  div.children().get(1).children().get(1).children().get(1);
                Element element1= div.children().get(1).children().get(0).children().get(1);
                Element element2= div.children().get(1);//所有的下一级
                Element element3= div.children().first();//市

                System.out.println(element.text());

                for (int j=0;j<=(element2.childNodeSize()/2-1);j++) {
                    for (int i = 0; i <= (element1.childNodeSize() / 2 - 1); i++) {
                        String str2 = element2.children().get(j)
                                .children().first().toString().substring(4, element2
                                        .children().get(j)
                                        .children().first().toString().indexOf(" "));
                        String str1 = element1.children().get(i).toString().substring(4, element1
                                .children().get(i).toString().indexOf(" "));
                        String str3 = element3.toString().substring(4,element3.toString().indexOf(" "));
                        String str4 = str3+str2+str1;
                        Address address = new Address();
                        address.setAddress(str4);
                        addressList.add(address);
                    }
                }



            });
        System.out.println(addressList.size());
        return addressList;
    }
    public static List<Jianshu> getJianshu(){
        Document document = null;
        List<Jianshu> jianshuList = new ArrayList<>(100);
        for(int i=1;i<=3;i++){
            try {
                document = Jsoup.connect("https://www.jianshu.com?page=" +i).get();

            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div->{
                Element wrapImg = div.child(0);
                Element contentDiv = div.child(1);
                Element account = contentDiv.child(2);
                Jianshu jianshu=new Jianshu();
                jianshu.setMobile(DataUtil.getMobile());
                jianshu.setPassword(DataUtil.getPassword());
                jianshu.setTitle(contentDiv.child(0).text());
                jianshu.setText(contentDiv.child(1).text());
                jianshu.setAvatar("https:" +wrapImg.child(0).attr("src"));
                jianshu.setCreateTime(LocalDateTime.now());
                jianshuList.add(jianshu);
            });
        }
        System.out.println(jianshuList.size());
        return jianshuList;
    }
    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setGender(DataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }
    public static List<Article> getArticles() {
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i = 1; i<=7; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/c/87b50a03a96e?order_by=top&count=50&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败1");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div -> {
                String articleUrl = div.child(0).attr("href");
                Document document1 = null;
                try {
                    document1 = Jsoup.connect("https://www.jianshu.com" + articleUrl).get();
                } catch (IOException e) {
                    logger.error("连接失败2");
                }
                Element articleElement = document1.getElementsByClass("_2rhmJa").first();
                Article article = new Article();
                article.setContent(articleElement.html());

                Elements elements = div.children();
                Element linkElement = elements.get(0);
                Element divElement = elements.get(1);
                article.setUserId(DataUtil.getUserId());
                article.setTitle(divElement.child(0).text());
                article.setSummary(divElement.child(1).text());
                String img = "https:" + linkElement.child(0).attr("src");
                int index = img.indexOf("?");
                article.setThumbnail(img.substring(0, index));
                Elements metaChildren = divElement.child(2).children();
                String comments = metaChildren.get(2).text();
                String likes = metaChildren.last().text();
                try {
                    article.setComments(Integer.parseInt(comments));
                    article.setLikes(Integer.parseInt(likes));
                } catch (NumberFormatException e) {
                    logger.error("格式转换异常");
                }
                article.setCreateTime(DataUtil.getCreateTime());
                articleList.add(article);
            });
        }
        System.out.println(articleList.size());
        return articleList;
    }
}
