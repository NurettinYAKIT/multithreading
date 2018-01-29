package com.caveofprogramming.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {
  
  public static void main(String[] args) throws InterruptedException {
    
    ExecutorService executor = Executors.newCachedThreadPool();
    for(int i=0; i<200; i++){
      executor.submit(new Runnable() {
        public void run() {
          Connection.getInstance().connect();
        }
      });
    }
    
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.DAYS);
    
  }

  private static void semExample() throws InterruptedException {
    Semaphore semaphore = new Semaphore(1);

    //increase
    semaphore.release();
    //decrease
    semaphore.acquire();
    
    System.out.println("Available permits: "+ semaphore.availablePermits());
  }

}
