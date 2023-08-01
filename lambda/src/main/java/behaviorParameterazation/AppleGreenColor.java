package behaviorParameterazation;

public class AppleGreenColor implements Inventory {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }

    @Override
    public String prettyPrintApple(Apple apple) {
        if(apple.getWeight()>200){
            return "A Light "+apple.getColor()+" apple";
        }else{
            return "A Heavy "+apple.getColor()+" apple";
        }
    }
}
