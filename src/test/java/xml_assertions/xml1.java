package xml_assertions;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class xml1 {
    @BeforeTest
    public void beforetest(){
        System.out.println("This is beforetest of xml file");
    }

    @Test
    public void Run(){
        System.out.println("This is xml 1");
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(123,23);
        System.out.println("execute after soft assert failed");

        soft.assertAll();

    }

    @BeforeSuite
    public void beforesuite(){
        System.out.println("This is before suite");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("This is after suite");
    }
}
