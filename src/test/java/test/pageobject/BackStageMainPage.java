package test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.common.BasePage;

public class BackStageMainPage extends BasePage {
    private WebDriver driver;

    public BackStageMainPage(WebDriver driver) {
        super(driver);
    }

    // 点击借款管理loanManagement
    private By loanManagementBy = By.xpath("//span[text()='借款管理']");

    public void clickLoanManagement() {
        clickElement(loanManagementBy);
    }

    // 点击加标addBid
    private By addBidBy = By.xpath("//span[text()='加标']");

    public void clickAddBid() {
        clickElement(addBidBy);
    }

    // 切换mainIframe
    private By mainIframeBy = By.id("mainFrame");

    public void switchIframe() {
        switchIframe(mainIframeBy);
    }

    // 输入借款人borrower
    private By borrowerBy = By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]");

    public void typeBorrower(String data) {
        typeData(borrowerBy, data);
        typeKey(borrowerBy, Keys.ARROW_DOWN);
        typeKey(borrowerBy, Keys.ENTER);
    }

    // 输入贷款标题loanTitle
    private By loanTitleBy = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");

    public void typeLoanTitle(String data) {
        typeData(loanTitleBy, data);
    }

    // 输入年利率利息rate
    private By rateBy = By.xpath("//td[text()='年利率利息:']/following-sibling::td/input");

    public void typeRate(String data) {
        typeData(rateBy, data);
    }

    // 输入借款期限term
    private By termBy = By.xpath("//td[text()='借款期限:']/following-sibling::td/input");

    public void typeTerm(String data) {
        typeData(termBy, data);
    }

    // 输入借款额度limit
    private By limitBy = By.xpath("//td[text()='借款额度:']/following-sibling::td/input");

    public void typeLimit(String data) {
        typeData(limitBy, data);
    }

    // 输入竞标期限period
    private By periodBy = By.xpath("//td[text()='竞标期限:']/following-sibling::td/input");

    public void typePeriod(String data) {
        typeData(periodBy, data);
    }

    // 点击风控评测evaluation
    private By evaluationBy = By.xpath("//span[text()='风控评测']");

    public void clickEvaluation() {
        clickElement(evaluationBy);
    }

    // 输入评估价值evaluationValue
    private By evaluationValueBy = By.xpath("//td[text()='评估价值:']/following-sibling::td/input");

    public void typeEvaluationValue(String data) {
        typeData(evaluationValueBy, data);
    }

    // 点击项目录入projectEntry
    private By projectEntryBy = By.xpath("//span[text()='项目录入']");

    public void clickProjectEntry() {
        clickElement(projectEntryBy);
    }

    // 输入籍贯nativePlace
    private By nativePlaceBy = By.xpath("//td[text()='籍贯:']/following-sibling::td/input");

    public void typeNativePlace(String data) {
        typeData(nativePlaceBy, data);
    }

    // 输入职业occupation
    private By occupationBy = By.xpath("//td[text()='职业:']/following-sibling::td/input");

    public void typeOccupation(String data) {
        typeData(occupationBy, data);
    }

    // 输入年龄age
    private By ageBy = By.xpath("//td[text()='年龄:']/following-sibling::td/input");

    public void typeAge(String data) {
        typeData(ageBy, data);
    }

    // 点击提交commit
    private By commitBy = By.xpath("//span[text()='提交']");

    public void clickCommit() {
        clickElement(commitBy);
    }

    // 加标
    public void addBid(String borrowerName, String loanTitle, String rate, String term, String limit, String period,
                       String evaluationValue, String nativePlace, String occupation, String age) {
        clickLoanManagement();
        switchIframe(mainIframeBy);
        clickAddBid();
        typeBorrower(borrowerName);
        typeLoanTitle(loanTitle);
        typeRate(rate);
        typeTerm(term);
        typeLimit(limit);
        typePeriod(period);
        clickEvaluation();
        typeEvaluationValue(evaluationValue);
        clickProjectEntry();
        typeNativePlace(nativePlace);
        typeOccupation(occupation);
        typeAge(age);
        clickCommit();
    }

    // 点击审核verify
    private By verifyBy = By.xpath("//span[text()='审核']");

    public void clickVerify() {
        clickElement(verifyBy);
    }

    // 点击审核verifyPassed
    private By verifyPassBy = By.xpath("//span[text()='审核通过']");

    public void clickVerifyPass() {
        clickElement(verifyPassBy);
    }

    // 点击最新的一条标
    private By latestBidBy = By.id("datagrid-row-r1-2-0");

    public void clickLatestBid() {
        clickElement(latestBidBy);
    }

    // 审核最新的一条标三次
    public void verifyLatestBid() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(3000);
            clickLatestBid();
            clickVerify();
            clickVerifyPass();
        }

    }

}
