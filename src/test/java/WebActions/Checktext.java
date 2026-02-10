package WebActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checktext {
    public static void main (String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sleek-theme-demo.myshopify.com/");
        WebElement link = driver.findElement(By.xpath("//a[@class='reversed-link'][normalize-space()='About us']"));
        String text = link.getText();
        String textcontent = link.getAttribute("textContent").trim();
        String url = link.getAttribute("href");
        if(text.equals("About us") || textcontent.equals("About us")) {
        System.out.println("Get text: "+text);
        System.out.println("Get attribute text content: "+textcontent);
        System.out.println("URL: " +url);}
        else {
            System.out.println("Khong get dc text");
            System.out.println("URL: " +url);
        }

        driver.quit();
    }

}
