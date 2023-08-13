import java.util.Arrays;
import java.util.List;

public class StreamOperations {
    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(1,2,4,3,4,5,6,5,6,7);
//        myList.forEach(System.out::println);

        //Filter
        System.out.println("Filter");
        myList.stream()
                .filter( i -> i%3 ==0)
                .distinct() //show unique ones
                .forEach(System.out::println);

        //Limit
        System.out.println("Limit");
        myList.stream()
                .filter( i -> i%2 ==0)
                .limit(3) //is used to retrieve a number of elements from the Stream
                .forEach(System.out::println);

        //Skip
        System.out.println("Skip");
        myList.stream()
                .filter( i -> i%2 ==0)
                .skip(1) //discards the first n elements of a stream
                .forEach(System.out::println);

        //Map
        System.out.println("Map");
        myList.stream()
                .map(i->i*3) //applying the given function to the elements of this stream.
                .filter( i -> i%2 ==0)
                .skip(1)
                .forEach(System.out::println);
    }
}
