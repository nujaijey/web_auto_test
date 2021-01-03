package test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.utils.Constant;

public class BackStageLoginPage extends BasePage {
    private WebDriver driver;
    public BackStageLoginPage(WebDriver driver) {
        super(driver);
    }
    private By usernameBy = By.name("admin_name");
    private By passwordBy = By.name("admin_pwd");
    private By verificationBy = By.name("code");
    private By loginBy = By.xpath("//button[text()='登陆后台']");

    public void typeUsername(String data) {
        typeData(usernameBy,data);
    }

    public void typePassword(String data) {
        typeData(passwordBy,data);
    }

    public void typeVerificationCode(String data) {
        typeData(verificationBy,data);
    }

    public void clickLogin() {
        clickElement(loginBy);
    }

    public void loginSuccess(String username,String password,String code) {
        typeUsername(username);
        typePassword(password);
        typeVerificationCode(code);
        clickLogin();
    }

}
