package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {
    @Override
    public void onStart(ITestContext context){
        System.out.println("Test suite bắt đầu");
    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Test bắt đâù: "+result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test thành công");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test thất bại: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test bị skip");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test thất bại nhưng có thể chấp nhận");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite kết thúc");
    }

}
