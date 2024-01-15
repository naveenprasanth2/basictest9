package basic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasicTest1 {

    private static final String SCREEN_PATH = "./src/main/java/org/example/screenshots/firstShot.jpeg";
    private static final String SCREEN_PATH_1 = "./src/main/java/org/example/screenshots/secondShot.jpeg";
    private static final String REPORT_PATH = "./src/main/java/org/example/reports/report1.html";

    public static void main(String[] args) throws IOException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        ChromeOptions co = new ChromeOptions();
//        co.addArguments("--headless");
        co.addArguments("--disable-infobars");
//        co.addArguments("--screen-size=1920,1080");
        co.merge(dc);

        WebDriver driver = new ChromeDriver(co);
        driver.manage().window().fullscreen();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(REPORT_PATH);
        extentSparkReporter.config().setReportName("test report");
        extentSparkReporter.config().setDocumentTitle("Regression Report");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("reporter", "naveen");
        extentReports.setSystemInfo("environment", "QA");

        ExtentTest test = extentReports.createTest("first test");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@value='radio1']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0, 1500)");

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(webDriver -> {
            if (webDriver.findElement(By.id("courses-iframe")).isDisplayed())
                return webDriver.findElement(By.id("courses-iframe"));
            else return null;
        });

        driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Courses']")));
        driver.findElement(By.xpath("//a[text()='Courses']")).click();
        driver.switchTo().defaultContent();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(SCREEN_PATH));
        test.addScreenCaptureFromPath(SCREEN_PATH);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("mousehover"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[text()='Top']"))).click().perform();

        src = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(SCREEN_PATH_1));
        test.addScreenCaptureFromPath(SCREEN_PATH_1);
        extentReports.flush();
        driver.quit();
    }
}
