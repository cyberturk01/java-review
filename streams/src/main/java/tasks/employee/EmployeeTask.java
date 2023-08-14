package tasks.employee;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeTask {
    public static void main(String[] args) {

        //print all emails
        EmployeeData.readAll()
                .map(Employee::getEmpEmail)
                .forEach(System.out::println);
        System.out.println("**********************");

        //print all phoneNumbers
        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .forEach(System.out::println);

        System.out.println("**********************");
        //print all phoneNumbers separately
        EmployeeData.readAll()
                .flatMap(s->s.getEmpPhoneNumbers().stream())
                .forEach(System.out::println);

        //print all phoneNumbers separately
        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .flatMap(List::stream)
                .forEach(System.out::println);
    }
}
