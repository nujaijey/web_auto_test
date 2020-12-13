package hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hw2 {
    public static void main(String[] args) {
        WebDriver driver = openBrowser("chrome");
        driver.get("http://120.78.128.25:8765/loan/finance.html");
        driver.findElement(By.xpath("//span[contains(text(),'自用两年奥迪A6质押借款')]/parent::div/following-sibling::div[1]//div[@class='mt-5 bold red']"));

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
