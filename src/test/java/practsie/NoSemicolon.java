package practsie;

public class NoSemicolon {
    public static void main(String[] args) {
        int number = 100;
        int min = 1;
        printNumber(number, min);
    }

   static void printNumber(int max, int min){
        int yetToPrint = max;
        if(yetToPrint >= min){
            System.out.println(yetToPrint);
            yetToPrint--;
            printNumber(yetToPrint, min);
        }
    }
}
