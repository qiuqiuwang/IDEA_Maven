package MavenEX.day3;

import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver webDriver;

    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }
    @BeforeMethod
    public void loginTest() throws InterruptedException {
        LoginTest.login(webDriver,"wqq7396","123456789Wqq");
    }

    @Test
    public void sendEmail() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='写 信']")));
        webDriver.findElement(By.xpath("//*[text()='写 信']")).click();   //点开写信
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title=\"发给多人时地址请以分号隔开\"]")));
//        WebElement ele1 = webDriver.findElement(By.xpath("//*[@title=\"发给多人时地址请以分号隔开\"]"));
//        ele1.click();
//        Thread.sleep(2000);
        //输入发送地址
        webDriver.findElement(By.xpath("//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("1731058693@qq.com");
        //输入主题
        webDriver.findElement(By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("163发邮件测试");
        Thread.sleep(2000);
        //上传附件
        webDriver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("F:\\软件测试\\PPT\\WebDriver 框架开发实践_二期.pptx");
        //递交控制权
        WebElement frame = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(frame);
        //输入正文
        webDriver.findElement(By.xpath("/html/body")).sendKeys("你好啊");
        Thread.sleep(2000);
        //控制权转交给原始
        webDriver.switchTo().defaultContent();
        //发送
        webDriver.findElement(By.xpath("//*[text()='发送']")).click();
        Thread.sleep(2000);
        //验证邮件是否发送成功，页面展示发送成功
        Boolean bl = webDriver.findElement(By.className("tK1")).isDisplayed();
        Assert.assertTrue(bl);
    }

    @AfterMethod
    public void closed(){
        webDriver.quit();
    }
}
