package javatest;


import org.junit.Test;

import java.io.*;

/**
 * @author wuyuan
 * @create 2020-04-26 16:34
 *
 *  * 1.ObjectInputStream 和 ObjectOutputStream
 *  * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *  *
 *  * 3.要想一个java对象是可序列化的，需要满足相应的要求。见Person.java
 *  *
 *  * 4.序列化机制：
 *  * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种
 *  * 二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 *  * 当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 */
public class ObjectStreamTest {

    /*
      序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
      使用ObjectOutputStream实现
   */
    @Test
    public void OutputTest(){
        ObjectOutputStream oos = null;
        try {
            File file = new File("object.bat");
            FileOutputStream fis = new FileOutputStream(file);
            oos = new ObjectOutputStream(fis);
            oos.writeObject(new String("String类序列化！"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("wuyuan", 18,001, new Account(5000.00)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    /*
      反序列化：将磁盘文件中的对象还原为内存中的一个java对象
      使用ObjectInputStream来实现
   */
    @Test
    public void InputTest(){
        ObjectInputStream ois = null;
        try {
            File file = new File("object.bat");
            FileInputStream fis = new FileInputStream(file);
             ois = new ObjectInputStream(fis);

             String str = (String) ois.readObject();
            System.out.println(str);

             Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }


}
