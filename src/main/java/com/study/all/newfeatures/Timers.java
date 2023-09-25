package com.study.all.newfeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Timers {


    public static void main(String[] args) throws InterruptedException {
        testTimer();
    }

    public static void testTimer() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Runnable> runnables = new ArrayList<>();
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    semaphore.acquireUninterruptibly(3);
                    System.out.println("The Task is running no : " + finalI);
                    semaphore.release(3);
                }
            };
            runnables.add(task);
        }


        for (Runnable runnable : runnables) {
            Future<?> submit = executorService.submit(runnable);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("The Task is running");
            }
        };

        Timer timer = new Timer("Timer");

        long delay = 1000L;
        timer.schedule(task, delay);


        ExecutorService executorServiceForCallable = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = new ArrayList<>();
        Callable<String> callable = null;
        for (int i = 0; i < 100; i++) {
            int a = i;
            callable = () -> "In callable" + a;
            callables.add(callable);
        }


        CompletableFuture.supplyAsync(() -> callables)
                .thenApply(callable1 -> callable1.stream().filter(stringCallable -> {
                    try {
                        return stringCallable.call().length() % 2 == 0;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).toList())
                .thenAccept(s -> System.out.println(s));


//        List<CompletableFuture<String>> futures = (List<CompletableFuture>) executorServiceForCallable.invokeAll(callables);
//
//        futures.get(0).


    }
}
