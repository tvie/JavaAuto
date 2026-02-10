package WebMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyUpDown {
    @Test
    public static void CopyPaste() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://text-compare.com/");
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Viết text chp 1 input
        WebElement input1 = driver.findElement(By.id("inputText1"));
        input1.sendKeys("thaovy");

        // Khai báo biến key cmd-ctrl - nếu là mac key = cmd, nếu là window key - ctrl
        Keys cmdctrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        ///  Cmd A - Chọn toàn bộ text
        js.executeScript("arguments[0].focus()",input1);
        act.keyDown(cmdctrl).sendKeys("a").keyUp(cmdctrl).perform();

        ///  Cmd C - Copy text vào clipboard
        act.keyDown(cmdctrl).sendKeys("c").keyUp(cmdctrl).perform();

        ///  Cmd V - Paste vào input khác
        WebElement input = driver.findElement(By.id("inputText2"));

        js.executeScript("arguments[0].focus()",input);
        act.keyDown(cmdctrl).sendKeys("v").keyUp(cmdctrl).perform(); 

        Thread.sleep(4000);
        driver.quit();

    }
}
