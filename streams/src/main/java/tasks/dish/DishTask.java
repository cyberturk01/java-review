package tasks.dish;

import java.util.List;

import static java.util.Comparator.comparing;

public class DishTask {
    public static void main(String[] args) {
        List<Dish> menu= DishData.getData();

        //Print all dish’s name that has less than 400 calories.
        System.out.println("**********************");
        menu.stream()
                .filter(dish-> dish.getCalories() < 400)
                .map(Dish::getName)
                .forEach(System.out::println);

        System.out.println("**********************");
        //Print the length of the name of each dish
        menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .forEach(System.out::println);

        System.out.println("**********************");
        //Print 3 high Caloric Dish Name > 300
        menu.stream()
                .filter(dish -> dish.getCalories()> 300)
                .map(Dish::getName)
                .limit(3)
                .forEach(System.out::println);

        //Print all dish name that are equals to Type Fish
        System.out.println("**********************");
        menu.stream()
                .filter(s-> s.getType().equals(Type.FISH))
                .map(Dish::getName)
                .forEach(System.out::println);

        //Print all dish name that are below 400 calories in sorted
        System.out.println("**********************");
        menu.stream()
                .filter(dish-> dish.getCalories()< 400)
                .sorted(comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .forEach(System.out::println);
    }
}
