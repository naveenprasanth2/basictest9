package practsie;

import java.util.stream.Stream;

public class Validation {
    public static void main(String ...args) {
        int a = 153;
        long val = Stream.of(String.valueOf(a).split("")).mapToInt(Integer::valueOf).map(x -> x*x*x).sum();
        System.out.println(a==val);
    }
}
