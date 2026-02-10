package WebMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_methods {
    @Test
    public static void main (String [] args ) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //open url
        driver.get("https://sleek-theme-demo.myshopify.com/");
        // returns url
        System.out.println(driver.getCurrentUrl());
        // returns title
        System.out.println(driver.getTitle());
        // returns source
       /// System.out.println(driver.getPageSource());
        // Check logo displayed or not
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo header__logo--desktop md:block hidden']"));
        Assert.assertTrue(logo.isDisplayed());
        // quit current browser
        Thread.sleep(3000);
        driver.close(); // driver.close() sẽ đóng tabs

    }

}

