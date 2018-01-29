package com.caveofprogramming.creation.runnable;

public class Runner implements Runnable{

  public void run() {
    for(int i=0; i<10; i++){
      System.out.println("Hello from runnable "+i);
      
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }    
  }

}
