package WebMethods.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scrolldown_Focus {
    @Test
    public void Combineactions () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hyper-trove.myshopify.com/");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement productlist = driver.findElement(By.cssSelector("div[class='section section-template--19692160418021__horizontal_products_list_yFekJa horizontal-products-list section--padding color-scheme-1'] div[class='section__container page-width page-width--fixed']"));
        js.executeScript("arguments[0].scrollIntoView(true)",productlist);
        Thread.sleep(2000);

        WebElement layeredimgwithtext = driver.findElement(By.cssSelector(".product-card__list-actions a[href='/products/soft-and-chewy-pretzel-twists']"));
        js.executeScript("arguments[0].focus()",layeredimgwithtext);
        Thread.sleep(2000);
        driver.quit();
    }
}
