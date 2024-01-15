package practsie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 1, 2, 5, 6, 7, 8, 9, 8};
        List<Integer> test = Arrays.stream(a).boxed().toList();

       Set<Integer> finalSet =  test.stream().filter(x -> Collections.frequency(test, x) >= 2).collect(Collectors.toSet());
        System.out.println(finalSet);
    }
}
