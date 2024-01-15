package hasmaps;

import java.util.ArrayList;
import java.util.List;

public class PrintFibonacciUsingRecursion {
    static List<Integer> test;
    public static void main(String[] args) {
        printFibonacciSeries(0, 1, 20);
        System.out.println(test);
    }

   static void printFibonacciSeries(int previous, int next, int size) {

        if(test == null){
            test = new ArrayList<>();
            test.add(previous);
            test.add(next);
        }

            previous = previous + test.get(test.size() - 1);
            test.add(previous);

        if(test.size() != size){
            printFibonacciSeries(previous, next, size);
        }
    }
}
