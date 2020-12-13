package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ElementLocate {
    public static void main(String[] args) {
        WebDriver driver = openBrowser("chrome");
//        driver.get("https://www.baidu.com");
        driver.get("http://120.78.128.25:8765/");

        // 通过id获取元素
//        driver.findElement(By.id("kw")).sendKeys("哈喽");
//        driver.findElement(By.id("su")).click();

        // 通过name获取到元素
//        driver.findElement(By.name("wd")).sendKeys("测试");
//        driver.findElement(By.id("su")).click();

        // 通过tagName获取元素
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());

        // 通过className获取元素  只支持单一类名定位（可选择多类名中其中一个唯一类名定位）
//        driver.findElement(By.className("s_ipt")).sendKeys("haha");
//        driver.findElement(By.className("s_btn")).click();
        // 通过标签内全部文本获取a标签元素
//        driver.findElement(By.linkText("hao123")).click();
        // 通过标签内部分文本获取a标签元素
//        driver.findElement(By.partialLinkText("hao")).click();

        // 通过cssSelection获取标签
        // （1）css选择器  支持多类名定位  id用#  class用.
//        driver.findElement(By.cssSelector(".s_ipt")).sendKeys("haha");
//        driver.findElement(By.cssSelector("#su")).click();
//        driver.findElement(By.cssSelector("input.s_ipt")).sendKeys("hahah");
//        driver.findElement(By.cssSelector("input#su")).click();
//        driver.findElement(By.cssSelector("input.bg.s_btn")).click();
        // （2）属性选择器
//        driver.findElement(By.cssSelector("input[maxlength='255'][autocomplete='off']")).sendKeys("hahah");
//        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // 通过xpath获取标签
        // //  匹配指定节点，不考虑元素位置（/表示绝对路径，从根元素开始）
        //  *  通配符，匹配任意元素节点  input 匹配input节点
        // []  属性判断条件表达式
        // @  选取属性
        // 1、单属性选择  //*[@属性名='属性值']
//        driver.findElement(By.xpath("//*[@name='wd']")).sendKeys("hahah");
//        driver.findElement(By.xpath("//input[@value='百度一下']")).click();
        // 2、多属性选择  //*[@属性名='属性值' and @属性名='属性值']
//        driver.findElement(By.xpath("//*[@maxlength='255' and @autocomplete='off']")).sendKeys("hahah");
//        driver.findElement(By.xpath("//input[@type='submit' and @value='百度一下']")).click();
        // 3、文本选择  text()函数  //*[text()='文本值']
//        driver.findElement(By.xpath("//*[text()='hao123']")).click();
        // 4、模糊匹配  contains()函数
        //（1）属性模糊匹配  //*[contains(@属性名,'文本值')]
//        driver.findElement(By.xpath("//*[contains(@value,'百度')]")).click();
        // 多个contains  //*[contains(@属性名,'文本值') and contains(@属性名,'文本值')]
        //（2）文本模糊匹配  //*[contains(text(),'文本值')]
//        driver.findElement(By.xpath("//*[contains(text(),'hao')]")).click();
//        String containsText = "hao";
//        driver.findElement(By.xpath("//[contains(text(),'"+containsText+"')]")).click();
        //（3）轴定位  利用父节点或兄弟节点进行定位
        // ancestor  当前节点的所有祖先节点（包括父节点）
        // parent  当前节点的父节点
        // preceding  当前节点之前的所有节点
        // preceding-sibling  当前节点之前的所有兄弟节点
        // following  当前节点之后的所有节点
        // following-sibling  当前节点之后的所有兄弟节点
        // 使用语法  /轴节点::节点名称[@属性=值]（后面可再跟//进行相对定位）
//        driver.findElement(By.xpath("//span[text()=' 测试m1604817748108']/parent::div/parent::a/following-sibling::div[1]//a[text()='抢投标']")).click();
    }

    /**
     * 封装打开浏览器方法
     *
     * @param browserName 浏览器名字
     * @return 驱动对象
     */
    public static WebDriver openBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            // 打开Chrome浏览器
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            // 访问网址 get方法
            // chromeDriver.get("https://www.baidu.com");
            return chromeDriver;
        } else if (browserName.equals("firefox")) {
            // 打开Firefox浏览器
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        }
        return null;

    }
}
