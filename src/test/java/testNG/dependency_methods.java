package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class dependency_methods {
    @Test (priority=1, groups = {"sanity"})
    public void openapp(){
        Assert.assertTrue(true);
    }

    @Test(priority=2, groups = {"regression"})
    public void login(){
        Assert.assertTrue(true);
    }

    @Test(priority=3, groups = {"sanity","regression"})
    public void search(){
        Assert.assertTrue(true);
    }

    @Test(priority=4)
    public void logout(){
        Assert.assertTrue(true);
    }

}
