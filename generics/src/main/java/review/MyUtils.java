package review;

import java.util.ArrayList;
import java.util.List;

public class MyUtils<T extends Person> {

    public void printInfo(List<T> list){
        for(T t: list){
            System.out.println(t);
        }
        System.out.println(list.size());
    }
    public static <T> void printInfoArray(T[] array){
        for (T each : array) {
            System.out.println("eachElement = " + each);
        }
    }

    public static <T> void printInfo2(List<T> list){
        for(T t: list){
            System.out.println(t);
        }
        System.out.println(list.size());
    }
    public T lastElement(List<T> list){
        for(T t: list){
            System.out.println(t);
        }
        return list.get(list.size()-1);
    }

    public static <T> T lastElement2(List<T> list){
        for(T t: list){
            System.out.println(t);
        }
        return list.get(list.size()-1);
    }

    public void nameOfPerson(List<T> list){

        list.forEach(person-> System.out.println(person.getName()));

    }
}
