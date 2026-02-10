package xml_assertions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class xml2 {
    @Test
    public void Run(){
        System.out.println("This is xml 2");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("This is aftertest of xml file");
    }
}
