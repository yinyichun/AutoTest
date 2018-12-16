package com.yin.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void Test1(String name,int age){
        System.out.println("name = " + name + "; age = " + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangshan",20},
                {"lisi",16},
                {"wangwu",19}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void Test2(String name,int age){
        System.out.println("Test 2 方法的  name = " + name + "; age = " + age);
    }

    @Test(dataProvider = "methodData")
    public void Test3(String name,int age){
        System.out.println("Test 3 方法的 name = " + name + "; age = " + age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if(method.getName().equals("Test2")){
            result = new Object[][]{
                    {"zhangshan",77},
                    {"王五",22},
            };
        }else if(method.getName().equals("Test3")){
            result = new Object[][]{
                    {"lisi",27},
                    {"赵柳",16},
            };
        }

        return result;
    }
}
