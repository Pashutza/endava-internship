package org.internship;

import org.internship.exception.AmountValidationException;
import org.internship.exception.MsisdnValidationException;
import org.internship.logging.Action;
import org.internship.model.Amount;
import org.internship.model.PhoneNumber;

import java.math.BigDecimal;
import java.util.Scanner;

public class Payment {
  public static PhoneNumber enterPhoneNumber(Scanner scanner) {
    int attempts = 0;
    while (attempts < 4) {
      attempts++;
      System.out.println("Introduceti Numarul dv-ra:");
      try{
        String msisdn = scanner.nextLine();
        Action.logging("Introducerea numarului " + msisdn);
        return new PhoneNumber(msisdn);
      } catch (MsisdnValidationException e){
        System.out.println("A fost introdus format gresit");
        System.out.println("Formate valide: +373 60 xxxxxx +(373)-79-xx-xx-xx +373 79 xxx-xxx");
      }
    }
    throw new MsisdnValidationException("Exceeded the number of attempts");
  }

  public static Amount enterAmount(Scanner scanner) {
    int attempts = 0;
    while (attempts < 3) {
      attempts++;
      System.out.println("Introduceti suma:");
      try{
        BigDecimal sum = scanner.nextBigDecimal();
        Action.logging("Introducerea sumei de " + sum);
        return new Amount(sum);
      } catch (AmountValidationException amountEx){
        System.out.println("A fost introdus suma gresita");
        System.out.println("Suma trebuie sa fie in intervalul 10 - 500");
      }
    }
    throw new AmountValidationException("Exceeded the number of attempts");
  }
}
