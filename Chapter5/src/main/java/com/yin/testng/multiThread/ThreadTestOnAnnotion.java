package com.yin.testng.multiThread;

import org.testng.annotations.Test;

public class ThreadTestOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void Test(){
        System.out.println("1");
        System.out.printf("Thread Id : %s%n" , Thread.currentThread().getId() );
    }
}
