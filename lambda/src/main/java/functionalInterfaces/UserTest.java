package functionalInterfaces;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UserTest {
    public static void main(String[] args) {
        List<User> userList= new ArrayList<>();
        userList.add(new User("Gokhan","Yigit", 41));
        userList.add(new User("Nuran","Yigit", 33));
        userList.add(User.builder().firstName("Hale").lastName("Yigit").age(7).build());
        userList.add(new User("Orhan","EYigit", 1));

        //Print all elements in the list
        printElements(userList, p -> true);
        //Print all elements that last name starts with E
        printElements(userList, p -> p.getLastName().startsWith("E"));
        //Print all elements that age is equals to 33
        printElements(userList, p -> p.getAge()==33);


        //Print all elements in the list
        Consumer<List<User>> printElements= System.out::println;
        printElements.accept(userList);

        //Print all elements that last name starts with E
        Function<List<User>, List<User>> allElementsEndE=(list)-> {
            List<User> name= new ArrayList<>();
            for( User user: list){
                if(user.getLastName().startsWith("E")){
                    name.add(user);
                }
            }
            return name;
        };
        System.out.println(allElementsEndE.apply(userList));
    }
    private static void printElements(List<User> list, Predicate<User> p){
        for(User user: list){
            if(p.test(user)){
                System.out.println(user.toString());
            }
        }
    }
}
