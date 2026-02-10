package WebMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingSlider {

    @Test
    public static void Slider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.jqueryscript.net/demo/range-slider-synchronized-inputs/");
        WebElement min_point = driver.findElement(By.cssSelector(".slider-handle.handle-min"));
        System.out.println(min_point.getLocation());

        Actions act = new Actions (driver);
        act.dragAndDropBy(min_point,200,0).perform();
        System.out.println(min_point.getLocation());

        Thread.sleep(5000);
        driver.quit();

    }
}
