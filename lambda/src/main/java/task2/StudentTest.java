package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        //PREDICATE --> “Mathematics” students from the above listOfStudents
        listSpecializationPred(listOfStudents, student -> student.getSpecialization().equals("Mathematics"));
        listSpecializationPred(listOfStudents, student -> student.getPercentage() > 85.0);

        //CONSUMER-->Displaying all students with "name" and their "percentage"
        listSpecializationConsumer(listOfStudents, student -> {
            System.out.println(student.getName() + " : " +student.getPercentage());
        });

        System.out.println(listSpecializationFunction(listOfStudents, Student::getName));

        //SUPPLIER --> Creating a new Student
        Supplier<Student> studentSupplier= ()->new Student(23,"Gokhan", 99.0,"Computers");
        listOfStudents.add(studentSupplier.get());

    }
    public static List<Student> listSpecializationPred(List<Student> list, Predicate<Student> p){
        List<Student> result= new ArrayList<>();
        for(Student student: list){
            if(p.test(student)){
                result.add(student);
            }
        }
        System.out.println(result);
        return result;
    }
    public static void listSpecializationConsumer(List<Student> list, Consumer<Student> c){
        for(Student student: list){
            c.accept(student);
        }
    }
    public static String listSpecializationFunction(List<Student> list, Function<Student,String> f){
        List<String> studentNames = new ArrayList<>();

        for(Student student: list){
            studentNames.add(f.apply(student));
        }
        return studentNames.toString();
    }
}
