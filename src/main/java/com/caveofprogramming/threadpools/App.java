package com.caveofprogramming.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
  
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    
    for(int i=0; i<5; i++){
      executorService.submit(new Processor(i));
    }
    
    executorService.shutdown();
    System.out.println("All tasks submitted");

    try {
      executorService.awaitTermination(1, TimeUnit.DAYS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("All tasks completed");
  }

}
