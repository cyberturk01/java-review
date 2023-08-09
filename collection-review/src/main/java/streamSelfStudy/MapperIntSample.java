package streamSelfStudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperIntSample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter","Gok","Sam","Greg","Ryan");

        List<User> collect = names.stream()
                .filter(n -> !n.equals("Sam"))
                .map(User::new)
                .collect(Collectors.toList());

        int sum= collect.stream()
                .mapToInt(User::getAge)
                .sum();
        System.out.println(sum);
    }
}
