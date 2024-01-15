package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class LinkStream {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> allLinkElements = driver.findElements(By.xpath("//li //a"));

        allLinkElements.parallelStream().map(x -> x.getAttribute("href")).map(x -> {
            try {
                return new URL(x);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }).forEach(x -> {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) x.openConnection();
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();
                System.out.println(httpURLConnection.getResponseCode() + ((httpURLConnection.getResponseCode() > 400) ? " Link is not working" : " Link is working"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        driver.quit();
    }
}
