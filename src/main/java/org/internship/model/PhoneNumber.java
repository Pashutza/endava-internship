package org.internship.model;

import org.internship.util.InputValidator;

public class PhoneNumber {
  private String msisdn;

  public PhoneNumber(String msisdn) {
    InputValidator.msisdnValidate(msisdn);
    this.msisdn = msisdn;
  }

  public String getMsisdn() {
    return msisdn;
  }

}
