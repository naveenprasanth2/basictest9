package hasmaps;

import java.util.HashMap;

public class FindOutExtraKey {
    public static void main(String[] args) {
        HashMap<String, String> test = new HashMap<>();
        test.put("a", "naveen");
        test.put("b", "prasanth");

        HashMap<String, String> test1 = new HashMap<>();
        test1.put("a", "naveen");
        test1.put("b", "prasanth");
        test1.put("c", "test");

        HashMap<String, String> combinedMap = new HashMap<>(test1);
        combinedMap.putAll(test);

        HashMap<String, String> smallestMap = test1.size() < test.size() ? test1 : test;

        smallestMap.forEach((key, value) -> combinedMap.remove(key));
        System.out.println(combinedMap);
    }
}
