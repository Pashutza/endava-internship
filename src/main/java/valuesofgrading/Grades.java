package valuesofgrading;

import java.util.Arrays;

public enum Grades {
    BASIC,
    ACCEPTABLE,
    SATISFACTORY,
    GOOD,
    VERY_GOOD,
    EXCELLENT,
    OUTSTANDING;

    private static Grades[] grades = values();

    public Grades next() {
        if (this.ordinal() == grades.length - 1) {
            return grades[(this.ordinal())];
        } else {
            return grades[(this.ordinal() + 1)];
        }
    }

    public Grades previous() {
        if (this.ordinal() == 0) {
            return grades[(this.ordinal())];
        } else {
            return grades[(this.ordinal() - 1)];
        }
    }

    public static void  showAll() {
        System.out.println(Arrays.asList(values()));
    }



}

