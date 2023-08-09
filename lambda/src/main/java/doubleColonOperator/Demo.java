package doubleColonOperator;

import javax.swing.event.CaretListener;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        Calculate add1= (x,y)-> Calculator.findSum(x,y);;
        add1.calculate(5,5);

        Calculate add2= Calculator::findSum;;
        add2.calculate(5,6);

        Calculate multiply= (x,y)->new Calculator().findMultiply(x,y);
        multiply.calculate(5,5);

        Calculate multiply2= new Calculator()::findMultiply;
        multiply2.calculate(4,5);

        BiFunction<String,Integer,String> fn= (str,i) -> str.substring(i);
        System.out.println(fn.apply("Gokhan", 2));

        Consumer<Integer> display= System.out::println;
        display.accept(19);

//        Function<Integer, int[]> f1= (num)-> {
//            int [] n= num.
//        }



    }
}
