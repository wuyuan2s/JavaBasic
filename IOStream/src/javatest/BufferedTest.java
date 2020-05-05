package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author wuyuan
 * @create 2020-04-25 15:34
 *
 *  * 处理流之一：缓冲流的使用
 *  *
 *  * 1.缓冲流：
 *  * BufferedInputStream
 *  * BufferedOutputStream
 *  * BufferedReader
 *  * BufferedWriter
 *  *
 *  * 2.作用：提供流的读取、写入的速度
 *  *   提高读写速度的原因：内部提供了一个缓冲区
 *  *
 *  * 3. 处理流，就是“套接”在已有的流的基础上。
 */
public class BufferedTest {
    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("护眼色.jpg") ;
            File destFile = new File("护眼色-1.jpg") ;
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[10];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
 使用BufferedReader和BufferedWriter实现文本文件的复制

  */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：使用String,br.readLine()读取一行内容，返回值不包括换行符
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
