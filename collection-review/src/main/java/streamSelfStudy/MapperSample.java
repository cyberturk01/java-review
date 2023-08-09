package streamSelfStudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperSample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter","Gok","Sam","Greg","Ryan");

        names.stream()
                .filter(n->!n.equals("Sam"))
                .map(User::new)
                .forEach(System.out::println);

        List<User> collect = names.stream()
                .filter(n -> !n.equals("Sam"))
                .map(User::new)
                .collect(Collectors.toList());
    }
}
