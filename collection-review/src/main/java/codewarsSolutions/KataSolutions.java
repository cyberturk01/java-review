package codewarsSolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KataSolutions {
    public static void main(String[] args) {
        System.out.println(abbrevName("Sam Harris"));
        System.out.println("digit: " + digitize(35231));
        System.out.println("getSum: " + getSum(0, -1));
        System.out.println("removeEveryOther: " + Arrays.toString(removeEveryOther(new Object[]{"Hello", "Goodbye", "Hello Again"})));
        System.out.println(Arrays.toString(countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15})));
        System.out.println(Arrays.toString(getMinMax(Arrays.asList(4, 2, 5, 6, 7))));
    }
    public static int[] getMinMax(List<Integer> list) {
        int[] result = new int[2];
        int min = list.get(0);
        if (list.size() == 1) {
            result[0] = min;
        } else {
            int max = list.get(1);
            if (min < max) {
                result[0] = min;
                result[1] = max;
            } else {
                result[0] = max;
                result[1] = min;
            }
        }
        return result;
    }
    public static int[] countPositivesSumNegatives(int[] input) {
        List<Integer> list = new ArrayList<>();
        if (input != null && input.length!=0 ){
            for (int i : input) {
                list.add(i);
            }
            int sum1 = (int) list.stream().filter(num -> num > 0).count();
            int sum2 = list.stream().filter(num -> num < 0).mapToInt(Integer::intValue).sum();
            return new int[]{sum1, sum2}; //return an array with count of positives and sum of negatives
        }else{
             return new int[]{};
        }
    }

    public static Object[] removeEveryOther(Object[] arr) {
        // happy coding
        List<Object> lo = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                lo.add(arr[i]);
            }
        }
        return lo.toArray();
    }

    public static int getSum(int a, int b) {
        if (a == b) {
            return a;
        } else {
            int num = 0;
            if (a < b) {
                for (int i = a; i <= b; i++) {
                    num += i;
                }
            } else {
                for (int i = b; i <= a; i++) {
                    num += i;
                }
            }
            return num;
        }
    }

    public static String abbrevName(String name) {
        return Arrays.stream(name.split(" "))
                .map(String::toUpperCase)
                .map(word -> word.substring(0, 1))
                .collect(Collectors.joining("."));
    }

    public static int[] digitize(long n) {
        String name = String.valueOf(n);

        Integer[] convert = new Integer[name.length()];
        String[] split = name.split("");

        for (int i = 0; i < name.length(); i++) {
            convert[i] = Integer.parseInt(split[i]);
        }
        List<Integer> reverse = reverse(convert);

        int[] converted = new int[name.length()];

        for (int i = 0; i < name.length(); i++) {
            converted[i] = reverse.get(i);
        }
        return converted;
    }

    static List<Integer> reverse(Integer[] myArray) {
        List<Integer> list = Arrays.asList(myArray);
        Collections.reverse(list);
        System.out.println("Reversed Array:" + Arrays.asList(myArray));
        return list;
    }
}
