package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ActualTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElements(By.xpath("//label[contains(@for,'radio')]"))
                .stream().filter(x -> x.getText().trim().contains("Radio2"))
                .map(x -> x.findElement(By.xpath("./input")))
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(2))
                                .ignoring(NoSuchElementException.class);
        wait.until(webDriver -> {
            if (driver.findElement(By.xpath("//li[@class='ui-menu-item']")).isDisplayed())
                return driver.findElement(By.xpath("//li[@class='ui-menu-item']"));
            else return null;
        });
        driver.findElements(By.xpath("//li[@class='ui-menu-item']"))
                .stream().filter(x -> x.getText().equalsIgnoreCase("India"))
                .findFirst().ifPresent(WebElement::click);

        new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")))
                .getOptions().stream().filter(x -> x.getAttribute("value").equalsIgnoreCase("option3"))
                .findFirst().ifPresent(WebElement::click);

        driver.findElements(By.xpath("//div[@id='checkbox-example'] //label"))
                .stream().filter(x -> x.getText().equalsIgnoreCase("option3"))
                .map(x -> x.findElement(By.xpath("./input")))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
