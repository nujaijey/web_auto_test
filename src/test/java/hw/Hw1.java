package hw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hw1 {
    public static void main(String[] args) {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://voice.baidu.com/act/newpneumonia/newpneumonia/");
        // 元素1
//        driver.findElement(By.xpath("//a[text()='百度首页']")).click();
        // 元素2
//        driver.findElement(By.xpath("//span[text()='切换地区']")).click();
        // 元素3
        driver.findElement(By.xpath("//div[contains(@class,'VirusSummarySix_1-1-285_3wCKWi')]"));
        // 元素5
        driver.findElement(By.xpath("//input[@id='tab-toggle']/following-sibling::label")).click();

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
