package com.niit.web.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Description 数据生成工具,用来生成用户的一些数据
 */
public class DataUtil {
    public static String  getMobile() {
        /**
         * 获得电话号码
         * @return
         */
        StringBuilder stringBuilder=new StringBuilder("139") ;
        Random random=new Random();
        for (int i=0; i<8;i++){
            int num=random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
    public static  String getPassword(){
        StringBuilder stringBuilder=new StringBuilder();
        Random random=new Random();
        for (int i=0;i<6;i++){
            int num=random.nextInt(10);
            stringBuilder.append(num);
        }
        return DigestUtils.md5Hex(stringBuilder.toString());
    }
    public static  String getGender(){
        String[] genders=new String[]{"男","女"};
        Random random=new Random();
        int index=random.nextInt(2);
        return genders[index];
    }
    public static LocalDate getBirthday(){
        LocalDate now=LocalDate.now();
        Random random=new Random();
        int bound=random.nextInt(8888);
        return now.minusDays(bound);
    }
    public static Long getUserId(){
        Random random = new Random();
        long bound = random.nextInt(61);
        return bound;
    }
    public static LocalDateTime getCreateTime(){
        LocalDateTime now = LocalDateTime.now();
        Random random = new Random();
        int bound = random.nextInt(999);
        return now.minusHours(bound);
    }
}
