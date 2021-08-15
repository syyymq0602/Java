package web.day02;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Field[] declaredFields = dogClass.getDeclaredFields();
        Field f = dogClass.getDeclaredField("a");

        Dog d = new Dog();
        f.setAccessible(true);
        f.set(d,"www");
        System.out.println(f.get(d));

        Constructor constructor = dogClass.getConstructor(String.class, int.class, int.class);
        Object o = constructor.newInstance("222", 1, 2);
        Object o1 = dogClass.getConstructor().newInstance();
        System.out.println(o);

        KJ();

    }
    private static void KJ() throws Exception {
        Properties prop = new Properties();
        ClassLoader loader = ReflectDemo.class.getClassLoader();
        InputStream resource = loader.getResourceAsStream("prop.properties");
        prop.load(resource);

        String name = prop.getProperty("className");
        String method = prop.getProperty("methodName");

        Class<?> cls = Class.forName(name);
        Object o2 = cls.getConstructor().newInstance();
        Method clsMethod = cls.getMethod(method);
        clsMethod.invoke(o2);
    }
}
