package ThemeFeature;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CompareProduct {
    @Test
    public void  CheckProductCompare () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://hyper-trove.myshopify.com/collections/bread-cake");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        WebElement switchbutton = driver.findElement(By.xpath("//span[@class='switch-slider']"));
        //System.out.println(switchbutton.getAttribute("class"));

        if (!switchbutton.isSelected()){
            switchbutton.click();
            WebElement comparebar = driver.findElement(By.cssSelector(".compare-bar.left-0.right-0.z-10.page-width.color-scheme-2"));
            comparebar.isDisplayed();
        }
        else {
            System.out.println("Conditions failed");
        }

        ///  Sủ dụng Js Executor trg thop này để click dc vào checkbox bị overlay
       // WebElement checkbox = driver.findElement(By.id("CompareCheckbox-template--19692160057573__product-grid--9177229623525"));
        List<WebElement> checkboxes = driver.findElements(By.className("js-compare-checkbox"));
        System.out.println(checkboxes.size());
        JavascriptExecutor js = (JavascriptExecutor ) driver;
        int i = 0;
        for (WebElement checkbox:checkboxes){
            i++;
            if (i<=5){
            js.executeScript("arguments[0].click();", checkbox);
            System.out.println(checkbox.getAttribute("id"));}
        }

        WebElement checkbox06 = driver.findElement(By.id("CompareCheckbox-template--19692160057573__product-grid--9177228116197"));
        js.executeScript("arguments[0].click()",checkbox06);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);

        WebElement removebtn = driver.findElement(By.xpath("(//button[@aria-label='Remove'])[5]"));
        js.executeScript("arguments[0].click()",removebtn);
        //removebtn.click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='hidden md:inline-flex compare-bar__clear btn btn--link']"))).click();
        Thread.sleep(2000);

        js.executeScript("arguments[0].focus()",switchbutton);
        switchbutton.click();

        Thread.sleep(2000);
        driver.quit();

    }
}

