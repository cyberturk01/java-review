package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class OrangeTest {
    public static void main(String[] args) {
        List<Orange> inventory= new ArrayList<>();
        inventory.add(new Orange(300, Color.GREEN));
        inventory.add(Orange.builder().weight(200).color(Color.GREEN).build());
        inventory.add(Orange.builder().weight(200).color(Color.GREEN).build());
        inventory.add(Orange.builder().weight(100).color(Color.RED).build());
        inventory.add(Orange.builder().weight(500).color(Color.RED).build());
        inventory.add(Orange.builder().weight(600).color(Color.GREEN).build());


        prettyPrintOrange(inventory, (orange) -> "An Orange of "+ orange.getWeight() + " g");


        Function<Orange, String> fancyFormatter= (orange) -> {
            String weight= orange.getWeight()< 200 ? "Light": "Heavy";
            return "A "+ weight + " " + orange.getColor() + " orange";
        };
        prettyPrintOrange(inventory, fancyFormatter);

    }
    private static void prettyPrintOrange(List<Orange> inventory, Function<Orange, String> orangeFormatter ){
        for(Orange orange : inventory){
            String output= orangeFormatter.apply(orange);
            System.out.println(output);
        }
    }
}
