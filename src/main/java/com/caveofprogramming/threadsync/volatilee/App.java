package com.caveofprogramming.threadsync.volatilee;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Processor p1 = new Processor();
    p1.start();
    
    System.out.println("Press return to stop");
    
    Scanner scan = new Scanner(System.in);
    scan.nextLine();
    p1.shutdown();
  }
}
