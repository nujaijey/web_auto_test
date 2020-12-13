package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public BasePage(){}


    public WebElement waitElementVisible(By locator){
        wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitElementClick(By locator){
        wait = new WebDriverWait(driver,10);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void sendKey(By locator,String key){
        waitElementVisible(locator).sendKeys(key);
    }

    public void clickElement(By locator){
        waitElementClick(locator).click();
    }

    /**
     * 封装打开浏览器方法
     * @param browserName 浏览器名字
     * @return 驱动对象
     */
    public static WebDriver openBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            // 打开Chrome浏览器
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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
