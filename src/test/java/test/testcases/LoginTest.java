package test.testcases;

import org.testng.annotations.DataProvider;
import test.pageobject.IndexPage;
import test.pageobject.LoginPage;
import test.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.utils.Constant;

public class LoginTest extends BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpTest() {
        // 前置
        // 1、打开浏览器
        driver = openBrowser(Constant.BROWSER_TYPE);
        // 2、访问登录地址
        driver.get(Constant.LOGIN_URL);
        // 3、最大化浏览器
        driver.manage().window().maximize();
    }

    // 登录成功验证
    @Test
    public void loginSuccess() throws Exception {
//        driver.findElement(By.name("phone")).sendKeys(Constant.CORRECT_PHONE);
//        driver.findElement(By.name("password")).sendKeys(Constant.CORRECT_PASSWORD);
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        // 要操作哪个页面的元素就初始化哪个页面的对象
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess(Constant.CORRECT_PHONE,Constant.CORRECT_PASSWORD);
        Thread.sleep(3000);
        // 断言
        // 1、登录之后页面title
        String actualValue = driver.getTitle();
//        String actualValue = loginPage.getLoginResult();
        String exceptedValue = "前程贷官网 - 业内领先的社群互联网金融平台";
        Assert.assertEquals(actualValue,exceptedValue);
        // 2、登录之后的用户昵称
//        WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'" + Constant.NICK_NAME +")]"));
//        Assert.assertTrue(webElement.isDisplayed());
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(indexPage.isNickNameDisplayed());
    }

    // 登录手机号为空
//    @Test
//    public  void loginFailure1() throws Exception {
//        driver.findElement(By.name("phone")).sendKeys("");
//        driver.findElement(By.name("password")).sendKeys("lemon123456");
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
//        Thread.sleep(3000);
//        // 断言
//        // 1、登录之后页面title
//        String actualValue = driver.getTitle();
//        String exceptedValue = "前程贷官网 - 欢迎登录";
//        Assert.assertEquals(actualValue,exceptedValue);
//        // 2、登录之后的登录按钮
//        WebElement webElement = driver.findElement(By.xpath("//button[contains(text(),'登录')]"));
//        Assert.assertTrue(webElement.isDisplayed());
//    }

    // 登录手机号未授权
//    @Test
//    public void loginFailure2() throws Exception {
//        driver.findElement(By.name("phone")).sendKeys("13226645549");
//        driver.findElement(By.name("password")).sendKeys("lemon123456");
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
//        // 断言
//        // 手机号未授权提示
//        // 显式等待
//        WebDriverWait wait = new WebDriverWait(driver,8);
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layui-layer-content")));
//        String actualValue = webElement.getText();
//        String exceptedValue = "此账号没有经过授权，请联系管理员!";
//        Assert.assertEquals(actualValue,exceptedValue);
//    }

    // 记住手机号验证
    @Test
    public void rememberPhone() throws Exception {
//        driver.findElement(By.name("phone")).sendKeys(Constant.CORRECT_PHONE);
//        driver.findElement(By.name("password")).sendKeys(Constant.CORRECT_PASSWORD);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilePhone(Constant.CORRECT_PHONE);
        loginPage.typePassword(Constant.CORRECT_PASSWORD);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.name("remember_me"));
        String attributeName = "checked";
        javascriptExecutor.executeScript("arguments[0].removeAttribute(arguments[1])", webElement, attributeName);
//        loginPage.removeRememberPhoneChecked();
//        Thread.sleep(2000);
//        driver.findElement(By.name("remember_me")).click();
        loginPage.clickRememberPhone();
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        loginPage.clickLogin();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[text()='退出']")).click();
        IndexPage indexPage = new IndexPage(driver);

        indexPage.clickQuit();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
        indexPage.clickLogin();
//        Thread.sleep(3000);
        // 断言
        // 手机号为13323234545
//        String actualValue = driver.findElement(By.name("phone")).getAttribute("value");
        String actualValue = loginPage.getMobilePhoneValue();
        Assert.assertEquals(actualValue,Constant.CORRECT_PHONE);
    }

    // 手机号码格式错误
    @Test(dataProvider = "getLoginFailureDatas01")
    public void loginFailure01(String phone,String password,String exceptedTips) throws Exception {
//        driver.findElement(By.name("phone")).sendKeys(phone);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilePhone(phone);
        loginPage.typePassword(password);
        loginPage.clickLogin();
//        Thread.sleep(3000);
        // 断言
        // 手机号错误提示
//        String actualValue = driver.findElement(By.className("form-error-info")).getText();
        String actualValue = loginPage.getFormInfo();
        String exceptedValue = exceptedTips;
        Assert.assertEquals(actualValue,exceptedValue);

    }

    // 测试步骤、断言方式一样，数据不一样--数据驱动DataProvider
    @DataProvider
    public Object [] [] getLoginFailureDatas01() {
        Object [] [] datas = {
                {"","lemon123456","请输入手机号"},
                {"133232345451","lemon123456","请输入正确的手机号"},
                {"1332323454","lemon123456","请输入正确的手机号"},
                {"1332323454$","lemon123456","请输入正确的手机号"}
        };
        return datas;
    }

    // 手机号码/密码错误
    @Test(dataProvider = "getLoginFailureDatas02")
    public void loginFailure02(String phone,String password,String exceptedTips) throws Exception {
//        driver.findElement(By.name("phone")).sendKeys(phone);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.xpath("//button[contains(text(),'登录')]")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilePhone(phone);
        loginPage.typePassword(password);
        loginPage.clickLogin();
//        WebDriverWait wait = new WebDriverWait(driver,8);
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("layui-layer-content")));
//        // 断言
//        // 手机号码/密码错误提示
//        String actualValue = webElement.getText();
        String actualValue = loginPage.getCenterInfo();
        String exceptedValue = exceptedTips;
        Assert.assertEquals(actualValue,exceptedValue);

    }

    @DataProvider
    public Object [] [] getLoginFailureDatas02() {
        Object [] [] datas = {
                {"13226645549","lemon123456","此账号没有经过授权，请联系管理!"},
                {"13323234545","LEMON123456","帐号或密码错误!"},
                {"13323234545","lemon1234567","帐号或密码错!"},
                {"13323234545","lemon12345","帐号或密码错误!"},
                {"13323234545","lemon 123456","帐号或密码错!"}
        };
        return datas;
    }

    @AfterMethod
    public void tearDownTest() {
        // 后置
        // 关闭浏览器，销毁driver
        driver.quit();
    }


}


