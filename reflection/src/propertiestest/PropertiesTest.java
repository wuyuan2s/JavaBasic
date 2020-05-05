package propertiestest;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author wuyuan
 * @create 2020-05-02 14:18
 */
public class PropertiesTest {
    @Test
    public void test(){
        Properties prop = new Properties();
        try {
            //读取配置文件方式一：
            //此时相对路径在当前module下，如果文件在src下，需要加上 src\\
          /*  FileInputStream fis = new FileInputStream(new File("src\\jdbc.properties"));
            prop.load(fis);*/

//            读取配置文件方式二：使用ClassLoader
//            配置文件默认识别在当前module的src下
            ClassLoader classLoader = PropertiesTest.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
            prop.load(resourceAsStream);

            String username = prop.getProperty("username");
            System.out.println("username: " + username);
            String password = prop.getProperty( "password");
            System.out.println("password: " +password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
