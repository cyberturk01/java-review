import tasks.dish.Dish;
import tasks.dish.DishData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {

        //REDUCE
        Optional<Integer> totalCalories = DishData.getData().stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum);
        System.out.println("totalCalories = " + totalCalories.get());

        List<Integer> numbers= Arrays.asList(4,5,3,9);

        Optional<Integer> totalNumbers = numbers.stream().reduce(Integer::sum);
        System.out.println("totalNumbers = " + totalNumbers);

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::min);

    }
}
