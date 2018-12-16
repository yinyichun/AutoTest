package com.yin.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)//d单位毫秒
    public void testSuccess()throws InterruptedException{
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)//d单位毫秒
    public void testFailed()throws InterruptedException{
        Thread.sleep(3000);
    }
}
