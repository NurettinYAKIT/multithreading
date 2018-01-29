package com.caveofprogramming.waitandnotify;

import java.util.Scanner;

public class Processor {
  
  public void consume() throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    
    Thread.sleep(1000);
    synchronized (this) {
      System.out.println("Waiting for return key");
      scanner.nextLine();
      notify();
      System.out.println("Return key pressed.");
      Thread.sleep(3000);
    }

  }
  
  public void produce() throws InterruptedException {
    synchronized (this) {
      System.out.println("Producer thread running..");
      wait();
      System.out.println("Resumed. Wait finished.");
    }
  }

}
