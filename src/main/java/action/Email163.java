package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.Login_page;

public class Email163 {
    public static void Loginaction(WebDriver webDriver, String username, String password){
        webDriver.findElement(Login_page.username).sendKeys(username);
        webDriver.findElement(Login_page.password).sendKeys(password);
        webDriver.findElement(Login_page.loginbut).click();
    }
    public static void into(WebDriver webDriver) throws InterruptedException {
        webDriver.findElement(Login_page.login).click();
        Thread.sleep(1000);
        WebElement element = webDriver.findElement(Login_page.iframe);
        webDriver.switchTo().frame(element);
    }
}
