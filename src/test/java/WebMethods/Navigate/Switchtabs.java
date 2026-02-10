package WebMethods.Navigate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Switchtabs {
    @Test
    public void GetWindowIdsandSwitchtabs () throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://sleek-wildpeak.myshopify.com/products/classic-sunglasses");
        String parent = driver.getWindowHandle(); // lấy id của tab hiện tại

        //set explicit timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement hyperlink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Astrid Wild']")));
        //hyperlink.click();

        String urlToOpen = hyperlink.getAttribute("href");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", urlToOpen);


        // Chờ để tránh chưa get dc list windowid (tabid)
        wait.until(d-> d.getWindowHandles().size() > 1);
        System.out.println(driver.getWindowHandles().size());
        System.out.println(driver.getTitle());

        //switch giữa các tab
        Set<String> windowids = driver.getWindowHandles();
        for(String id : windowids) {
            if(!id.equals(parent)){
                driver.switchTo().window(id);
            }
        }


        ///  Check lại băng cách get title tab sau switch
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.quit();
    }
}
