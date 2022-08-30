package student;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Registrations {
    static Map<Student, LocalDateTime> registrations = new HashMap<>();

    Registrations(){
        registrations.put(new Student(),LocalDateTime.now());
        registrations.put(new Student(),LocalDateTime.now());
    }

    public static Map<Student, LocalDateTime> getRegistrations() {
        return registrations;
    }

    public static List<Student> readyForErasmus(LocalDateTime startTime, LocalDateTime endTime){
        return registrations.entrySet().stream().filter(studentLocalDateTimeEntry -> studentLocalDateTimeEntry.getValue().isAfter(startTime)
        && studentLocalDateTimeEntry.getValue().isBefore(endTime)).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsCanVisitUniversity(String universityName){
        List<Student> students = new ArrayList<>(registrations.keySet());
        List<Student> eligibilityStudents = new ArrayList<>();
        for (Student student: students) {
            student.getUniversities().stream()
                    .filter(university -> universityName.equals(university.getName()))
                    .forEach(university -> eligibilityStudents.add(student));
        }
        return eligibilityStudents;
    }

    public static Map<String,List<Student>> getUniversityWithStudents(){
        List<Student> students = new ArrayList<>(registrations.keySet());
        Set<String> universities = new HashSet<>();
        Map<String,List<Student>> universityWithStudents = new HashMap<>();
        for (Student student: students) {
            for( University university: student.getUniversities()){
               universities.add(university.getName());
            }
            for(String university: universities){
                universityWithStudents.put(university, getStudentsCanVisitUniversity(university));
            }

        }
        return universityWithStudents;

    }


}
