import tasks.dish.Dish;
import tasks.dish.DishData;

import java.time.Year;
import java.util.Optional;

public class FindMatchOperations {
    public static void main(String[] args) {
        //ALL MATCH
        boolean isHealthy = DishData.getData().stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy = " + isHealthy);

        //ANY MATCH
        boolean isVegetarian = DishData.getData().stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println("isVegetarian = " + isVegetarian);

        //NONE MATCH
        boolean isHealthy2 = DishData.getData().stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("isHealthy2 = " + isHealthy2);

        //FIND ANY
        Optional<Dish> findAny = DishData.getData().stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(findAny.get());

        //FIND FIRST
        Optional<Dish> findFirst = DishData.getData().stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        System.out.println(findFirst.get());
    }
}
