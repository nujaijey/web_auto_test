package test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.utils.Constant;

public class IndexPage extends BasePage {
    private WebDriver driver;
    private By quitBy = By.xpath("//a[text()='退出']");
    private By loginBy = By.xpath("//a[contains(text(),'登录')]");
    private By nickNameBy = By.xpath("//a[contains(text(),'" + Constant.NICK_NAME +"')]");

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickQuit() {
//        driver.findElement(quitBy).click();
//        waitElementClickable(quitBy).click();
        clickElement(quitBy);
    }

    public void clickLogin() {
//        driver.findElement(loginBy).click();
//        waitElementClickable(loginBy).click();
        clickElement(loginBy);
    }


    public boolean isNickNameDisplayed() {
//        return driver.findElement(nickNameBy).isDisplayed();
        return isElementDisplayed(nickNameBy);
    }

}
