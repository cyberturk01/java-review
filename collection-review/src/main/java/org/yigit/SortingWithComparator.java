package org.yigit;

import java.util.*;
import java.util.stream.Collectors;

public class SortingWithComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add((new Student(1, "Jose1")));
        students.add((new Student(2, "Hale2")));
        students.add((new Student(3, "Orhan3")));
        students.add((new Student(4, "Nuran4")));
        students.add((new Student(2, "Hale2")));

        //Frequency
        System.out.println("Name : " + Collections.frequency(students, students.get(1)));

        Comparator<Student> nc1 = (o1, o2) -> o1.name.compareToIgnoreCase(o2.name);
        Comparator<Student> nc2 = (o1, o2) -> o2.id - o1.id;
        Collections.sort(students, nc2);
        System.out.println(students);

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
        //o2-01 desc order with compare
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    static class sortByIdAsc implements Comparator<Student> {
        //o1-02 desc order with compare
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
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
