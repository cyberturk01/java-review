package tasks.state;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StateTask {
    public static void main(String[] args) {
        State california= new State();
        california.addCity("San Jose");
        california.addCity("San Francisco");
        california.addCity("San Diego");

        State texas= new State();
        california.addCity("Dallas");
        california.addCity("Houston");
        california.addCity("San Antonio");

        State florida= new State();
        california.addCity("Miami");
        california.addCity("Havana");
        california.addCity("Orlando");

        List<State> states = Arrays.asList(california, texas, florida);

        states.stream()
                .map(State::getCities)
                .flatMap(List::stream)
                .forEach(System.out::println);

        //Given a list of numbers how would you return a list of the square of each
        //number? For example, given [1,2,3,4,5] you should return [1,4,9,16,25]

        List<Integer>  list= Arrays.asList(1,2,3,4,5);
        list.stream()
                .map(s-> (int)Math.pow(s,2))
                .forEach(System.out::println);

//        Given two lists of numbers, how would you return all pairs of numbers? For
//        example, given a list [1,2,3] and a list [3,4] you should
//        return [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)]  Sor!!
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

//        List<int[]> pairs =

    }
}
