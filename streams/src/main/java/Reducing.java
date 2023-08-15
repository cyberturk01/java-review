import tasks.dish.Dish;
import tasks.dish.DishData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Reducing {
    public static void main(String[] args) {

        //REDUCE
        List<Integer> numbers= Arrays.asList(4,5,3,9);

        Optional<Integer> totalNumbers = numbers.stream().reduce((a,b)->a+b);
        System.out.println("totalNumbers = " + totalNumbers);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);
        System.out.println(min.get());
        System.out.println(max.get());
        System.out.println(sum.get());

        //total Number of calories
        DishData.getData().stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum)
                .ifPresent(sums -> System.out.println("totalCalories = " + sums));

        //total Number of dishes
        long totalDishes = DishData.getData().stream()
                .map(count->1)
                .reduce(0,Integer::sum);
        System.out.println("totalDishes = " + totalDishes);

        long totalDishesWithCount = DishData.getData().stream()
                .map(Dish::getName)
                .count();
        System.out.println("totalDishesWithCount = " + totalDishesWithCount);

        System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
        System.out.println(squareSum(new int[]{1, 2, 2}));
    }

    public static char getGrade(int s1, int s2, int s3) {
        List<Integer> grades= Arrays.asList(s1,s2,s3);
        Optional<Integer> sumOfGrades = grades.stream().reduce(Integer::sum);
        int a = sumOfGrades.get() / 3;

        return a < 60 ? 'F': a <=70 ? 'D' : a<=80 ? 'C' : a<=90 ? 'B' : a<=100 ? 'A' : 'G' ;
    }
    public static int squareSum(int[] n) {
        return (int) Arrays.stream(n)
                .mapToDouble(s-> Math.pow(s,2))
                .reduce(Double::sum).orElse(0);
    }
    public static String highAndLow(String numbers) {

        String[] split = numbers.split(" ");
        int max = Arrays.stream(split).mapToInt(Integer::valueOf).max().orElse(0);
        int min = Arrays.stream(split).mapToInt(Integer::valueOf).min().orElse(0);
        return max + " " + min;
    }
}
