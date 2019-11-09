package com.niit.web.blog.util;

import com.aliyun.oss.OSSClient;

import java.io.File;
import java.util.UUID;

public class AliOSSUtil {
    public static String ossUpload(File file){
        String bucketDomain="http://niit-soft.oss-cn-hangzhou.aliyuncs.com/";
        String endpoint="oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId="LTAI4FuNH3cQirWwhynvdCxv";
        String accessKeySecret="TmUIP6EkFBi5c9Mrq5kysWMRsNe7x6";
        String bucketName="niit-soft";
        String filedir="avatar/";
        String fileName=file.getName();
        System.out.println(fileName);
        String fileKey= "caomingjiu"+fileName.substring(fileName.indexOf("."));
        OSSClient ossClient=new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,filedir+fileKey,file);
        StringBuffer url=new StringBuffer();
        url.append(bucketDomain).append(filedir).append(fileKey);
        ossClient.shutdown();
        return url.toString();
    }
    public static  void main(String[] args){
        File file=new File("D:/html/jianshu/image/1.png");
        String url =ossUpload(file);
        System.out.println(url);
    }
}
