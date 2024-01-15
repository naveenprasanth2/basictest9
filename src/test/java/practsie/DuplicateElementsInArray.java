package practsie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class DuplicateElementsInArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 1, 2, 5, 6, 7, 8, 9, 8};
        CopyOnWriteArrayList<Integer> test = new CopyOnWriteArrayList<>(Arrays.stream(a).boxed().toList());
        Set<Integer> testSet = new HashSet<>();
        List<Integer> val = test.stream().filter(x -> !testSet.add(x)).toList();
        System.out.println(val);
    }
}
