package org.internship.model;

import org.internship.util.InputValidator;

import java.math.BigDecimal;

public class Amount {
  private BigDecimal amount;

  public Amount(BigDecimal amount) {
    InputValidator.amountValidate(amount);
    this.amount = amount;
  }

  public BigDecimal getAmount() {
    return amount;
  }
}
