package basic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Log4j2
public class BasicTest {
    private static final String screenPath = "./src/main/java/org/example/screenshots/test.png";
    private static final String reportPath = "./src/main/java/org/example/reports/test.html";

    public static void main(String[] args) throws IOException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        co.addArguments("--screen-size=1920,1080");
        co.addArguments("--disable-infobars");
        co.merge(dc);
        log.info("capabilities added successfully");
        WebDriver driver = new ChromeDriver(co);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setDocumentTitle("Test Report Document");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("tester", "naveen");
        extentReports.setSystemInfo("environment", "QA");

        ExtentTest extentTest = extentReports.createTest("Smoke run");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 1000)");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='courses-iframe']")));

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        wait.until(driver1 -> {
            if(driver.findElement(By.xpath("//a[text()='Courses']")).isDisplayed()){
                return driver.findElement(By.xpath("//a[text()='Courses']"));
            }else{
                return null;
            }
        });
        driver.findElement(By.xpath("//a[text()='Courses']")).click();

        driver.switchTo().defaultContent();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).perform();

        TakesScreenshot sc = (TakesScreenshot) driver;
        File src = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenPath));
        extentTest.addScreenCaptureFromPath(screenPath);
        extentReports.flush();


    }


}
