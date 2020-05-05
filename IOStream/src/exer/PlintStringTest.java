package exer;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author wuyuan
 * @create 2020-04-25 23:16
 */
public class PlintStringTest {
    @Test
    public void test() {
        PrintStream printStream = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("ASCLL.txt"));

            //创建打印流，设置自动刷新模式（写入换行符或‘\t'时都会刷新缓冲区）
            printStream = new PrintStream(fos,true);
            if (printStream != null){
                System.setOut(printStream);
            }


        for (int i = 0; i <= 255; i++) {//输出ASCLL码字符
            System.out.print((char) i);
            if (i % 50 == 0){//50个字符一行
                System.out.println();
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null)
            printStream.close();
        }

    }
}
