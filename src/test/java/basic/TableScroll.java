package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableScroll {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        driver.findElements(By.xpath("((//div[@class='tableFixHead']) //tbody //tr //td[1])"))
                .stream().filter(x -> x.getText().equalsIgnoreCase("Jack"))
                .map(x -> x.findElement(By.xpath("./following-sibling::td[3]")))
                .findFirst().ifPresent(x -> System.out.println(x.getText()));
    }
}
