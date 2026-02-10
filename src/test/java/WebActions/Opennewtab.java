package WebActions;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.time.Duration;

public class Opennewtab {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testHomepageError() throws Exception {
        driver.get("https://admin.shopify.com/store/test-foxapps-staging03/apps/rc-foxify/studio?id=1757411957meCll&type=homepage");
        //ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Preview'])[1]/following::*[name()='svg'][1]")).click();
        driver.get("https://test-foxapps-staging03.myshopify.com/?view=default");
        //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
        driver.findElement(By.xpath("//form[@id='HeaderLanguageForm']/div/div/button")).click();
        driver.findElement(By.xpath("//ul[@id='HeaderLanguageList']/li[6]/a/span[2]")).click();
        driver.get("https://test-foxapps-staging03.myshopify.com/ja?view=default");
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
