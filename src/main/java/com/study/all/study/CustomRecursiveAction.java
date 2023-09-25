package com.study.all.study;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {


    @Override
    protected void compute() {
        ForkJoinTask.invokeAll(new CustomRecursiveAction());
    }
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
       // commonPool.submit(CustomRecursiveAction::new);


}
