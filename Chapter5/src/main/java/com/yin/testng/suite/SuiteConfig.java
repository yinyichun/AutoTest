package com.yin.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforSuit(){
    System.out.println("这是一个beforeSuit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("这是一个afterSuit");
    }

    @BeforeTest
    public void beforTest(){
        System.out.println("这是一个beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("这是一个afterTest");
    }
}
