package com.yin.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void Test1(){
        System.out.println("Test1 Run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = "Test1")
    public void Test2(){
        System.out.println("Test2 Run");
    }
}
