package stringtest;

/**
 * @author wuyuan
 * @create 2020-04-17 11:06
 */
public class StringExer {
    String string = new String("FIRST!");
    char[] chars = new char[]{'t','e','s','t'};

    public void change(String string, char chars[]){

        //由于string的不可变性，传进来的是地址值，而修改字符串后不会改变原来的地址，
        // 而是开辟一个地址给到方法中的string，原来的地址中字符串不变
        string = "SECOND!";
        chars[0] = 'b';
    }
    public static void main(String[] args) {
        StringExer stringExer = new StringExer();

        stringExer.change(stringExer.string,stringExer.chars);

        System.out.println(stringExer.string);
        System.out.println(stringExer.chars);
    }

}
