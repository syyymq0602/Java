package web.day01.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import web.day01.code.Calculator;

public class CalculatorTest {
    @Before
    public void init(){
        System.out.println("init......");
    }
    @After
    public void end(){
        System.out.println("end....");
    }
    @Test
    public void testadd(){
        int res = new Calculator().add(10,18);
        System.out.println(res);
        Assert.assertEquals(28,res);
    }
}
