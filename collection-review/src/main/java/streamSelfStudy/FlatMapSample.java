package streamSelfStudy;

import java.util.Arrays;
import java.util.List;


public class FlatMapSample {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Peter",20, Arrays.asList("1","2")),
                new User("Gok",40, Arrays.asList("3","5","4")),
                new User("Sam",50, Arrays.asList("5","6")),
                new User("Greg",30,Arrays.asList("7","4")),
                new User("Ryan",45,Arrays.asList("8","3"))
        );

        String s = users.stream()
                .map(user -> user.getPhoneNumber().stream())
                .flatMap(stringStream -> stringStream.filter(phoneNo -> phoneNo.equals("10")))
                .findAny().orElse("2");

        System.out.println(s);

    }
}
