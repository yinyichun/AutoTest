package com.yin.testng.group;

import org.testng.annotations.Test;

@Test(groups = "Teacher")
public class GroupOnClass4 {
    public void Teacher1(){
        System.out.println("这是GroupOnClass44444下的Teacher11111");
    }

    public void Teacher2(){
        System.out.println("这是GroupOnClass44444下的Teacher22222");
    }
}
