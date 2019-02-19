package com.yin.testcase;

import com.yin.config.TestConfig;
import com.yin.model.LoginCase;
import com.yin.model.UpdateUserInfoCase;
import com.yin.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfo {
    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息成功测试用例")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }

    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息成功测试用例")
    public void deleteUser() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);
    }
}
