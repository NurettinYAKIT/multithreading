package com.caveofprogramming.threadsync.volatilee;

public class Processor extends Thread{
  
  private volatile boolean running = true;

  @Override
  public void run() {
    while(running){
      System.out.println("Hello ");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
    }
  }
  
  public void shutdown() {
    this.running = false;
  }
}
