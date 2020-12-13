package day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SpecialElement {
    public static void main(String[] args) throws Exception {
        WebDriver driver = openBrowser("chrome");
//        driver.get("https://www.baidu.com");
        // 下拉框
        // 非Select元素下拉框  --> 触发下拉框显式，等待元素出现
//        WebElement selElement = driver.findElement(By.xpath("//span[text()='设置']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(selElement).perform();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[text()='高级搜索']")).click();
        // Select元素下拉框  --> 将web元素封装成Select对象
        // Select select = new Select(WebElement);
        // getOptions()获取所有选项，selectByIndex(index)根据索引选中对应的选项
        // selectByValue(value)选择指定value值对应的选项，selectByVisibleText(text)选择文本值对应的选项
//        driver.get("file:///D:/nujaijey/HBProjects/HTML&CSS/%E8%A1%A8%E5%8D%95%E6%A1%88%E4%BE%8B/%E8%A1%A8%E5%8D%95%E6%A1%88%E4%BE%8B.html");
//        // 找到所在地区下拉框
//        WebElement webElement = driver.findElement(By.id("area"));
//        // 创建Select对象，对下拉框进行封装
//        Select select = new Select(webElement);
//        // 选项索引为0（索引从0开始）
//        select.selectByIndex(0);
//        Thread.sleep(2000);
//        // select.selectByValue(value);
//        // 选项文本值为深圳
//        select.selectByVisibleText("深圳");

//        driver.get("https://ke.qq.com");
//        // 切换iframe
//        // （1）iframe的索引，在页面中的位置 --> switchTo.frame(index)
//        // （2）iframe的name或id --> switchTo.frame(name/id)
//        // （3）iframe WebElement --> switchTo.frame(WebElement)
//        // 点击登录
//        driver.findElement(By.id("js_login")).click();
//        Thread.sleep(2000);
//        // 点击QQ登录
//        driver.findElement(By.xpath("//a[text()='QQ登录']")).click();
//        Thread.sleep(2000);
//        // 找到iframe元素
//        WebElement  webElement = driver.findElement(By.xpath("//iframe[@name='login_frame_qq']"));
//        // 切换iframe
//        driver.switchTo().frame(webElement);
//        // 点击帐号密码登录
//        driver.findElement(By.xpath("//a[text()='帐号密码登录']")).click();
//        Thread.sleep(2000);
//        // 跳转到父级iframe，如果是顶级iframe，不会有任何变化
//        // driver.switchTo().parentFrame() --> 作用于多层iframe嵌套
//        // 回到默认内容页面
//        // driver.switchTo().defaultContent()
//        // 点击关闭按钮
//        driver.switchTo().parentFrame();
//        driver.findElement(By.xpath("//a[@title='关闭']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("js_login")).click();

//        driver.get("https://www.baidu.com");
//        // 切换window
//        // 切换方式：传入要操作的handle句柄（窗口的身份标识，同一个浏览器内句柄不会重复）
//        // driver.switchTo().window(name/handle)
//        // 获得句柄的方法
//        driver.findElement(By.linkText("hao123")).click();
//        // （1）getWindowHandle()获取当前操作窗口的句柄
//        System.out.println(driver.getWindowHandle());
//        // （2）getWindowHandles()获取测试时打开的所有窗口的句柄
//        System.out.println(driver.getWindowHandles());
//        // 如何切换到第二个窗口  解决方法：循环
//        Set<String> handles = driver.getWindowHandles();
//        for (String handle : handles) {
//            // 根据driver获取到的信息，比如title
//            if (driver.getTitle().equals("hao123_上网从这里开始")) {
//                // 切换的窗口符合就跳出循环
//                break;
//            } else {
//                // 不符合就继续切换窗口
//                driver.switchTo().window(handle);
//            }
//        }
//        System.out.println(driver.getWindowHandle());
//        driver.findElement(By.linkText("hao123新闻")).click();
//        Thread.sleep(3000);
//        driver.quit();

        // 切换alert
        // 得到alert  Alert alert = driver.switchTo().alert()
        // 常用api  getText()获取提示信息，accept()点击确认按钮，dismiss()点击取消按钮
//        driver.get("file:///D:/nujaijey/HBProjects/java18/%E5%89%8D%E7%AB%AF%E5%9F%BA%E7%A1%80/test2.html");
//        driver.findElement(By.id("username")).sendKeys("123");
//        driver.findElement(By.id("password")).sendKeys("456");
//        driver.findElement(By.id("login")).click();
//        // 创建Alert对象
//        Alert alert = driver.switchTo().alert();
//        // getText()获取提示信息
//        System.out.println(alert.getText());
//        Thread.sleep(3000);
//        // accept()点击确认按钮
//        alert.accept();

        // 鼠标操作 Selenium的Actions类
        // actions.clickAndHold(targetElement)单击鼠标左键并且不释放
        // actions.release(targetElement)释放鼠标左键
        // actions.doubleClick(targetElement)双击鼠标左键
        // actions.moveToElement(targetElement)移动指针到目标元素
        // actions.contextClick(targetElement)单击右键
        // actions.dragAndDrop(sourceElement,targetElement)拖拽元素
        // actions.perform()执行具体的操作，调用perform()才会真正的执行
//        driver.get("https://www.baidu.com");
        Actions actions = new Actions(driver);
//        WebElement setButton = driver.findElement(By.id("s-usersetting-top"));
//        actions.moveToElement(setButton).perform();
//        Thread.sleep(3000);
        driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement sourceElement = driver.findElement(By.id("treeDemo_2_span"));
        WebElement targetElement = driver.findElement(By.id("treeDemo_3_span"));
        actions.dragAndDrop(sourceElement,targetElement).release().perform();

        // NoSuchElementException有如下原因
        // 1、元素没有加载出来--等待
        // 2、元素在iframe里面--切换iframe
        // 3、元素在新的window里面--切换window

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
