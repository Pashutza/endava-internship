package org.internship.exception;

public class AmountValidationException extends RuntimeException{
  public AmountValidationException(String message) {
    super(message);
  }
}
