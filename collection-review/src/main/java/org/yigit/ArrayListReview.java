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

        //Comparator sort
        Collections.sort(students, new sortByIdDesc());
        System.out.println("students Desc Id= " + students);

        Collections.sort(students, new sortByIdAsc());
        System.out.println("students Asc Id= " + students);

        Collections.sort(students, new sortByNameAsc());
        System.out.println("students By Name= " + students);

        Collections.sort(students, new sortByNameDesc());
        System.out.println("students By Name= " + students);
    }
    static class sortByIdDesc implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id- o1.id;
        }
    }
    static class sortByIdAsc implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id- o2.id;
        }
    }
    static class sortByNameAsc implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareToIgnoreCase(o2.name);
        }
    }
    static class sortByNameDesc implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }
}
