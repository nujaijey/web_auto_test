package test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;
    // 定位方式+定位表达式（值）=属性描述
    private By mobilePhoneBy = By.name("phone");
    private By passwordBy = By.name("password");
    private By rememberPhoneBy = By.name("remember_me");
    private By loginBy = By.xpath("//button[contains(text(),'登录')]");
    private By formInfoBy = By.className("form-error-info");
    private By centerInfoBy = By.className("layui-layer-content");

    // 用构造函数传驱动
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // 驱动谁调用谁提供
    public void typeMobilePhone(String data) {
//        driver.findElement(mobilePhoneBy).sendKeys(data);
//        waitElementVisible(mobilePhoneBy).sendKeys(data);
        typeData(mobilePhoneBy,data);
    }

    public void typePassword(String data) {
//        driver.findElement(passwordBy).sendKeys(data);
//        waitElementVisible(passwordBy).sendKeys(data);
        typeData(passwordBy,data);
    }

//    public void removeRememberPhoneChecked() {
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        WebElement webElement = waitElementVisible(rememberPhoneBy);
//        String attributeName = "checked";
//        javascriptExecutor.executeScript("arguments[0].removeAttribute(arguments[1])", webElement, attributeName);
//    }

    public void clickRememberPhone() {
//        waitElementVisible(rememberPhoneBy).click();
        clickElement(rememberPhoneBy);
    }

    public void clickLogin() {
//        driver.findElement(loginBy).click();
//        waitElementClickable(loginBy).click();
        clickElement(loginBy);
    }

    public String getMobilePhoneValue(){
//        return driver.findElement(mobilePhoneBy).getAttribute("value");
//        return waitElementVisible(mobilePhoneBy).getAttribute("value");
        return getElementAttributeValue(mobilePhoneBy,"value");
    }

    public String getFormInfo() {
//        return driver.findElement(formInfoBy).getText();
//        return waitElementVisible(formInfoBy).getText();
        return getElementText(formInfoBy);
    }

    public String getCenterInfo() {
//        WebDriverWait wait = new WebDriverWait(driver,8);
//        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(centerInfoBy));
//        return waitElementVisible(centerInfoBy).getText();
        return getElementText(centerInfoBy);
    }

    public void loginSuccess(String mobilePhone,String password) {
        typeMobilePhone(mobilePhone);
        typePassword(password);
        clickLogin();
    }

}
