package com.study.all.study;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(10);
        //ScheduledExecutorService scheduledExecutorService = Executors;

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }
        System.out.println("Thread Name :" + Thread.currentThread().getName());
    }



    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Name :" + Thread.currentThread().getName());
        }
    }
}

// person { personId,
// AddressId
// }

// address {addressId}