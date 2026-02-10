import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testsetup {
    public static void main (String[] args) {
        //System.setProperty("webdriver.chrome.driver", "/usr/local/chromedriver");
        WebDriverManager.chromedriver().setup();/// tu dong cai driver tuong ưng vs browser ///
        WebDriver driver = new ChromeDriver();
        driver.get("https://hyper-ceramide.myshopify.com/");
    }
}
