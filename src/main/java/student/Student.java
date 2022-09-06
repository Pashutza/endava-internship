package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private boolean eligibleForErasmusScholarship;
    private List<University> universities = new ArrayList<>();



    public Student(String username, String firstName, String lastName, int age, boolean eligibleForErasmusScholarship, List<University> universities) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.eligibleForErasmusScholarship = eligibleForErasmusScholarship;
        this.universities = universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public List<University> getUniversities() {
        return universities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(username, student.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", eligibleForErasmusScholarship=" + eligibleForErasmusScholarship +
                ", universities=" + universities +
                '}';
    }
}
