package MavenEX.day1;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AssertTest {
    String a="wqq";
    @Test
    public void assertEquals(){
        String b="abcd";
        Assert.assertEquals(a,b,"不相等");
        System.out.println("是否执行");
    }
    @Test
    public void assertnotEquale(){
        String b ="abcd";
        Assert.assertNotEquals(a,b,"a和b不一样");
    }
    @Test
    public void assertnull(){
        String b = null;
        Assert.assertNull(b,"不为空");
    }

}
