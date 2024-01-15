package practsie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSequence {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 9, 6, 'a', 7, 8, 4, -5, -7, -3, -2, -1};
        List<String> test = Arrays.stream(a).boxed().map(String::valueOf).toList();
        List<List<String>> finalResult = new ArrayList<>();
        for (int i = 0; i < test.size() - 1; i++) {
            int initialDifference = 0;
            int valueOfJ = 0;
            try {
                initialDifference = Integer.parseInt(test.get(i)) - Integer.parseInt(test.get(i + 1));
            } catch (NumberFormatException exception) {
                System.out.println("please enter a valid number");
            }
            for (int j = i + 1; j < test.size() - 1; j++) {
                int concurrentDifference = 0;
                valueOfJ = j;
                try {
                    concurrentDifference = Integer.parseInt(test.get(j)) - Integer.parseInt(test.get(j + 1));
                } catch (NumberFormatException exception) {
                    System.out.println("please enter a valid number");
                }
                if (initialDifference != concurrentDifference && initialDifference != 1) {
                    break;
                }
            }
            if (valueOfJ != 0) {
                if (test.subList(i, valueOfJ + 1).size() > 2) {
                    finalResult.add(test.subList(i, valueOfJ + 1));
                }
                i = valueOfJ;
            }
        }

        System.out.println(finalResult);
    }
}
