package test.testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import test.common.BaseTest;

import java.io.File;

public class ScreenshotTest {
    public static void main(String[] args) throws Exception {
        // 截图测试
        BaseTest baseTest = new BaseTest();
        WebDriver driver = baseTest.openBrowser("chrome");
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        // 调用截图的API
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // 参数OutputType：截图的类型
        // FILE：截图返回值为File对象，BYTES：截图返回值为byte[]
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // byte[] srcFile = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        // 把File对象保存到本地，以后缀png/jpg结尾
        // 把原始File对象拷贝到目标File对象（本地File文件对象）中
        File targetFile = new File("C:\\Users\\nujaijey\\Desktop\\test.jpg");
        // 使用第三方依赖commons-io  --  maven导入
        FileUtils.copyFile(srcFile,targetFile);

    }
}
