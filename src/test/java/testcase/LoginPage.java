package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }


    private By phoneInput = By.name("phone");
    private By pwdInput = By.name("password");
    private By loginBtn = By.xpath("//button[contains(text(),'登录')]");



    public LoginPage loginSuccess(String phoneNum,String password){
        sendKey(phoneInput,phoneNum);
        sendKey(pwdInput,password);
        clickElement(loginBtn);
        return this;
    }

    public String getLoginResult(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle();
    }
}
