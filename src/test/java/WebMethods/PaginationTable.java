package WebMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PaginationTable {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    @BeforeClass
    public void Setup(){
        driver.get("https://www.jqueryscript.net/demo/Minimal-jQuery-Table-Pagination-Plugin-SimplePagination/");
    }

    @Test
    public void HandlingTable() throws InterruptedException {
        // Lẩy ra Text hiện số row - số pagi của table
        String text = driver.findElement(By.cssSelector("div[class='container'] div span")).getText();
        System.out.println(text);

        // Lấy ra total page của table - lưu ý vì số page có thể thay dổi nên khi xác định sẽ dùng index
        // tương đối dựa vào ký tự trc/sau total page thay vì tuyệt đối
        System.out.println(text.substring(text.indexOf("f")+2, text.indexOf("e")-1));

        // Lấy ra max row của table
        System.out.println(text.substring(text.indexOf("o")+2, text.indexOf("of")-1));

        // Chuyển từ string sang int
        int totalrow = Integer.parseInt(text.substring(text.indexOf("f")+2, text.indexOf("e")-1));
        int maxrow = Integer.parseInt(text.substring(text.indexOf("o")+2, text.indexOf("of")-1));

        // Switch sang page khác của table - nút Next
        while (maxrow < totalrow) {
            WebElement nextbtn = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
            nextbtn.click();
            Thread.sleep(2000);
            text = driver.findElement(By.cssSelector("div[class='container'] div span")).getText();
            System.out.println(text.substring(text.indexOf("o")+2, text.indexOf("of")-1));
            maxrow = Integer.parseInt(text.substring(text.indexOf("o")+2, text.indexOf("of")-1));
        }
        // Do index của row dc xác định gíán tiếp nên phải liên tiếp update giá trị ban đầu trg vòng while


        WebElement trow;
        // In ra data trong 2 row đầu tiên của table
        for(int i =1; i <= 2; i++){
            for(int j=1;j<=6;j++) {
                trow = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td["+ j +"]"));
                System.out.print(trow.getAttribute("textContent")+" | ");
            }
            System.out.println();

            /// Với table không nên dùng getText mà nên dùng getAttribute(textContent)
        }

    }

    @AfterClass
    public void Exit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
