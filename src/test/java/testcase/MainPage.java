package testcase;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPage  extends BasePage{

    public MainPage(){
        this.init();
    }

    public void init(){
        driver = openBrowser("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }

    public LoginPage loginPage(){

        return new LoginPage(driver);
    }



    public void teardown(){
        driver.quit();
    }
}
