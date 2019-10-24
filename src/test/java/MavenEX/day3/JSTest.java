package MavenEX.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    WebDriver webDriver ;

    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        Thread.sleep(1000);
    }

    /**
     * 打开百度之后后台获取输入框元素
     * @throws InterruptedException
     */
    @Test
    public void jsTest() throws InterruptedException {
        JavascriptExecutor js =(JavascriptExecutor)webDriver;
        js.executeAsyncScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closed(){
        webDriver.quit();
    }

}
