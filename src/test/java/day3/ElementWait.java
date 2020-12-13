package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementWait {
    public static void main(String[] args) throws Exception {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("haha");
        driver.findElement(By.id("su")).click();
        // 1、硬性等待  参数：毫秒数
//        Thread.sleep(3000);
        // 2、隐式等待  全局，只需要设置一次，后面的findElement/s都会有等待效果
        // 第一个参数：时间数值  第二个参数：时间单位
        // 设置全局超时时间，元素查找最多等待相应时间，超过就报异常
        // 缺点：不能判断元素是否可见/可点击
        // 元素存在在dom里就能查找，但不可见元素不能点击
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(text(),'娱乐合集!韩星')]")).click();
        // 显式等待
        // （1）实例化WebDriverWait对象（驱动等待对象）
        // 第一个参数：驱动，第二个参数：超时时间（单位默认为秒）
        WebDriverWait wait = new WebDriverWait(driver,8);
        // （2）通过调用until方法 -->直到某个条件满足为止
        // 参数：等待的条件 -->Selenium内置方法
        // visibilityOfElementLocated() -->元素可见
        // elementToBeClickable() -->元素可被点击
        // presenceOfElementLocated() -->元素在dom中存在
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'娱乐合集!韩星')]")));
        // 隐式等待和显式等待的区别
        // （1）作用域范围：隐式等待 -->全局，显式等待-->针对某一个元素生效
        // （2）条件：隐式等待 -->只能确定元素在dom中存在，显式等待 -->元素可见、元素可点击...
        // （3）报异常区别：隐式等待 -->NoSuchElementException元素找不到，显式等待 -->TimeoutException超时异常


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
