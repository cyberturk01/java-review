package tasks.trader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class TraderTask {
    public static void main(String[] args) {
        List<Transaction> transactions = TradeData.getAll();

        //1. Find all transactions in the year 2011 and sort them by value(small to high)
        transactions.stream()
                .filter(s -> s.getYear() == 2011)
                .sorted(comparing(Transaction::getYear))
                .forEach(s -> System.out.println("s = " + s));

        //2. What are all the unique cities where the traders work?
        transactions.stream()
                .map(cities -> cities.getTrader().getCity())
                .distinct()
                .forEach(s -> System.out.println("s = " + s));

        //3. Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName).reversed())
                .forEach(System.out::println);

        //4. Return a string of all traders’ names sorted alphabetically.
        String traders = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo)
                .reduce("", (n1,n2)->n1+" "+n2);
//                .collect(Collectors.joining(", "));
        System.out.println("string = " + traders);

        //5. Are any traders based in Milan?
        boolean isThereMilan = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals("Milan"));
        System.out.println("isThereMilan = " + isThereMilan);

        //6. Print the values of all transactions from the traders living in Cambridge.!!!
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7. What is the highest value of all the transactions?
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("highestValue = " + highestValue.get());

        //8. Find the transaction with the smallest value.
        Optional<Integer> smallestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("smallestValue = " + smallestValue.get());

        Optional<Transaction> smallestValue2 = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println("smallestValue2 = " + smallestValue2.get());

        //First 10 elements of the series of Fibonacci tuples using iterate method.
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));

        //Print the Fibonacci series in normal way.
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        Stream.iterate(0, n->n+2)
                .limit(10)
                .forEach(s-> System.out.println("s = " + s));
    }
}
