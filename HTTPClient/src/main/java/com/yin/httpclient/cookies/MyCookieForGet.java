package com.yin.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForGet {
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
    public void testGetCookies() throws IOException {
        String result;
        String uri = bundle.getString("getWithCookie.uri");
        String testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(store);
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        if(statusCode==200){
        result =  EntityUtils.toString(response.getEntity(),"gdk");
        System.out.println(result);
        }
    }
}
