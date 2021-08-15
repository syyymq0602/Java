package learn.day08;

import learn.day05.Person;

import java.io.*;
import java.util.ArrayList;

public class demo08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long s1 = System.currentTimeMillis();
        var inputPath = "C:\\Users\\PPG\\Desktop\\test.csv";
        var outputPath = "C:\\Users\\PPG\\Desktop\\java\\src\\learn\\day08\\ww.csv";
//        rw4(inputPath,outputPath);
        long s2 = System.currentTimeMillis();
        System.out.println("总共用时:" + (s2-s1) + "毫秒");

        ArrayList<Dog> arr = new ArrayList<>();

        arr.add(new Dog("泰迪",2));
        arr.add(new Dog("哈士奇",1));
        arr.add(new Dog("藏獒",4));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src\\learn\\day08\\a.txt"));
        oos.writeObject(arr);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\learn\\day08\\a.txt"));
        Object o = ois.readObject();

        ArrayList<Dog> lists = (ArrayList<Dog>)o;

        for (Dog list : lists) {
            System.out.println(list);
        }

        ois.close();
        oos.close();

    }

    private static void rw1(String inputPath, String outputPath) throws IOException {
        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath, true);
        int len;
        while((len = fis.read())!=-1){
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

    private static void rw2(String inputPath, String outputPath) throws IOException {
        FileInputStream fis = new FileInputStream(inputPath);
        FileOutputStream fos = new FileOutputStream(outputPath, true);
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes))!=-1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
    }

    private static void rw3(String inputPath, String outputPath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath));
        int len ;
        while((len = bis.read())!=-1){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    private static void rw4(String inputPath, String outputPath) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputPath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputPath));
        byte[] bytes = new byte[10240];
        int len ;
        while((len = bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }
}
