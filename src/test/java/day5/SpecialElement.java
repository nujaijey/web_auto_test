package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.ref.SoftReference;

public class SpecialElement {
    public static void main(String[] args) throws Exception {
        WebDriver driver = openBrowser("chrome");
        // 时间控件
        // 没有限制手动输入：直接调用sendKeys方法写入时间数据
//        driver.get("https://www.fliggy.com/?ttid=seo.000000574&seoType=origin");
//        driver.findElement(By.xpath("//form[@id='J_FlightForm']//input[@name='depDate']")).sendKeys("2020-11-18");
        // 有限制手动输入：执行JavaScript代码来改变元素的属性值
//        driver.get("https://www.12306.cn/index/");
//        WebElement webElement = driver.findElement(By.id("train_date"));
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // 应用场景1：设置/去除元素属性
        // 方式1：不传参
//        javascriptExecutor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");
//        Thread.sleep(2000);
//        webElement.clear();
//        Thread.sleep(2000);
//        webElement.sendKeys("2020-11-18");
        // 方式2：传参
//        String attributeName = "readonly";
//        javascriptExecutor.executeScript("arguments[0].removeAttribute(arguments[1])",webElement,attributeName);
//        Thread.sleep(2000);
//        webElement.clear();
//        Thread.sleep(2000);
//        webElement.sendKeys("2020-11-18");
        // 应用场景2：页面滚动
        // 滚动到页面最底部
//        javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // 滚动到指定元素的位置
//        WebElement webElement = driver.findElement(By.id("index_ads"));
//        javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true)",webElement);

        // 案例：懒加载
//        driver.get("https://sj.qq.com/myapp/category.htm?orgame=1&categoryId=122");
//        driver.findElement(By.xpath("//a[text()='全部软件']")).click();
//        Thread.sleep(2000);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        while (true) {
//            // 1、找到元素就break
//            if (driver.getPageSource().contains("<a href=\"detail.htm?apkName=com.ss.android.ugc.aweme\" target=\"_blank\" class=\"name ofh\">抖音</a>")) {
//                // 找到就点击元素跳出
//                driver.findElement(By.xpath("//a[text()='抖音']")).click();
//                break;
//            }
//            // 滚动前页面
//            String beforeSource = driver.getPageSource();
//            // 找不到就滚动页面
//            javascriptExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//            Thread.sleep(2000);
//            // 滚动后页面
//            String afterSource = driver.getPageSource();
//            // 2、页面不存在这个元素（滚动到页面最底部都找不到元素）
//            if (beforeSource.equals(afterSource)) {
//                System.out.println("页面不存在此元素");
//                break;
//            }

//        }

        // 文件上传
        // 1、文件上传元素是input标签，并且type为file
        // 使用sendKeys写入文件的路径
        driver.get("https://www.layui.com/demo/upload.html");
//        driver.findElement(By.id("test20")).sendKeys("C:\\Users\\nujaijey\\Desktop\\壁纸1.jpg");
        // 2、文件上传元素不是input标签
        // 使用第三方控件  AutoIT
        // （1）AutoIt Window Info获取元素Class&Instance
        // （2）SciTE Script Editor编写脚本，Class&Instance构成定位表达式
        /*
        ;等待“打开”窗口
        WinWaitActive("打开")
        ;休眠2秒
        Sleep(2000)
        ;在输入框中写入上传文件的路径
        ControlSetText("打开", "", "Edit1", "C:\Users\nujaijey\Desktop\壁纸1.jpg")
        ;休眠2秒
        Sleep(2000)
        ;点击打开按钮
        ControlClick("打开", "","Button1");
         */
        // 选择工具栏上面的Tools-Go运行脚本，OK即可保存
        // （3）Compile Script to .exe把脚本编译为exe文件
        driver.findElement(By.id("test1")).click();
        Thread.sleep(2000);
        // 执行exe文件--通过Runtime对象去执行
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("src/test/resources/autoit.exe");

        // 验证码处理方法
        // （1）去除验证码--测试环境
        // （2）自动识别--技术，图像识别技术OCR（准确率高）不推荐
        // （3）万能验证码--服务端开一个后门 推荐
        // 前程贷：hapi

    }

    /**
     * 封装打开浏览器方法
     *
     * @param browserName 浏览器名字
     * @return 驱动对象
     */
    public static WebDriver openBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            // 打开Chrome浏览器
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            // 访问网址 get方法
            // chromeDriver.get("https://www.baidu.com");
            return chromeDriver;
        } else if (browserName.equals("firefox")) {
            // 打开Firefox浏览器
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        }
        return null;

    }
}
