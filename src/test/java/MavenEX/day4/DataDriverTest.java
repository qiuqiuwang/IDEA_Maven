package MavenEX.day4;

import MavenEX.day3.LoginTest;
import action.Email163;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataDriverTest {
    WebDriver webDriver;
    @BeforeTest
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
    }
    @DataProvider(name = "login")
    public Object[][] data1(){
        return new Object[][]{
                {"wqq7396","0123456789Wqq"}
        };
    }

    @Test(dataProvider = "login")
    public void login(String username,String password) throws InterruptedException {
        Email163.into(webDriver);   //进入登录界面
        Thread.sleep(2000);
        Email163.Loginaction(webDriver,username,password);
        Thread.sleep(1000);
    }

    @AfterTest
    public void close(){
        webDriver.quit();
    }
}
