package tasks.employee;

import java.util.Arrays;
import java.util.stream.Stream;

public class EmployeeData {
    public static Stream<Employee> readAll(){
        return Stream.of(
                new Employee(100, "gokhan", "goekhan.yigit@yigit-groups.eu", Arrays.asList("5052332323","34234223445")),
                new Employee(101, "hale", "hale.yigit@yigit-groups.eu", Arrays.asList("1232232376","56234229848")),
                new Employee(102, "nuran", "nuran.yigit@yigit-groups.eu", Arrays.asList("6532232376","56234229848")),
                new Employee(103, "orhan", "orhan.yigit@yigit-groups.eu", Arrays.asList("3432232376","56234229848"))
        );
    }
}
