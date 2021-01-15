package test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;

// 测试类共性提取
public class BaseTest {
    public WebDriver driver;
    // log4j日志对象
    private Logger logger = Logger.getLogger(BaseTest.class);

    /**
     * 封装打开浏览器方法
     *
     * @param browserName 浏览器名字
     * @return 驱动对象
     */
    public WebDriver openBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            // 打开Chrome浏览器
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_87.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            logger.info("打开chrome浏览器");
            // 访问网址 get方法
            // chromeDriver.get("https://www.baidu.com");
            return chromeDriver;
        } else if (browserName.equals("firefox")) {
            // 打开Firefox浏览器
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            logger.info("打开firefox浏览器");
            return firefoxDriver;
        }
        return null;

    }
}
