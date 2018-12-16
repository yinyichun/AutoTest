package com.yin.testng;

import org.testng.annotations.*;

public class BasicAnnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId() );
        System.out.println("这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是测试之后的标签");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是测试之前的标签");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是类之前的标签");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是类之后的标签");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("这是afterSuite测试套件");
    }
}
