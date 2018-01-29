package com.caveofprogramming.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(3);
    System.out.println("We have a countDown latch :"+latch.getCount());
    
    Processor processor = new Processor(latch);
    ExecutorService service = Executors.newFixedThreadPool(3);
    
    for (int i = 0; i < 3; i++) {
      service.submit(new Processor(latch));
    }
    
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("Completed");
    service.shutdown();
    System.out.println("Threads shut downed");
  }
}
