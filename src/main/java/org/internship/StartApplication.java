package org.internship;


import org.internship.exception.AmountValidationException;
import org.internship.logging.Action;
import org.internship.model.Amount;
import org.internship.model.PhoneNumber;

import java.util.Scanner;

public class StartApplication {
    public static void main(String[] args) {
        System.out.println("Start application");
        System.out.println("Bine ati venit, apasati enter pentru a efectua o incarcare!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Action.logging("Start");
        try{
            PhoneNumber phoneNumber = Payment.enterPhoneNumber(scanner);
            Amount amount = Payment.enterAmount(scanner);
            System.out.println("Numarul " + phoneNumber.getMsisdn() + " a fost reincarcat cu " + amount.getAmount() + "lei");
            Action.logging("Numarul " + phoneNumber.getMsisdn() + " incarcat cu " + amount.getAmount());
        } catch (AmountValidationException amountEx){
            System.out.println("A fost depasit numarul de incercari");
            System.out.println("Incercati mai tarziu");
            Action.logging("Iesire fortata din program");
        }
    }
}

