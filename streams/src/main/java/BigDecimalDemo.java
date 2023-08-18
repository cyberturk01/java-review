import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    public static void main(String[] args) {
        Double num1 = 174.54;
        Double num2 = 174.23;
        System.out.println(num1-num2);

        BigDecimal b1= new BigDecimal("174.54");
        BigDecimal b2= new BigDecimal("174.23");
        System.out.println(b1.subtract(b2));

        //Scaling and Rounding
        BigDecimal subtract = new BigDecimal("24.542");
        System.out.println(subtract.setScale(1, RoundingMode.CEILING));

        //Big Decimals are immutable
    }
}
