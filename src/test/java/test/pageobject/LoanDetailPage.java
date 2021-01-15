package test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.common.BasePage;

public class LoanDetailPage extends BasePage {
    private WebDriver driver;
    public LoanDetailPage(WebDriver driver) {
        super(driver);
    }

    // 输入投资金额
    private By investAmountBy = By.xpath("//input[@data-url='/Invest/invest']");
    public void typeInvestAmount(String data) {
        typeData(investAmountBy,data);
    }

    // 点击投标
    private By bidBy = By.xpath("//button[text()='投标']");
    public void clickBid() {
        clickElement(bidBy);
    }

    // 成功投资
}
