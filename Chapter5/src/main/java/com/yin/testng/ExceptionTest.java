package com.yin.testng;

import org.testng.annotations.Test;

public class ExceptionTest {

    @Test (expectedExceptions = RuntimeException.class)
    public void runTimExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test (expectedExceptions = RuntimeException.class)
    public void runTimExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
