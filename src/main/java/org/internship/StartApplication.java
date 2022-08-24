package org.internship;

import person.Concatenate;
import person.Person;

public class StartApplication {
    public static void main(String[] args) {
        System.out.println("Start application");
        Object[] array = {"Today", new Person("Efros", "Parascovia", 38, "f"), 32344234234l,
                "is", 23, 652, "a", new Person("Efros", "Ion", 3, "f"), "big", "day"};
        Concatenate.concatenateValues(array);
    }

}

