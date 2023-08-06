package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static review.MyUtils.*;

public class GenericsReview {

    public static void main(String[] args) {
        List<Student> studentList= new ArrayList<>();
        studentList.add( new Student("gok", 1));
        studentList.add( new Student("gok2", 2));
        studentList.add( new Student("gok3", 3));

        List<Teacher> teachersList = new ArrayList<>();
        teachersList.add(new Teacher("nur1", 1));
        teachersList.add(new Teacher("nur2", 2));
        teachersList.add(new Teacher("nur3", 3));

        printInfo2(studentList);
        printInfo2(teachersList);
        lastElement2(studentList);
        lastElement2(teachersList);

        MyUtils<Student> student= new MyUtils<>();

        student.nameOfPerson(studentList);

        MyUtils<Teacher> teacher= new MyUtils<>();

        teacher.nameOfPerson(teachersList);
    }

}
