package WebMethods.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class implicitwait {
    @Test // trg class phai co @Test để chạy testng mode
    public static void Mytest () {
        WebDriver driver = new ChromeDriver();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50)); /// tgian đợi là 50s

        driver.get("https://sleek-theme-demo.myshopify.com/");
        WebElement producttab = driver.findElement(By.xpath("(//div[@class='section section-template--24914044125473__product_tabs_iJHLzK section--padding section--product-tabs page-width color-scheme-1'])[1]"));
        Assert.assertTrue(producttab.isDisplayed());

        WebElement productbundle = driver.findElement(By.cssSelector(".products-bundle.page-width.section--padding.color-scheme-1"));
        Assert.assertTrue(productbundle.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Find A Store']"));
        Assert.assertTrue(button.isEnabled());

        driver.quit();
    }
}
