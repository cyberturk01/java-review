package comparatorInterface;

import behaviorParameterazation.Apple;
import behaviorParameterazation.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(10,0,15,5,20);

        Comparator<Integer> l1= ((x,y) -> y-x );
        list.sort(l1); //pass the parameter

        list.sort(new MyComparator()); // use the interface
        System.out.println(list);

        list.sort(((o1, o2) -> o1.compareTo(o2))); // use compareTo
        list.sort(Integer::compareTo); // or shortcut
        System.out.println(list);

        Collections.reverse(list); //descending order
        System.out.println(list);

        List<Apple> myInventory = Arrays.asList(
                new Apple(100, Color.GREEN),
                new Apple(200, Color.GREEN),
                new Apple(150, Color.RED),
                new Apple(210, Color.GREEN),
                new Apple(310, Color.RED),
                new Apple(110, Color.GREEN),
                new Apple(140, Color.RED)
        );

        //Ascending Sort
        Comparator<Apple> comparing = comparing(Apple::getWeight);
        myInventory.sort(comparing);

        //Descending Sort
        myInventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(myInventory);

        //Ascending Sort for Color
        myInventory.sort(comparing(Apple::getColor));
        System.out.println(myInventory);

        //Descending Sort based on weight and color
        myInventory.
                sort(comparing(Apple::getWeight).
                reversed().
                thenComparing(Apple::getColor));
        System.out.println(myInventory);


    }
}
