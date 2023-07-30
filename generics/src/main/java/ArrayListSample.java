import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListSample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(90, 10, 120, 70, 20, 30, 40, 50));

        System.out.println(numbers);

        //removeIf use with Predicate
        numbers.removeIf(num -> num >= 90);
        System.out.println(numbers);

        Collections.sort(numbers);
        System.out.println("numbers = " + numbers);
    }

    static int[] getMinMax(List<Integer> list) {
        int[] result = new int[2];
        int min = list.get(0);
        if (list.size() == 1) {
            result[0] = min;
        } else {
            int max = list.get(1);
            if (min < max) {
                result[0] = min;
                result[1] = max;
            } else {
                result[0] = max;
                result[1] = min;
            }
        }
        return result;
    }
}
