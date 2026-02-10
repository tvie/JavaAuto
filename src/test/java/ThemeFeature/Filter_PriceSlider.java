package ThemeFeature;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Filter_PriceSlider {
    @Test
    public void testPriceSlider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://hyper-trove.myshopify.com/collections/meat");
        driver.manage().window().maximize(); // phóng to broswer bằng kích thước viewport
        Actions act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement min_facet_source = driver.findElement(By.xpath("//input[@id='FacetFormRangeFromPrice-vertical']"));

        //act.clickAndHold(min_facet_source).moveByOffset(20,0).release().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "const el = document.querySelector('#FacetFormRangeFromPrice-vertical');" +
                        "el.value = 4;" +
                        "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "el.dispatchEvent(new Event('change', { bubbles: true }));"
        );



        Thread.sleep(2000);
        driver.quit();

    }
}
