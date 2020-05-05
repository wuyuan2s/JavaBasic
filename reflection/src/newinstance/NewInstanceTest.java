package newinstance;

import Classtest.Person;
import org.junit.Test;

import java.util.Random;

/**
 * @author wuyuan
 * @create 2020-05-02 14:37
 */
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {

        Class<Person> personClass = Person.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。

        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。


        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person p1 = personClass.newInstance();
        System.out.println(p1);
    }

    /**
     * 体会反射的动态性:编译时不知道是哪个类，只有运行时才确定；
     */
    @Test
    public void test2(){
        String classPath = "";
        for (int i = 0; i < 20; i++) {
            int num = new Random().nextInt(3);//0 1 2;
            switch (num){
                case 0:
                    classPath = "java.lang.String";
                    break;
                case 1:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "Classtest.Person";
                    break;
            }
            System.out.println(classPath);
        }


    }
    private Object getInstance(String calssPath) throws Exception {
        Class classIns = Class.forName("Classtest.Person");
        return classIns.newInstance();
    }
}
