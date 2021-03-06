package test.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import test.common.BaseTest;

/**
 *  AllureListener：监听用例的异常，用例失败截图
 *  IHookable：实现这个接口，当前的run方法将会替换掉测试类里面的@Test注解标注的测试方法
 *  测试用例失败截图，把截图嵌入到Allure报表中
 *  （1）实现IHookable监听器，重写run方法，监听用例的异常并截图
 *  （2）通过Allure Attachement注解来实现附件的嵌入
 */

public class AllureListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        // If a test class implements this interface, its run() method will be invoked instead of each @Test method found
        // 翻译的意思：一个类有去实现implements这个接口的话，那么当前的run方法将会替换掉测试类里面的@Test注解标注的测试方法
        // 想要得到测试的结果信息
        // 1、保证@Test注解标注的测试方法能够正常运行
        iHookCallBack.runTestMethod(iTestResult);
        // 2、判断用例结果是否正常
        if (iTestResult.getThrowable() != null) {
            // iTestResult参数提供了API getInstance 获取当前测试类的实例（对象）
            BaseTest baseTest = (BaseTest) iTestResult.getInstance();
            // 根据baseTest得到driver
            WebDriver driver = baseTest.driver;
            // 截图并把截图嵌入到Allure报表中
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            // 参数OutputType：截图的类型
            byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenShot);
        }

    }

    // @Attachment 附件
    // value参数是为你的附件的名字 type参数是为你的附件类型
    @Attachment(value = "Java screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
