package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Status_methods {
    WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void Setup(){
        driver.get("https://pebble-bunie.myshopify.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
    @Test(priority=1)
    public void testLogo() {
        WebElement logo = driver.findElement(By.cssSelector(".header__logo.flex.justify-center"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority=2)
    public void checkTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Bunnie");
    }
    @Test(priority=3,dependsOnMethods = {"checkTitle"} )
    public void checkHeadersearch(){
        WebElement searchinput= driver.findElement(By.cssSelector("#SearchInput-sections--21285671108860__header"));
        searchinput.isSelected();
    }
}
