package student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Registrations {
    public static Map<Student, LocalDate> registrations = new HashMap<>();

    public Registrations(){
        University ust = new University("UST");
        University usm = new University("USM");
        University usl = new University("USL");
        University usu = new University("USU");
        List<University> universities1 = new ArrayList<>();
        universities1.add(ust);
        List<University> universities2 = new ArrayList<>();
        universities2.add(usm);
        universities2.add(usl);
        List<University> universities3 = new ArrayList<>();
        universities3.add(ust);
        universities3.add(usu);
        registrations.put(new Student("1", "Tara", "Serghei", 20,true, universities1), LocalDate.of(2022, 6, 25));
        registrations.put(new Student("2", "Panico", "Grigore", 22, false,universities2 ), LocalDate.of(2022, 5, 3));
        registrations.put(new Student("3", "Lazari", "Iurie", 21,true, universities3), LocalDate.of(2022, 7, 3));
        registrations.put(new Student("4", "Bunduchi", "Mihail", 19, false, universities3),LocalDate.of(2022, 7, 30));
        registrations.put(new Student("5", "Efros", "Mia", 20,true, universities2), LocalDate.of(2022, 9, 1));
        registrations.put(new Student("6", "Antoci", "Sofia", 25, false, universities3),LocalDate.of(2022, 9, 10));
        registrations.put(new Student("7", "Afanasiev", "Tatiana", 22,true, universities2), LocalDate.of(2022, 8, 23));
        registrations.put(new Student("8", "Ceban", "Natalia", 20, false, universities1),LocalDate.of(2022, 5, 25));
        registrations.put(new Student("9", "Strut", "Damir", 18,true, universities3), LocalDate.of(2022, 9, 2));
        registrations.put(new Student("10", "Botnaru", "Ecaterina", 21, false, universities2),LocalDate.of(2022, 9, 1));
        registrations.put(new Student("11", "Braga", "Ariana", 23,true, universities2), LocalDate.of(2022, 7, 21));
        registrations.put(new Student("12", "Bulicanu", "Daniela", 24, false, universities3),LocalDate.of(2022, 6, 14));
        registrations.put(new Student("13", "Gori", "Marcu", 19,true, universities1), LocalDate.of(2022, 5, 1));
        registrations.put(new Student("14", "Luchian", " Leo", 18, false, universities3),LocalDate.of(2022, 9, 5));
        registrations.put(new Student("15", "Stavila", "Ioana", 20,true, universities1), LocalDate.of(2022, 8, 5));
        registrations.put(new Student("16", "Tataru", " Ilaria", 21, false, universities3),LocalDate.of(2022, 7, 10));

    }

    public static Map<Student, LocalDate> getRegistrations() {
        return registrations;
    }

    public List<Student> readyForErasmus(LocalDate startTime, LocalDate endTime){
        return registrations.entrySet().stream().filter(studentLocalDateTimeEntry -> studentLocalDateTimeEntry.getValue().isAfter(startTime)
        && studentLocalDateTimeEntry.getValue().isBefore(endTime)).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsCanVisitUniversity(String universityName){
        List<Student> students = new ArrayList<>(registrations.keySet());
        List<Student> eligibilityStudents = new ArrayList<>();
        for (Student student: students) {
            student.getUniversities().stream()
                    .filter(university -> universityName.equals(university.getName()))
                    .forEach(university -> eligibilityStudents.add(student));
        }
        return eligibilityStudents;
    }

    public Map<String,List<Student>> getUniversityWithStudents(){
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
