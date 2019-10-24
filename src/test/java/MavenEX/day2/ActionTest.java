package MavenEX.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionTest {



    WebDriver webDriver;


    @BeforeMethod
    public void openChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\WEBtest\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.baidu.com/");
        Thread.sleep(1000);
    }

    //点击百度页面新闻按钮


    @Test
    public void clickTest(){
        //定位新闻
        WebElement element = webDriver.findElement(By.name("tj_trnews"));
        //点击，打开链接
        element.click();
        String getURL = webDriver.getCurrentUrl();   //获得当前链接
        Assert.assertEquals(getURL,"http://news.baidu.com/","链接不对");
    }

    //打开百度，输入Selenium，进行搜索
    //校验title是否是“selenium_百度搜索”

    @Test
    public void sentkeysTest() throws InterruptedException {
        //定位输入框
        WebElement input = webDriver.findElement(By.id("kw"));
        //输入苏索内容
        input.sendKeys("selenium");
        //定位百度按钮
        WebElement button = webDriver.findElement(By.id("su"));
        //点击
        button.click();
        Thread.sleep(2000);
        //获取页面title
        String title = webDriver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
    }



    //清空输入框中输入的值
    @Test
    public void clearTest() throws InterruptedException {
        //定位输入框
        WebElement input = webDriver.findElement(By.id("kw"));
        //输入搜索内容
        input.sendKeys("selenium");
        Thread.sleep(2000);
        //清空搜索内容
        input.clear();
        Thread.sleep(2000);
    }

    //获取页面文本内容
    @Test
    public void getTextTest() throws InterruptedException {
        //定位输入框
        String text = webDriver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"新闻");
    }

    //打开百度界面
    //百度一下按钮右击
    @Test
    public void rightclick() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        WebElement element = webDriver.findElement(By.id("su"));
        Thread.sleep(1000);
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //右击百度一下，并且perform()执行，不执行是不起作用的
        actions.contextClick(element).perform();
        Thread.sleep(1000);
    }

    //打开百度界面
    //双击百度一下按钮
    @Test
    public void doubleclick() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        WebElement element = webDriver.findElement(By.id("su"));
        Thread.sleep(1000);
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //双击百度一下，并且perform()执行，不执行是不起作用的
        actions.doubleClick(element).perform();
        Thread.sleep(1000);
    }

    /**
     * 打开测试代码
     * 鼠标移动到Actions
     * 展示隐藏Hello World!
     */

    @Test
    public void mousemove() throws InterruptedException {
        webDriver.get("file:///D:/%E6%88%91%E7%9A%84%E6%96%87%E4%BB%B6/%E6%B5%8B%E8%AF%95%E5%BA%94%E5%A4%87%E6%8A%80%E8%83%BD/demo/selenium_html/index.html");//老师的测试代码
        Thread.sleep(2000);
        WebElement element = webDriver.findElement(By.xpath(".//*[@id=\"action\"]/input"));
        //定义Actions对象
        Actions actions = new Actions(webDriver);
        //鼠标移动到元素上
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
//        String ele = webDriver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
//
//        Assert.assertEquals(ele,"Hello World!");
    }

    /**
     * 打开测试代码
     * 定位拖拽元素
     * 拖拽元素到新的位置
     */

    @Test
    public void dragAndDropTest() throws InterruptedException {
        webDriver.get("file:///F:/%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95/selenium_html/dragAndDrop.html");
        Thread.sleep(2000);
        WebElement element = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        //元素拖拽
        actions.dragAndDropBy(element,500,500).perform();
        Thread.sleep(2000);

    }

    /**
     * 将一个元素拖拽到另外一个元素上
     * 首先定位到两个元素
     * 然后摁住一个元素放到另一个上，再释放元素，最后执行
     */

    @Test
    public void droptest() throws InterruptedException {
        webDriver.get("file:///F:/%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95/selenium_html/dragAndDrop.html");
        Thread.sleep(2000);
        WebElement element1 = webDriver.findElement(By.xpath("//*[@id=\"drag\"]"));
        WebElement element2 = webDriver.findElement(By.tagName("h1"));
        Actions actions = new Actions(webDriver);
        actions.clickAndHold(element1).moveToElement(element2).release().perform();
        Thread.sleep(2000);

    }

    /**
     * 下拉框多选
     * 定位到下拉框，然后找出下拉框中的所有选项放在list里
     * 然后控制键盘选择想要选择的
     */

    @Test
    public void moreSelectTest() throws InterruptedException {
        webDriver.get("file:///F:/%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95/selenium_html/index.html");
        Thread.sleep(2000);
        WebElement select = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple")); //定位到下拉框
        List<WebElement> options = select.findElements(By.tagName("option"));  //获取下拉框中的元素
        Actions actions = new Actions(webDriver);   //转交控制权
        actions.keyDown(Keys.SHIFT)     //按住Shift选择前三个选项
//                .click(options.get(1))
                .click(options.get(3))
                .keyUp(Keys.SHIFT)
                .perform();
        Thread.sleep(2000);
        actions.keyDown(Keys.CONTROL)     //按住Ctrl选择前三个选项
//                .click(options.get(1))
                .click(options.get(3))
                .keyUp(Keys.CONTROL)
                .perform();
        Thread.sleep(2000);
    }

    /**
     * java提供Robot类控制，控制键盘上字母以及其他功能键
     */

    @Test
    public void javaRobotTest() throws AWTException, InterruptedException {
        Robot robot = new Robot();
        //弹出保存框
        robot.keyPress(KeyEvent.VK_CONTROL);     //摁住Ctrl
        int S =(int) new Character('S');
        System.out.println(S);
        robot.keyPress(S);   //利用ASCII码按键
        //robot.keyPress(KeyEvent.VK_S);   //摁住S
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_ENTER);       //摁住enter,其实是Ctrl+Enter保存
        robot.keyRelease(KeyEvent.VK_CONTROL);   //释放Ctrl键
    }

    /**
     *1. 定位上传控件
     *2. 使用sendkeys()方法，并传入文件路径
     */

    @Test
    public void sendFile(){
        webDriver.get("file:///F:/%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95/selenium_html/index.html");
        webDriver.findElement(By.xpath("//*[@id=\"load\"]"))
                .sendKeys("F:\\软件测试\\PPT\\webdriver基础教程.pptx");

    }

    @AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}

