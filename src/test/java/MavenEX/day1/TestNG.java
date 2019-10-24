package MavenEX.day1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
    @Test
    public void testCase2() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("这是Testcase");
    }
    @Test
    public void testCase1()throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("这是Testcase1");
    }
    @BeforeTest
    public void test() throws InterruptedException {
            Thread.sleep(5000);
        System.out.println("这是前置条件");
    }
}
