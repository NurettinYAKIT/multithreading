package com.caveofprogramming.interrupt;

import java.util.Random;

public class App {

  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    System.out.println("Started");
    Thread t1 = new Thread(new Runnable() {
      
      public void run() {
        Random rand = new Random();
        for(int i=0; i<1E8; i++){
//          if(Thread.currentThread().isInterrupted()){
//            System.out.println("Interrupted!");
//            break;
//          }
          
          try {
            Thread.sleep(1);
          } catch (InterruptedException e) {
            System.out.println("Interrupted!");
            break;
          }
          Math.sin(rand.nextDouble());
        }
      }
    });
    t1.start();
    
    Thread.sleep(500);
    t1.interrupt();
     
    t1.join();
    
    long finish = System.currentTimeMillis();
    System.out.println("Fnished in : " + (finish-start)+" millis." );
  }
}
