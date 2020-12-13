package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementApi {
    public static void main(String[] args) throws Exception {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
        // 元素基本Api
        // click()点击事件，clear()清空内容
        // sendKeys()
        // 1、往文本框一类元素写入内容
        // 2、按钮操作
        // （1）全选 -->element.sendKeys(Keys.CONTROL,"a")
        // （2）剪切 -->element.sendKeys(Keys.CONTROL,"x")
        // （3）复制 -->element.sendKeys(Keys.CONTROL,"c")
        // （4）粘贴 -->element.sendKeys(Keys.CONTROL,"v")
        // （5）回车 -->element.sendKeys(Keys.ENTER)
        // （6）删除 -->element.sendKeys(Keys.BACK_SPACE)
        // （7）空格键 -->element.sendKeys(Keys.SPACE)
        // getTagName()获取元素的标签名
        String tagName = driver.findElement(By.id("kw")).getTagName();
        System.out.println(tagName); // input
        // getAttribute()根据属性名获取元素属性值 -->断言
        String value = driver.findElement(By.id("kw")).getAttribute("maxlength");
        System.out.println(value); // 255
        // getText()获取当前元素文本值 -->断言
        String text = driver.findElement(By.linkText("hao123")).getText();
        System.out.println(text); // hao123
        // isDisplayed()查看元素是否显示 -->断言
        Boolean isDisplayed = driver.findElement(By.linkText("hao123")).isDisplayed();
        System.out.println(isDisplayed); // true

        // WebDriver Api
        // get()访问指定url页面
        // getCurrentUrl()获取当前页面的url地址 -->断言
        System.out.println(driver.getCurrentUrl()); // https://www.baidu.com/
        // getTitle()获取当前页面的标题 -->断言
        System.out.println(driver.getTitle()); // 百度一下，你就知道
        // getPageSource()获取当前页面源代码
        // 应用场景（1）判断页面是否包含某个元素（2）判断页面是否发生了变化（页面是否滑动到底部）
//        System.out.println(driver.getPageSource());
        // quit()关闭驱动对象以及所有相关的窗口
        Thread.sleep(3000);
//        driver.quit();
        // close()关闭当前窗口--"当前"指的是selenium指向的
        // 关掉的是百度窗口，而不是hao123窗口
        // 对driver的操作都作用于get()中的窗口
        driver.findElement(By.linkText("hao123")).click();
        Thread.sleep(3000);
        driver.close();
        // NoSuchWindowException: no such window: target window already closed
        System.out.println(driver.getCurrentUrl());
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
