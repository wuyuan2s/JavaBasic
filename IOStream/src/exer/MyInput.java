package exer;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wuyuan
 * @create 2020-04-25 18:40
 *
 *  Read a string from the keyboard
 */
public class MyInput {
    // Read a string from the keyboard
    //不能用单元测试的方法测试
    public static void main(String[] args) {
        System.out.println(readString());
        System.out.println(readDouble());
        System.out.println(readInt());

    }
    public static String readString(){
        //处理流：字节流转换为字符流
//        System类中：public final static InputStream in = null;//in是字节流
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        String string = "";
        try {
            string = bufferedReader.readLine();
//            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }//不能直接close（）关闭流，没有读取物理文件（我的理解）
        // Return the string obtained from the keyboard
        return string;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static float readFloat(){
        return Float.parseFloat(readString());
    }

    public static byte readByte(){
        return Byte.parseByte(readString());
    }
    public static long readLong(){
        return Long.parseLong(readString());
    }


}
