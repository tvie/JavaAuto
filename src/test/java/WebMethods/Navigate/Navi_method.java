package WebMethods.Navigate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Navi_method {
    @Test
    public static void Nav_method () throws MalformedURLException, InterruptedException {
        WebDriver drive = new FirefoxDriver();
        URL link = new URL("https://sleek-theme-demo.myshopify.com/");

        /// Nếu truyền biến link vào method driver get thì báo lỗi ko match thư viện
        //// drive.get(link);

       /// Navigate method nhận dc biến link
       drive.navigate().to(link); /// page1
       drive.navigate().to("https://sleek-wildpeak.myshopify.com/"); /// page2
       Thread.sleep(2000);

       /// Quay lai page 1
        drive.navigate().back();
        Thread.sleep(2000);

        ///Chuyển sang  page 2
        drive.navigate().forward();
        Thread.sleep(2000);

        /// Reload lại trang
        drive.navigate().refresh();

        drive.quit();


    }
}
