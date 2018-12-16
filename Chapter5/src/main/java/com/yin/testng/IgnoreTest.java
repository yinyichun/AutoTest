package com.yin.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test(enabled = true)
    public void test1(){
        System.out.println("这是一个忽略测试1");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("这是一个忽略测试2");
    }
}
