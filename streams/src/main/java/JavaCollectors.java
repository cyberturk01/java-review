import tasks.dish.Dish;
import tasks.dish.DishData;
import tasks.dish.Type;

import java.util.*;
import java.util.stream.Collectors;

public class JavaCollectors {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(3, 4, 5, 6, 6, 7);
        //toCollection(Supplier)
        ArrayList<Integer> numList = num.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(numList);

        Set<Integer> numSet = num.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(numSet);

        //toList()
        List<Integer> collectToList = num.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collectToList);

        //toSet()
        Set<Integer> collectToSet = num.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(collectToSet);

        //toMap(FUNCTION,FUNCTION)
        Map<String, Integer> dishMap = DishData.getData().stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println(dishMap);

        //counting: Counts the number of element
        Long collectCounting = num.stream()
                .filter(a -> a % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(collectCounting);

        //summingInt(ToIntFunction) returns sum of integer value function
        Integer sumCalories= DishData.getData().stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sumCalories);

        //averagingInt(ToIntFunction) returns average
        Double caloriesAvg = DishData.getData().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(caloriesAvg);

        //joining()
        List<String> courses = Arrays.asList("JAVA", "JS", "TS");
        String str= courses.stream().collect(Collectors.joining(","));
        System.out.println(str);

        //partitioningBy()
        Map<Boolean, List<Dish>> isVegetarian = DishData.getData().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println("isVegetarian = " + isVegetarian);

        //GroupingBy()
        Map<Type, List<Dish>> dishType = DishData.getData().stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println("dishType = " + dishType);


    }
}
