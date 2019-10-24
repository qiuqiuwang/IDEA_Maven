package MavenEX.day3;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        //指定机器的ip和hub端口，wd/hub必须要写
        RemoteWebDriver webDriver = new RemoteWebDriver(new java.net.URL(" http://192.168.1.9:6666/wd/hub"),dc);
        webDriver.get("https://mail.163.com/");
        Thread.sleep(5000);
        webDriver.quit();
    }
}
