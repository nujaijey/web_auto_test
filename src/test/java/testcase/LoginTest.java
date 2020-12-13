package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpTest() {
        // 前置
        // 1、打开浏览器
        driver = openBrowser("chrome");
        // 2、访问登录地址
        driver.get("http://120.78.128.25:8765/Index/login.html");
        // 3、最大化浏览器
        driver.manage().window().maximize();
    }

    // 登录成功验证
    @Test
    public void LoginSuccess() throws Exception {
        /*driver.findElement(By.name("phone")).sendKeys("13323234545");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();*/

        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.loginPage();
        loginPage.loginSuccess("13323234545","lemon123456");

        Thread.sleep(3000);
        // 断言
        // 1、登录之后页面title
//        String actualValue = driver.getTitle();
        String actualValue = loginPage.getLoginResult();
        String exceptedValue = "前程贷官网 - 业内领先的社群互联网金融平台";
        Assert.assertEquals(actualValue,exceptedValue);
        // 2、登录之后的用户昵称
        WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'自动化测试帐号1')]"));
        Assert.assertTrue(webElement.isDisplayed());
    }

    // 登录手机号为空
    @Test
    public  void LoginFailure1() throws Exception {
        driver.findElement(By.name("phone")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        Thread.sleep(3000);
        // 断言
        // 1、登录之后页面title
        String actualValue = driver.getTitle();
        String exceptedValue = "前程贷官网 - 欢迎登录";
        Assert.assertEquals(actualValue,exceptedValue);
        // 2、登录之后的登录按钮
        WebElement webElement = driver.findElement(By.xpath("//button[contains(text(),'登录')]"));
        Assert.assertTrue(webElement.isDisplayed());
    }

    // 登录手机号未授权
    @Test
    public void LoginFailure2() throws Exception {
        driver.findElement(By.name("phone")).sendKeys("13226645549");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        // 断言
        // 手机号未授权提示
        // 显式等待
        WebDriverWait wait = new WebDriverWait(driver,8);
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layui-layer-content")));
        String actualValue = webElement.getText();
        String exceptedValue = "此账号没有经过授权，请联系管理员!";
        Assert.assertEquals(actualValue,exceptedValue);
    }

    // 记住手机号验证
    @Test
    public void RememberPhone() throws Exception {
        driver.findElement(By.name("phone")).sendKeys("13323234545");
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.name("remember_me"));
        String attributeName = "checked";
        javascriptExecutor.executeScript("arguments[0].removeAttribute(arguments[1])", webElement, attributeName);
        Thread.sleep(2000);
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='退出']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
        Thread.sleep(3000);
        // 断言
        // 手机号为13323234545
        String actualValue = driver.findElement(By.name("phone")).getAttribute("value");
        Assert.assertEquals(actualValue,"13323234545");
    }

    @AfterMethod
    public void tearDownTest() {
        // 后置
        // 关闭浏览器，销毁driver
        driver.quit();
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


