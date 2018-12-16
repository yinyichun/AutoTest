package com.yin.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupTest {

    @Test(groups = "service")
    public void test1(){
        System.out.println("这是我的Test1");
    }
    @Test(groups = "service")
    public void test2(){
        System.out.println("这是我的Test2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是我的Test3");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是我的Test4");
    }

    @BeforeGroups("client")
    public void beforGroup(){
        System.out.println("这是我的beforeGroup");
    }

    @AfterGroups("client")
    public void afterGroup(){
        System.out.println("这是我的AfterGroup");
    }
}
