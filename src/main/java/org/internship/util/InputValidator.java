package org.internship.util;

import org.internship.exception.AmountValidationException;
import org.internship.exception.MsisdnValidationException;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class InputValidator {
  public static void msisdnValidate(String msisdn){
    if(!isMatches(msisdn)){
      throw new MsisdnValidationException("Wrong format");
    }
  }

  public static void amountValidate(BigDecimal amount){
    if(amount.compareTo(new BigDecimal("10")) < 0 || amount.compareTo(new BigDecimal("500")) > 0){
      throw new AmountValidationException("Amount outside the range");
    }
  }

  public static boolean isMatches(String msisdn) {
    return Pattern.matches("\\+373\\s60\\s\\d{6}",msisdn)//+373 60 xxxxxx
        || Pattern.matches("\\+373\\s79\\s\\d{3}-\\d{3}",msisdn)//+373 79 xxx-xxx
        || Pattern.matches("\\+\\(373\\)-79-\\d{2}-\\d{2}-\\d{2}",msisdn);//+(373)-79-xx-xx-xx
  }

}
