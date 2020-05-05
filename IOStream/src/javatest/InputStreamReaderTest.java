package javatest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wuyuan
 * @create 2020-04-25 17:51
 *
 *  * 处理流之二：转换流的使用
 *  * 1.转换流：属于字符流
 *  *   InputStreamReader：将一个字节的输入流转换为字符的输入流
 *  *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *  *
 *  * 2.作用：提供字节流与字符流之间的转换
 *  *
 *  * 3. 解码：字节、字节数组  --->字符数组、字符串
 *  *    编码：字符数组、字符串 ---> 字节、字节数组
 *  *
 *  *
 *  * 4.字符集
 *  *ASCII：美国标准信息交换码。
 *     用一个字节的7位可以表示。
 *  ISO8859-1：拉丁码表。欧洲码表
 *     用一个字节的8位表示。
 *  GB2312：中国的中文编码表。最多两个字节编码所有字符
 *  GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *  Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *  UTF-8：变长的编码方式，可用1-4个字节来表示一个字符。
 */
public class InputStreamReaderTest {
    @Test
    public void inputStreamReaderTest(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
//            字节流
            fis = new FileInputStream("hello.txt");

            //转换流：字节流转换为字符流
            isr = new InputStreamReader(fis,"UTF-8");
            char[] chars = new char[10];
            int len;
            while ((len = isr.read(chars)) != -1) {
                String data = new String(chars,0,len);
                System.out.print(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
