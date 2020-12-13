package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.Constant;

public class BasePage {
    private WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 等待元素可见
     * @param by 元素对应by对象
     * @return 可见元素
     */
    public WebElement waitElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Constant.WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * 等待元素可点击
     * @param by 元素对应by对象
     * @return 可点击对象
     */
    public WebElement waitElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver,Constant.WAIT_TIMEOUT);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * 输入数据的二次封装
     * @param by 元素对应by对象
     * @param typeData 数据的数据
     */
    public void typeData(By by,String typeData) {
        // 统一的操作日志
        waitElementVisible(by).sendKeys(typeData);
    }

    /**
     * 点击元素的二次封装
     * @param by 元素对应by对象
     */
    public void clickElement(By by) {
        // 统一的操作日志
        waitElementClickable(by).click();
    }

    /**
     * 获取元素文本值的二次封装
     * @param by 元素对应by对象
     * @return 元素文本值
     */
    public String getElementText(By by) {
        // 统一的操作日志
        return waitElementVisible(by).getText();
    }

    /**
     * 获取属性值的二次封装
     * @param by 元素对应by对象
     * @param attributeName 属性名
     * @return 属性值
     */
    public String getElementAttributeValue(By by,String attributeName) {
        // 统一的操作日志
        return waitElementVisible(by).getAttribute(attributeName);
    }

    /**
     * 元素是否可见的二次封装
     * @param by 元素对应by对象
     * @return 元素是否可见
     */
    public Boolean isElementDisplayed(By by) {
        // 统一的操作日志
        return waitElementVisible(by).isDisplayed();
    }

}
