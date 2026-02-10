package DataProviders;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class login {
    //WebDriver driver ;
    // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    WebDriver localDriver;

    @BeforeClass
    @Parameters("browser")
    public void setup (String browser){
       switch(browser.toLowerCase()){
           case "firefox":
               localDriver = new FirefoxDriver();
               break;
           case "chrome":
               localDriver = new ChromeDriver();
               break;
           case "safari":
               localDriver = new SafariDriver();
               break;
           default:
               throw new IllegalArgumentException("Browser not supported: " + browser);
       }
        //driver.get("https://practicetestautomation.com/practice-test-login/");
       // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.set(localDriver);
        wait.set(new WebDriverWait(localDriver, Duration.ofSeconds(10)));

    }

    public enum LoginResult {
        SUCCESS,
        INVALID_USERNAME,
        INVALID_PASSWORD,
    }

    @DataProvider(name="LoginData", indices = {0,1})
    Object [][] loginData(){
        return new Object [][] {
                {"student","Password123",LoginResult.SUCCESS},
                {"incorrectUser","Password123",LoginResult.INVALID_USERNAME},
                {"student","incorrectPassword",LoginResult.INVALID_PASSWORD}
        };
    }

  //  By successmsg = By.xpath("//h1[normalize-space()='Logged In Successfully']");
  // By logoutbtn = By.xpath("//a[normalize-space()='Log out']");

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public boolean waitForVisible(By locator){
        try {
            getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch (TimeoutException e) {
            return false;
        }
    }

    public void safeClick(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver())
                    .executeScript("arguments[0].click();", element);
        }
    }


    public LoginResult loginflow(String username, String password)
    {
        getDriver().get("https://practicetestautomation.com/practice-test-login/");
        By successmsg = By.xpath("//h1[normalize-space()='Logged In Successfully']");
        By logoutbtn = By.xpath("//a[normalize-space()='Log out']");

        WebElement usernametxt = getWait().until(ExpectedConditions.elementToBeClickable(By.id("username")));
        usernametxt.sendKeys(username);

        WebElement passwordtxt = getWait().until(ExpectedConditions.elementToBeClickable(By.id("password")));
        passwordtxt.sendKeys(password);

        if (getDriver() instanceof SafariDriver){
            safeClick(By.cssSelector("#submit"));
        }
        else{
        getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit"))).click(); }

        if(waitForVisible(successmsg) && waitForVisible(logoutbtn)){
            // getDriver().navigate().back();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.history.back();");
            return LoginResult.SUCCESS;
        }
        else {
            WebElement  errormsg = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='error']")));
            if(errormsg.getAttribute("textContent").equals("Your username is invalid!")) {
                return LoginResult.INVALID_USERNAME;
            }
            else{
                return LoginResult.INVALID_PASSWORD;
            }
        }
    }

    @Test(dataProvider = "LoginData")
    public void testLogin(String username, String password, LoginResult expected) {
        LoginResult actual = loginflow(username, password);
        Assert.assertEquals(actual, expected);
    }


    @AfterClass
    public void Close(){
        getDriver().quit();
    }

}
