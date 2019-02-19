package com.yin.testcase;

import com.yin.config.TestConfig;
import com.yin.model.GetUserInfoCase;
import com.yin.model.GetUserListCase;
import com.yin.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserList {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男用户信息成功测试用例")
    public void getUserList() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
    }
}
