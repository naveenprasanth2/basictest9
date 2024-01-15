package hasmaps;

public class SumOfAllElementsInArray {
    static int sum = 0;
    public static void main(String[] args) {
        findSumOfAllElements(new int[]{1, 2, 3, 4, 5}, 0);
        System.out.println(sum);
    }

    static void findSumOfAllElements(int[] a, int index) {
        sum+=a[index];
        if(index < a.length){
            findSumOfAllElements(a, ++index);
        }
    }
}
