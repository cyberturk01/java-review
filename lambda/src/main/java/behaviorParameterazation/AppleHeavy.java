package behaviorParameterazation;

public class AppleHeavy implements Inventory{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 200;
    }

    @Override
    public String prettyPrintApple(Apple apple) {
        return "An apple of "+apple.getWeight()+"g";
    }
}
