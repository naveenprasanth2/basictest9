package practsie;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeArray {
    public static void main(String[] args) {
        String[] a = {"summa",};
        String[] b = {"test"};
       String[] c = Stream.of(a,b).flatMap(Arrays::stream).toArray(String[]::new);
        System.out.println(Arrays.toString(c));

    }
}
