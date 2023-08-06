package functionalInterfaces;

import java.util.Random;
import java.util.function.*;

public class Examples {
    public static void main(String[] args) {

        // **********PREDICATE**********
        //Sample of Anonymous class from predicate
//        Predicate<Integer> lesserThan= new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer<18;
//            }
//        };

//        lesserThan.test(50);

        //implementation of the test method that belongs to Predicate Interface.
        Predicate<Integer> lesserThan= (num) -> num<18;
        System.out.println(lesserThan.test(50));

        // **********CONSUMER**********
        Consumer<Integer> display= System.out::println;
        display.accept(5);

        // **********BiCONSUMER**********
        BiConsumer<Integer, Integer> display2= (num1,num2)-> {
            System.out.println(num1 + num2);
        };
        display2.accept(5,10);
        // **********FUNCTION**********
        Function<String,String > fun= s -> "Hello " + s;
        System.out.println(fun.apply("Gokhan"));

        Function<String,Integer > numberOfChar= String::length;
        System.out.println(numberOfChar.apply("Gokhan"));

        // **********SUPPLIER**********
        Supplier<Double> randomValue = Math::random;
        System.out.println(randomValue.get());


    }
}
