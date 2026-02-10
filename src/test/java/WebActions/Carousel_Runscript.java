package WebActions;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;
public class Carousel_Runscript {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testCarouselCopy() throws Exception {
        driver.get("https://hyper-ceramide.myshopify.com/");
        js.executeScript("document.querySelector(\"favorite-products[class='favorite-products favorite-products--layout-content-left favorite-products--height-adapt block md:flex flex-nowrap overflow-hidden']\").scrollIntoView(true)");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='swiper-controls swiper-controls--grouped swiper-controls--pagination-fraction']//button[@name='next']")).click();
        Thread.sleep(1000);
        try {
            assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Jenny Thompson']")).getText(), "Jenny Thompson");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//div[@class='swiper-controls swiper-controls--grouped swiper-controls--pagination-fraction']//button[@name='previous']")).click();
        Thread.sleep(1000);
        try {
            assertEquals(driver.findElement(By.xpath("//h3[normalize-space()='Jenny Wilson']")).getText(), "Jenny Wilson");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
