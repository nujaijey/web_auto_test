package test.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.common.BaseTest;
import test.pageobject.*;
import test.utils.Constant;

public class InvestTest extends BaseTest {
    WebDriver driver;
    String loanTitle = "";

    @BeforeMethod
    public void setUpMethod() {
        // 前置
        // 1、打开浏览器
        driver = openBrowser(Constant.BROWSER_TYPE);
        // 2、访问登录地址
        driver.get(Constant.LOGIN_URL);
        // 3、最大化浏览器
        driver.manage().window().maximize();
        // 4、登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginSuccess(Constant.CORRECT_PHONE, Constant.CORRECT_PASSWORD);
    }

    /**
     *  测试数据准备 --自动化方式
     *  （1）接口方式  优点：数据正确性高 缺点：准备比较多的参数 --可以忽略不计
     *  （2）数据库方式  优点：适合数据量大  缺点：表的依赖性强
     *  （3）UI方式  优点：直观、符合业务  缺点：不稳定、效率低
     *  一般是结合数据库和接口方式造数据
     */
    @BeforeTest
    public void setUpTest() throws InterruptedException {
        addBidData();
    }

    @Test
    public void invest01() throws InterruptedException {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickRushToBid(loanTitle);
        LoanDetailPage loanDetailPage = new LoanDetailPage(driver);
        Thread.sleep(2000);
        loanDetailPage.typeInvestAmount("200");
        Thread.sleep(2000);
        loanDetailPage.clickBid();

    }


    @AfterMethod
    public void tearDownTest() {
        // 后置
        // 关闭浏览器，销毁driver
        driver.quit();
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
                Constant.BACKSTAGE_CORRECT_CORRECT_PASSWORD, Constant.VERIFICATION_CODE);
        // 5、后台建标
        BackStageMainPage backStageMainPage = new BackStageMainPage(driver);
        // 时间戳
        Long timeStamp = System.currentTimeMillis();
        loanTitle = "测试" + timeStamp;
        backStageMainPage.addBid(Constant.BORROWER_PHONE, loanTitle, "10", "6",
                "100000", "7", "2000000", "广东广州", "测试", "22");
        // 6、审核最新的一条标
        backStageMainPage.verifyLatestBid();
    }
}
