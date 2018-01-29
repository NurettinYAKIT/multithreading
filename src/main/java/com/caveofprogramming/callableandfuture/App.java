package com.caveofprogramming.callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class App {


  public static void main(String[] args)  {
    ExecutorService executorService = Executors.newCachedThreadPool();

    Future<Integer> future = executorService.submit(new Callable<Integer>() {

      public Integer call() throws Exception {
        Random rand = new Random();
        int duration = rand.nextInt(4000);
        
        if(duration>2000){
          throw new IOException("Thread is sleeping too long..");
        }

        System.out.println("Starting");

        try {
          Thread.sleep(duration);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("Finished");
        return duration;
      }
    });

    executorService.shutdown();
//    executorService.awaitTermination(1, TimeUnit.DAYS);
    
    try {
      System.out.println("Result is: "+future.get() );
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e);
    }
  }

  private void process() {
    System.out.println("Starting");
    Random rand = new Random();
    try {
      Thread.sleep(rand.nextInt(2000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Finished");
  }

}

