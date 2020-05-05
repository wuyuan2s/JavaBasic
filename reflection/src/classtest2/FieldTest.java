package classtest2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author wuyuan
 * @create 2020-05-02 15:20
 */
public class FieldTest {
    @Test
    public void test() {
        Class personClass = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        System.out.println("获取当前运行时类及其父类中声明为public访问权限的属性");


        Field[] fields = personClass.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        System.out.println("获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field dfs :
                declaredFields) {
            System.out.println(dfs);
        }
    }

    //权限修饰符  数据类型 变量名
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String fName = f.getName();
            System.out.print(fName);

            System.out.println();
        }
    }
}
