package MavenEX.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    /**
     * 账号wqq7396
     * 密码123456789Wqq
     */

    WebDriver webDriver;

    @BeforeMethod
    public void openChrmoe() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }



    @Test
    public void loginSuccess() throws InterruptedException {
        LoginTest.login(webDriver,"wqq7396","123456789Wqq");
        WebDriverWait wait = new WebDriverWait(webDriver,2);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String ele = webDriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(ele,"退出");
        Thread.sleep(2000);
    }

    @Test
    public void loginFail() throws InterruptedException {
        LoginTest.login(webDriver,"wqq7396","0123456789Wqq");
        Thread.sleep(2000);
        String info  = webDriver.findElement(By.xpath("//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(info,"请先进行验证");
    }
    //定义静态方法，使得可以进行正常登陆和失败登陆两种情况
    public static void login(WebDriver webDriver,String username,String password) throws InterruptedException {
        webDriver.findElement(By.id("switchAccountLogin")).click();
        Thread.sleep(1000);
        //转交控制权
        WebElement element = webDriver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        webDriver.switchTo().frame(element);
        webDriver.findElement(By.name("email")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        webDriver.findElement(By.id("dologin")).click();
    }

    @AfterMethod
    public void closed(){
        webDriver.quit();
    }
}
