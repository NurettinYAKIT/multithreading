package com.caveofprogramming.creation.runnable;

public class App {

  public static void main(String[] args) {
   Thread thread = new Thread(new Runner());
   Thread thread2 = new Thread(new Runner());
   
   thread.start();
   thread2.start();
  }
}
