package behaviorParameterazation;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {
    public static void main(String[] args) {

        //Check the inventory and find GreenApples and Heavy apples greater than 200
        List<Apple> inventory= new ArrayList<>();
        inventory.add(new Apple(200, Color.GREEN));
        inventory.add(new Apple(100, Color.GREEN));
        inventory.add(new Apple(100, Color.RED));
        inventory.add(new Apple(400, Color.GREEN));
        inventory.add(new Apple(200, Color.GREEN));
        inventory.add(new Apple(200, Color.RED));
        inventory.add(new Apple(220, Color.GREEN));

        inventory.removeIf((apple)->apple.getColor().equals(Color.RED));
       // inventory.stream().filter((apple -> apple.getWeight()>100));
        List<Apple> greenApple= filterApples(inventory, new AppleGreenColor());
        List<Apple> heavyApple= filterApples(inventory, new AppleHeavy());

    }
    private static List<Apple> filterApples(List<Apple> inventories, Inventory inventory) {
        List<Apple> result= new ArrayList<>();

        for(Apple apple:inventories){
            if(inventory.test(apple)){
                String output= inventory.prettyPrintApple(apple);
                System.out.println(output);
                result.add(apple);
            }
        }
        return result;
    }

}
