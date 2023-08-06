package org.yigit;

import java.util.*;

public class ArrayListReview {
    public static void main(String[] args) {
        List<Student> students= new ArrayList<>();
        students.add((new Student(1, "Jose")));
        students.add((new Student(2, "Hale")));
        students.add((new Student(3, "Orhan")));
        students.add((new Student(4, "Nuran")));
        System.out.println("students = " + students);
//for loop
        for (int i = 0; i < students.size(); i++) {
            System.out.println("students = " + students.get(i));
        }

        //forward iterator
        Iterator iter = students.listIterator();
        while (iter.hasNext()){
            System.out.println("iter. student = " + iter.next());
        }

        Iterator it= students.listIterator(2);
        while (it.hasNext()){
            System.out.println("iter2 = " + it.next());
        }

        //backward iterator
        while (((ListIterator<?>) iter).hasPrevious()){
            System.out.println("iter.back. student = " + ((ListIterator<?>) iter).previous());
        }

        //foreach
        for (Student student : students) {
            System.out.println("student foreach= " + student);
        }
        //lambda
        students.forEach((student)-> System.out.println("students lambda = " + student));

    }

}
