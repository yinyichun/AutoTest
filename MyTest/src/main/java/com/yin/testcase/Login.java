package com.yin.testcase;

import com.yin.config.TestConfig;
import com.yin.model.LoginCase;
import com.yin.model.OperationName;
import com.yin.utils.ConfigFile;
import com.yin.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.yin.config.TestConfig.globalConfig;
import static com.yin.config.TestConfig.store;

public class Login {
    @BeforeTest(groups = "loginTrue",description = "测试的准备工作，获取HttpClient对象")
    public void beforeTest(){
        TestConfig.loginUrl  = ConfigFile.getUrl(OperationName.LOGIN);
        TestConfig.addUserUrl  = ConfigFile.getUrl(OperationName.ADDUSER);
        TestConfig.getUserInfoUrl  = ConfigFile.getUrl(OperationName.GETUSERINFO);
        TestConfig.getUserListUrl  = ConfigFile.getUrl(OperationName.GETUSERLIST);
        TestConfig.updateUserInfoUrl  = ConfigFile.getUrl(OperationName.UPDATEUSERINFO);
        TestConfig.httpClient =  HttpClients.createDefault();
        TestConfig.httpClientContext = HttpClientContext.create();
        TestConfig.globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();

    }

    @Test(groups = "loginTrue",description = "用户登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //第一步，发送请求
        String result = getResult(loginCase);
        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }

    @Test(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //第一步，发送请求
        String result = getResult(loginCase);
        //验证结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }
    private String getResult(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",loginCase.getPassword());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"UTF-8");
        post.setEntity(entity);
        String result;
        HttpResponse response = TestConfig.httpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"UTF-8");
        TestConfig.store =  TestConfig.httpClientContext.getCookieStore();
        return result;
    }
}
