package org.internship.logging;

import java.time.LocalDateTime;

public class Action {
  public static void logging(String message){
    System.out.println("###" + LocalDateTime.now() + " - " + message + "###");
  }
}
