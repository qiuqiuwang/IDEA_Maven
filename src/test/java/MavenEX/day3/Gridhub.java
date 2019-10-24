package MavenEX.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Gridhub {
    @DataProvider(name="browserData")
    public Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
            {"chrome","http://192.168.1.9:6666"},{"firefox","http://192.168.1.9:5555"}
        };
    }
//browserData这里的参数是和上面定义的名字一致
    @Test(dataProvider = "browserData")
    //传上面object参数
    public void testData(String browser,String url) throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = null ;
        if(browser.equals("chrome"))
            dc = DesiredCapabilities.chrome();
        else if(browser.equals("firefox"))
            dc = DesiredCapabilities.firefox();
        else
            System.out.println("error");

        WebDriver webDriver = new RemoteWebDriver(new java.net.URL(url+"/wd/hub"),dc);
        webDriver.get("http://www.baidu.com");
        Thread.sleep(5000);
        webDriver.quit();
    }
}
