package org.yigit;

import java.util.*;
import java.util.stream.Collectors;

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


        System.out.println(ArrayListReview.getGrade(95, 90, 93));
        System.out.println(ArrayListReview.getGrade(100, 85, 96));
        System.out.println(ArrayListReview.getGrade(92, 93, 94));
        System.out.println(ArrayListReview.getGrade(100, 100, 100));
        System.out.println(ArrayListReview.getGrade(65, 70, 59));
        System.out.println(ArrayListReview.getGrade(65,70,59));
        System.out.println(ArrayListReview.getGrade(60,82,76));
    }

    public static char getGrade(int s1, int s2, int s3) {

        List<Integer> grades= Arrays.asList(s1,s2,s3);
        Double collect = grades.stream().collect(Collectors.averagingInt(a -> a));
        System.out.println("collect = " + Math.round( collect));
        System.out.println("collect = " + collect);
        return 'A';
    }
    public static List<Object> filterList(final List<Object> list) {
        // Return the List with the Strings filtered out
        String s = list.stream().map(Object::toString).collect(Collectors.joining());
        String[] split = s.split(",");
        System.out.println(split[2]);
        List<Integer> filter= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(Integer.parseInt(split[i]))){
                filter.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            }
        }
        System.out.println(filter);
        return filter.stream().collect(Collectors.toList());
    }

}
