package javatest;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wuyuan
 * @create 2020-04-25 11:02
 *
 *
 *  * 一、流的分类：
 *  * 1.操作数据单位：字节流、字符流
 *  * 2.数据的流向：输入流、输出流
 *  * 3.流的角色：节点流、处理流
 *  *
 *  * 二、流的体系结构
 *  * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 *  * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 *  * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 *  * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 *  * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 */
public class FileReaderTest {
    public static void main(String[] args) {
        //相较于当前工程(在main方法中)
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());

        //相较于当前module
        File file1 = new File("IOStream\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }
     /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */
     @Test
    public void test(){
         FileReader fr = null;
         try {
//         1.实例化File类的对象，指明要操作的文件
             File f = new File("hello.txt");

             //2.提供具体的流
             fr = new FileReader(f);
             //3.数据的读入
             int data;
             while((data = fr.read()) != -1) {
                 System.out.print((char) data);

             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (fr != null) {
                     //4.流的关闭操作
                     fr.close();
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

    @Test
    public void test2(){
        //对read()操作升级：使用read的重载方法
        FileReader fr = null;
        try {
//      1.实例化File类的对象，指明要操作的文件
            File f = new File("hello.txt");

            //2.提供具体的流
            fr = new FileReader(f);

            //3.数据的读入
            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1){
                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4.流的关闭操作
    }
     /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
     @Test
    public void test3(){
         FileWriter fw = null;
         try {
             File f = new File("hello-write.txt");
             fw = new FileWriter(f);
             fw.write("helllo\t");
             fw.write("hadoop!\t");
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (fw != null)
                 fw.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

     @Test
    public void test4(){
         FileReader fr = null;
         FileWriter fw = null;
         try {
             //不能使用字符流来处理图片等字节数据
             File srcFile = new File("hello.txt");
             File destFile = new File("hello-write.txt");
             fr = new FileReader(srcFile);
             fw = new FileWriter(destFile);
             char[] chars = new char[5];
             int len;
             while ((len = fr.read(chars)) != -1){
                     fw.write(chars,0,len);
             }
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             try {
                 if (fr != null)
                 fr.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             try {
                 if (fw != null)
                 fw.close();
             } catch (IOException e) {

             }
         }
     }
}

