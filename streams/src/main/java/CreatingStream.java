import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStream {
    public static void main(String[] args) {
        //Creating Stream from array
        String[] courses = {"Java","JS", "TS"};
        Stream<String> courseStream = Arrays.stream(courses);
        String j = courseStream.filter((a) -> a.startsWith("J")).collect(Collectors.joining());
        System.out.println(j);

        //Creating Stream from Collection
        List<String> courseList = Arrays.asList("Java","JS", "TS");
        Stream<String> courseStream2 = courseList.stream();

        //Creating Stream from Class name Collection
        List<Course> myCourse = Arrays.asList(
                new Course("Java", 100),
                new Course("DS",101),
                new Course("Spring", 102),
                new Course("MicroServices", 103),
                new Course("JS", 103)
        );
        Stream<Course> myCourseStream = myCourse.stream();

        //Creating Stream from Values
        Stream<Integer> stream = Stream.of(1,2,4,5,6,7);


        myCourse.stream()
                .filter( i -> i.getCourseName().startsWith("J"))
                .map(i-> i.getCourseName().toUpperCase()) //applying the given function to the elements of this stream.
                .forEach(System.out::println);

    }
}
