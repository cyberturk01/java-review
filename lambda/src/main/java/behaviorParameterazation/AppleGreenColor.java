package behaviorParameterazation;

public class AppleGreenColor implements Inventory {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }

    @Override
    public String prettyPrintApple(Apple apple) {
        String weight = apple.getWeight() > 200 ? "Light" : "Heavy";
        return "A " + weight + " " + apple.getColor() + " apple";
    }
}
