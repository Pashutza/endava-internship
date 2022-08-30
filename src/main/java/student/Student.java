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
}
