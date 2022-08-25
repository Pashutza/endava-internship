package org.internship;

import sun.awt.geom.AreaOp;
import valuesofgrading.Grades;

public class StartApplication {
    public static void main(String[] args) {

        System.out.println("Start application");

        System.out.println("The next element of " + Grades.GOOD + " is: " + Grades.GOOD.next());
        System.out.println("The previous element of " + Grades.GOOD + " is: " + Grades.GOOD.previous());
        System.out.println("All grades are: ");
        Grades.showAll();
    }
}

