import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(90, 10, 120, 70, 20, 30, 40, 50));

        System.out.println(numbers);

        //removeIf use with Predicate best way of deleting lists
        numbers.removeIf(num -> num >= 90);
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("numbers = " + numbers);
    }
}
