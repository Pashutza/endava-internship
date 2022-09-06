package student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Registrations {
    static Map<Student, LocalDate> registrations = new HashMap<>();

    Registrations(){
        List<University> universities = new ArrayList<>();
        registrations.put(new Student("1", "Tara", "Serghei", 20,true, ), LocalDate.of(2022, 6, 25));
        registrations.put(new Student("2", "Panico", " Grigore", 22, false,universities ), LocalDate.of(2022, 05, 03));
        registrations.put(new Student("3", "Lazari", "Iurie", 21,true, ), LocalDate.of(2022, 7, 03));
        registrations.put(new Student("4", "Bunduchi", "Mihail", 19, false, ),LocalDate.of(2022, 7, 30));
        registrations.put(new Student("5", "Efros", "Mia", 20,true, ), LocalDate.of(2022, 9, 01));
        registrations.put(new Student("6", "Antoci", " Sofia", 25, false, ),LocalDate.of(2022, 9, 10));
        registrations.put(new Student("7", "Afanasiev", "Tatiana", 22,true, ), LocalDate.of(2022, 8, 23));
        registrations.put(new Student("8", "Ceban", " Natalia", 20, false, ),LocalDate.of(2022, 5, 25));
        registrations.put(new Student("9", "Strut", "Damir", 18,true, ), LocalDate.of(2022, 9, 02));
        registrations.put(new Student("10", "Botnaru", " Ecaterina", 21, false, ),LocalDate.of(2022, 9, 01));
        registrations.put(new Student("11", "Braga", "Ariana", 23,true, ), LocalDate.of(2022, 7, 21));
        registrations.put(new Student("12", "Bulicanu", " Daniela", 24, false, ),LocalDate.of(2022, 6, 14));
        registrations.put(new Student("13", "Gori", "Marcu", 19,true, ), LocalDate.of(2022, 5, 01));
        registrations.put(new Student("14", "Luchian", " Leo", 18, false, ),LocalDate.of(2022, 9, 05));
        registrations.put(new Student("15", "Stavila", "Ioana", 20,true, ), LocalDate.of(2022, 8, 05));
        registrations.put(new Student("16", "Tataru", " Ilaria", 21, false, ),LocalDate.of(2022, 7, 10));

    }

    public static Map<Student, LocalDate> getRegistrations() {
        return registrations;
    }

    public static List<Student> readyForErasmus(LocalDate startTime, LocalDate endTime){
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
