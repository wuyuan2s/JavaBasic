package classtest2;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wuyuan
 * @create 2020-05-02 20:47
 *
 * 调用运行时类中指定的结构：属性、方法、构造器
 */
public class ReflectionTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p1 = personClass.newInstance();

        //获取指定的属性
        Field id = personClass.getField("id");

        //设置当前属性的值
        // set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少
        id.set(p1, 123);
        
        int pId = (int) id.get(p1);
        System.out.println(pId);
        
        int i1 = 0011;//java中int类型不能用0开头，会转换为8进制
        System.out.println(i1);
    }

    /*
   如何操作运行时类中的指定的属性 -- 需要掌握
    */
    @Test
    public void testField() throws Exception {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取、设置指定对象的此属性值
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }

    @Test
    public void testMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> personClass = Person.class;

        //创建运行时类的对象
        Person p2 = personClass.newInstance();
        /*
        1.获取指定的某个方法
        getDeclaredMethod():参数1 ：指明获取的方法的名称  参数2：指明获取的方法的形参列表
         */
        Method show = personClass.getDeclaredMethod("show", String.class);

        //2.保证当前方法是可访问的
        show.setAccessible(true);

        /*
        3. 调用方法的invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值。
         */
        Object returnValue = show.invoke(p2, "china");
        System.out.println(returnValue);

        System.out.println("*************如何调用静态方法*****************");

        // private static void showDesc()
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);
    }

    /*
    如何调用运行时类中的指定的构造器
     */
    @Test
    public void testConstructor() throws Exception {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */

        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器创建运行时类的对象
        Person per = (Person) constructor.newInstance("Tom");
        System.out.println(per);

    }

}
