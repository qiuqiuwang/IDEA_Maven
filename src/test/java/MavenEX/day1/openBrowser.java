package MavenEX.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class openBrowser {
    WebDriver webDriver ;
    @BeforeTest
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void openurl() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        Thread.sleep(2000);
        webDriver.manage().window().maximize();
        Thread.sleep(2000);
        webDriver.navigate().back();
        Thread.sleep(2000);
        webDriver.navigate().forward();
        Thread.sleep(2000);
        String url = webDriver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url,"https://www.baidu.com/","链接不一样");
    }

    @AfterTest
    public void closeBrowser(){
        webDriver.quit();
    }
}
