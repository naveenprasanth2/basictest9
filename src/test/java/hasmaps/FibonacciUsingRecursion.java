package hasmaps;

import com.beust.ah.A;

import java.util.ArrayList;

public class FibonacciUsingRecursion {
    static ArrayList<Integer> fibonacciList;
    static int count = 0;

    static {
        fibonacciList = new ArrayList<>();
    }

    public static void main(String[] args) {
        fibonacciGenerator(10);
        System.out.println(fibonacciList);
    }

    static void fibonacciGenerator(int number) {
        if (count == 0 || count == 1) {
            fibonacciList.add(count);
        } else {
            int resultantValue = fibonacciList.get(fibonacciList.size() - 1) + fibonacciList.get(fibonacciList.size() - 2);
            fibonacciList.add(resultantValue);
        }
        if (count <= number) {
            count++;
            fibonacciGenerator(number);
        }
    }
}
