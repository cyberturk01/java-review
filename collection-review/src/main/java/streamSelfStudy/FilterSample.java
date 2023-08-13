package streamSelfStudy;

import java.util.Arrays;
import java.util.List;

public class FilterSample {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(3,4,5,2,1,3,4,4,5,6,7,2,1,9);

        //filter returns Predicate
        //foreach returns Consumer
        list1.stream()
                .filter(n-> !n.equals(4))
                .forEach(System.out::println);

        System.out.println("###########New Sample");

        list1.stream()
                .filter(n-> n>4)
                .forEach(System.out::println);

    }
}
