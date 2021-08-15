package web.day03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class ZJ {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Class<? extends Calculator> cls = c.getClass();
        Method[] method = cls.getMethods();

        int exceptionNumber = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method1 : method) {
            if (method1.isAnnotationPresent(Check.class)){
                try{
                    method1.invoke(c);
                }catch (Exception e){
                    exceptionNumber++;
                    bw.write(method1.getName() + "  方法出异常了");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次一共出现"+exceptionNumber+"次异常");
        bw.flush();
        bw.close();
    }
    private static int add (int a,int b){
        return a+b;
    }
}
