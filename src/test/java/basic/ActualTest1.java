package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ActualTest1 {

    private static WebDriver driver;

    static {
        driver = new ChromeDriver();
    }
    public static void main(String[] args) {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("#openwindow")).click();
        switchWindow("lastChild");
        System.out.println(driver.getTitle());
        driver.close();
        switchWindow("parent");
        System.out.println(driver.getTitle());
        driver.quit();
    }


    static void switchWindow(String windowType){
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iter = windows.iterator();
        if(windowType.equalsIgnoreCase("parent")){
            String parent = iter.next();
            driver.switchTo().window(parent);
        }else if(windowType.equalsIgnoreCase("lastChild")){
            String child = "";
            while (iter.hasNext()){
                child = iter.next();
            }
            driver.switchTo().window(child);
        }
    }
}
