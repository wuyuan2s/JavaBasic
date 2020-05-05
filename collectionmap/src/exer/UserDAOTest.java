package exer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wuyuan
 * @create 2020-04-23 16:06
 *
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 *  使用 Junit 单元测试类进行测试。
 */
public class UserDAOTest {

    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();

        userDAO.save("1001", new User(1001,18,"jj"));
        userDAO.save("1002",new User(1002,20,"kk"));
        userDAO.save("1003",new User(1003,30,"dd"));


        userDAO.update("1003",new User(1003,40,"mm"));

        userDAO.delete("1002");

        List<User> list = userDAO.list();
//        System.out.println(list);
        


        list.forEach(System.out::println);
    }
}
