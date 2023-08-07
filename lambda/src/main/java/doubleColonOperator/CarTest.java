package doubleColonOperator;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarTest {
    public static void main(String[] args) {
        //no -arg
        Supplier<Car> c1= ()-> new Car();
        System.out.println(c1.get().getMake());

        Supplier<Car> c2= Car::new;
        System.out.println(c2.get().getMake());

        //one-arg
        Function<Integer, Car> f1= (model)-> new Car(model);
        Car bmw=f1.apply(2009);
        System.out.println(bmw.getModel());

        Function<Integer, Car> f2= Car::new;
        Car apply = f2.apply(2019);
        System.out.println(apply.getModel());

        BiFunction<Integer,String, Car> b1= (make, model) -> new Car(make,model);
        Car n1=b1.apply(2020, "BMW");
        System.out.println(n1.getModel());

        BiFunction<Integer,String, Car> b2= Car::new;
        Car n2=b1.apply(2020, "BMW");
        System.out.println(n2.getModel() + " " + n2.getMake());



    }
}
