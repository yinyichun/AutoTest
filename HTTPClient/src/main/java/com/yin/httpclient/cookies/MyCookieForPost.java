package com.yin.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforTest(){
        bundle = ResourceBundle.getBundle("config", Locale.CANADA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testCookies() throws IOException {
        String result;
        String uri = bundle.getString("getCookie.uri");
        String testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result =  EntityUtils.toString(response.getEntity(),"gdk");

        //设置cookie信息
        store =  client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name + "; cookie value = " + value);

        }
        System.out.println(result);
    }

    @Test(dependsOnMethods = {"testCookies"})
    public void getWithPost() throws IOException {

        String uri = bundle.getString("post.getWithCookie.uri");

        //拼接最终的测试地址
        String postUrl = url + uri;

        //声明一个Clinet对象
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个POST方法
        HttpPost post = new HttpPost(postUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhanshan");
        param.put("age","38");


        //设置请求头信息
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"gbk");
        post.setEntity(entity);

        //设置一个对象来保存相应结果
        String result;
        //设置cookie信息
        client.setCookieStore(store);
        //执行POST方法
        HttpResponse response = client.execute(post);
        //获取响应结果
       result = EntityUtils.toString(response.getEntity(),"gbk");
       System.out.println(result);

        //将结果转换为json对象
        JSONObject resultJson = new JSONObject(result);
        //获取结果值
        String success = (String)resultJson.getString("huhanshan");
        String stauts = (String)resultJson.getString("status");
        //处理结果，判断返回结果是否符合预期
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",stauts);


    }
}
