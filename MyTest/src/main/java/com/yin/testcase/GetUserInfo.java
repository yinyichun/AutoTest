package com.yin.testcase;

import com.yin.config.TestConfig;
import com.yin.model.GetUserInfoCase;
import com.yin.model.UpdateUserInfoCase;
import com.yin.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfo {
    @Test(dependsOnGroups = "loginTrue",description = "获取用户信息成功测试用例")
    public void getUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
    }
}
