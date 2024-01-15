package basic;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DataProviderTest {

    @Test(dataProvider = "data3")
    public void test(HashMap<String, String> test){
        System.out.println(test.get("firstName"));
        System.out.println(test.get("lastName"));
        System.out.println(test.get("phone"));
        System.out.println(test.get("mobile"));
    }


    @DataProvider(name = "data1")
    public Object[][] data1(){
        HashMap<String, String> test = new HashMap<>();
        test.put("firstName", "naveen");
        test.put("lastName", "prasanth");
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

    @DataProvider(name = "data2")
    public Object[][] data2(){
        HashMap<String, String> test = new HashMap<>();
        test.put("phone", "00000");
        test.put("mobile", "9999");
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

    @SuppressWarnings("unchecked")
    @DataProvider(name = "data3")
    public Object[][] data3(){
        HashMap<String, String> test = new HashMap<>();
        test.putAll((HashMap<String, String>)data1()[0][0]);
        test.putAll((HashMap<String, String>) data2()[0][0]);
        Object[][] o = new Object[1][];
        o[0] = new Object[] {test};
        return o;
    }

}
