package WebMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Mouseactions {
    // Ở vị trí này chỉ đc khai báo biến và method, không thể thực thi lệnh
    WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @BeforeClass // thực thi các lệnh này trc tất cả cá method @Test phía sau
    public void Setup() throws InterruptedException { // method dùng chung cho các method khác
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.get("https://hyper-trove.myshopify.com/");
        Thread.sleep(1000);
    }

   @Test (priority=50) // đánh dấu một test case mà TestNG sẽ chạy
    public void Hover () throws InterruptedException {

        // Hover button
        WebElement hoverbtn = driver.findElement(By.xpath("//span[normalize-space()='View 20+ Categories']"));
        new Actions(driver).moveToElement(hoverbtn).perform();
        Thread.sleep(1000);
        //driver.quit();
    }
    @Test(priority=100)
    public void Carousel() throws InterruptedException {
        WebElement pdcard = driver.findElement(By.xpath("//span[normalize-space()='Energy Drink, Ultra Sunrise, 16 Fl oz']"));

        js.executeScript("arguments[0].scrollIntoView(true)", pdcard);
        Thread.sleep(2000);
       /* Actions movemouse = new Actions(driver).moveToElement(pdcard, 10, 2);
        movemouse.perform(); */

        new Actions(driver).clickAndHold().moveByOffset(200,0).release().perform(); // dịch tiếp 20px từ vị trí hiện tại
        Thread.sleep(2000);
    /*  new Actions(driver).dragAndDropBy(pdcard,-300,0).perform();
      Thread.sleep(2000); */

    }

    @AfterClass
    public void Closewindow(){
        driver.quit();
    }
}
