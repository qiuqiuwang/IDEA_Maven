package MavenEX.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver webDriver;

    @BeforeMethod
    public void openChrmoe() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }

    @Test
    public void register() throws InterruptedException {
        webDriver.findElement(By.linkText("注册新帐号")).click(); //发现跳转到新的界面
        Thread.sleep(2000);
        //转交界面控制权
        String handle = webDriver.getWindowHandle();
        for(String hansles : webDriver.getWindowHandles()){
            if(handle.equals(hansles))
                continue;
            webDriver.switchTo().window(hansles);//转交给新界面
        }

        String time = String.valueOf(System.currentTimeMillis()/100);//获取当前时间戳
        //操作注册界面
        webDriver.findElement(By.id("nameIpt")).sendKeys("wqq"+time);
        Thread.sleep(1000);
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("123456abc");
        Thread.sleep(1000);
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456abc");
        Thread.sleep(1000);
        //在实际中遇到验证码，就找到开发要一个万能验证码，或者让开发不校验验证码，或者解析验证码图片（不值当）
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("123123");   //这里只能输入一个错误的验证码
        Thread.sleep(1000);
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys(time);  //用时间戳代替手机号
        Thread.sleep(1000);
        webDriver.findElement(By.id("mainAcceptIpt")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("已发送短信验证，立即注册")).click();
        //显性等待，保证下面是能够显示出来再找元素
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_vcode\"]/span")));
        String info = webDriver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(info,"  验证码不正确，请重新填写");
    }

    @AfterMethod
    public void closed(){
        webDriver.quit();
    }
}
