package test.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.common.BaseTest;
import test.pageobject.BackStageLoginPage;
import test.pageobject.BackStageMainPage;
import test.pageobject.BasePage;
import test.pageobject.LoginPage;
import test.utils.Constant;

public class InvestTest extends BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
    // 前置
    // 1、打开浏览器
    /*driver = openBrowser(Constant.BROWSER_TYPE);
    // 2、访问登录地址
        driver.get(Constant.LOGIN_URL);
    // 3、最大化浏览器
        driver.manage().window().maximize();
    // 4、登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess(Constant.CORRECT_PHONE,Constant.CORRECT_PASSWORD);*/
    }

    @BeforeTest
    public void setUpTest() throws InterruptedException {
        addBidData();
    }

    @Test
    public void invest01() {

    }

    // 创建标的测试数据
    public void addBidData() throws InterruptedException {
        // 1、打开浏览器
        driver = openBrowser(Constant.BROWSER_TYPE);
        // 2、访问登录地址
        driver.get(Constant.BACKSTAGE_LOGIN_URL);
        // 3、最大化浏览器
        driver.manage().window().maximize();
        // 4、登录后台
        BackStageLoginPage backStageLoginPage = new BackStageLoginPage(driver);
        backStageLoginPage.loginSuccess(Constant.BACKSTAGE_CORRECT_USERNAME,
                Constant.BACKSTAGE_CORRECT_CORRECT_PASSWORD,Constant.VERIFICATION_CODE);
        // 5、后台建标
        BackStageMainPage backStageMainPage = new BackStageMainPage(driver);
        backStageMainPage.addBid("13323234444","出去看看再看看再看再看","10","6","100000","7",
                "2000000","广东广州","测试","22");
        // 6、审核最新的一条标
        backStageMainPage.verifyLatestBid();
    }

    @AfterMethod
    public void tearDownTest() {
        // 后置
        // 关闭浏览器，销毁driver
        driver.quit();
    }
}