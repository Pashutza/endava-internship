package person;

import java.util.Arrays;

public class Concatenate {
    public static void concatenateValues(Object[] elements) {
        StringBuilder str = new StringBuilder();
        long sum = 0L;
        Person[] people = new Person[elements.length];
        int personCounter = 0;
        for (Object element : elements) {
            if (element instanceof String) {
                str.append(element).append(" ");
            }
            if (element instanceof Character) {
                str.append(element).append(" ");
            }
            if (element instanceof Long) {
                sum += (Long) element;
            }
            if (element instanceof Integer) {
                sum += (Integer) element;
            }
            if (element instanceof Person) {
                people[personCounter++] = (Person) element;
            }
        }
        people = Arrays.copyOf(people, personCounter);

        showResults(str, sum, people);
    }

    private static void showResults(StringBuilder str, long sum, Person[] people) {
        System.out.println("String: " + str);
        System.out.println("Sum: " + sum);
        System.out.println("Persons: " + Arrays.toString(people));
    }
}
