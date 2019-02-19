package com.yin.testcase;

import com.yin.config.TestConfig;
import com.yin.model.AddUserCase;
import com.yin.model.GetUserInfoCase;
import com.yin.model.User;
import com.yin.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.yin.config.TestConfig.globalConfig;
import static com.yin.config.TestConfig.store;

public class AddUser {
    String TestResult;
    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息成功测试用例")
    public void addUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        AddUserCase addUserCase = sqlSession.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
        //Thread.sleep(1000);
        //发起请求获得结果
        String result = getResult(addUserCase);
    // 验证返回结果
        //Thread.sleep(3000);
        User user = sqlSession.selectOne("addUser",addUserCase);
        Thread.sleep(6000);
        //System.out.println(user.toString());
        Assert.assertEquals(addUserCase.getExpected(),result);
    }
    private String getResult(AddUserCase addUserCase) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(globalConfig)
                .setDefaultCookieStore(store).build();

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        //设置头信息
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //设置cookies
        //TestConfig.httpClientContext.setCookieStore(store);
        HttpResponse response = TestConfig.httpClient.execute(post);

        String result;
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        return result;
    }

    @AfterTest
    public int rollBack() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        int i=0;
        i = sqlSession.delete("deleteUser","wangwu111");
        return i ;
    }
}
