import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 4, 2, 10, 21, 23);
        //is present
        Optional.of(number).isPresent();

        Optional<Integer> isABigNumber = number.stream()
                .filter(i -> i > 100).findAny();
        //ifPresent, if returns empty does nothing
        isABigNumber.ifPresent(System.out::println);

        System.out.println(isABigNumber.isPresent());

        //orElse
        System.out.println(isABigNumber.orElse(0));


    }
}
