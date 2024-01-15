package hasmaps;

import static java.lang.StringTemplate.RAW;

public class VirtualThreads {
    static String summa = "ytest";
    public static void main(String[] args) throws InterruptedException {
        StringTemplate str = RAW."\{summa}";
        System.out.println(STR.process(str));
    }
}
