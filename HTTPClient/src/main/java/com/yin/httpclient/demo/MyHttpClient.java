package com.yin.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void testRun(){
        //用来存放结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //用来执行get方法
        HttpClient client = new DefaultHttpClient();
        try {
           HttpResponse response =  client.execute(get);
          result = EntityUtils.toString(response.getEntity(),"utf8") ;
          System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
