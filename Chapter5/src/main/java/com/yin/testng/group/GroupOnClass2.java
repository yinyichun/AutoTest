package com.yin.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClass2 {
    public void Student1(){
        System.out.println("这是GroupOnClass2222下的student1111");
    }

    public void Student2(){
        System.out.println("这是GroupOnClass22222下的student2222");
    }
}
