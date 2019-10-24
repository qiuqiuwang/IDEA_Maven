package page;

import org.openqa.selenium.By;

public class Login_page {
    //首页登录按钮
    public static By login = By.id("switchAccountLogin");
    //iframe转交控制权
    public static By iframe = By.xpath("//*[@id='loginDiv']/iframe");
    //登录参数
    public static By username = By.name("email");
    public static By password = By.name("password");
    public static By loginbut = By.id("dologin");
}
