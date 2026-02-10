package WebMethods.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class explicitwait {
    @Test
    public static void Test_explicitwait() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://sleek-theme-demo.myshopify.com/");
        //set explicit timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement collapsibletext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//details[contains(@class,'accordion-details')])[1]")));


        //scrolldown to element
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true)",collapsibletext);

        collapsibletext.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
