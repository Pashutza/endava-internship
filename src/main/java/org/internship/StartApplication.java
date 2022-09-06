package org.internship;

import student.Registrations;

import java.time.LocalDate;

public class StartApplication {
    public static void main(String[] args) {
        System.out.println("Start application");
        System.out.println("readyForErasmus: ");
        Registrations students = new Registrations();
        System.out.println(students.readyForErasmus(LocalDate.of(2022, 5, 1), LocalDate.of(2022, 8, 31)));

        System.out.println("can visit USU: ");
        System.out.println(students.getStudentsCanVisitUniversity("USU"));

        System.out.println("university and students that can visit: ");
        students.getUniversityWithStudents().entrySet().forEach(stringListEntry -> System.out.println(stringListEntry.getKey() + "- " + stringListEntry.getValue()));
    }
}

