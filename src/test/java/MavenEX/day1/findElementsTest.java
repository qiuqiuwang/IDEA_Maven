package MavenEX.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class findElementsTest {
    WebDriver  webDriver;
    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        Thread.sleep(1000);
    }


    @Test
    public void byID(){    //根据id定位
        WebElement keyinput = webDriver.findElement(By.id("kw"));
        Assert.assertNotNull(keyinput,"keyinput为空");
    }

    @Test
    public void byName(){   //通过name定位
        WebElement keyinput = webDriver.findElement(By.name("wd"));
        Assert.assertNotNull(keyinput,"keyinput为空");
    }

    @Test
    public void byClass(){   //通过calssname定位
        WebElement keyinput = webDriver.findElement(By.className("mnav"));
        Assert.assertNotNull(keyinput,"keyinput为空");
    }


    @Test
    public void byLinkTest(){   //通过LinkTest定位
        WebElement keyinput = webDriver.findElement(By.linkText("新闻"));
        Assert.assertNotNull(keyinput,"keyinput为空");
    }


    @Test
    public void bypartialLinkText(){   //通过partialLinkText定位
        WebElement keyinput = webDriver.findElement(By.partialLinkText("新"));
        Assert.assertNotNull(keyinput,"keyinput为空");
    }

    @Test
    public void byTagName(){   //通过tag标签定位
        List<WebElement> keyinput = webDriver.findElements(By.tagName("input"));
        System.out.println(keyinput.size());
    }

    @Test
    public void byXpath(){   //通过Xpath定位元素
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"su\"]"));   //定位百度一下按钮
    }


    @Test
    public void byXpath02(){   //通过Xpath定位元素
        List<WebElement> element = webDriver.findElements(By.xpath("//*[@id=\"u1\"]/a"));
        System.out.println(element.size());

        String text = element.get(1).getText();
        System.out.println(text);
    }

    //没试出来
//    @Test
//    public void byCSS(){   //通过CSS定位元素
//        WebElement element = webDriver.findElement(By.cssSelector("#s_mp > area"));
//        System.out.println(element.getText());
//    }


    @AfterMethod
    public void closeChrome(){
        webDriver.quit();
    }
}
