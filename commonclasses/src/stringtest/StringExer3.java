package stringtest;

import org.junit.Test;

/**
 * @author wuyuan
 * @create 2020-04-18 14:49
 */
public class StringExer3 {
    @Test
    public void test(){
//        返回子字符串在已知字符串中出现的次数
        System.out.println(getCount("asdababcdab", "ab"));
    }

    public int getCount(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
//            方式一：
//            while ((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(subLength+index);
//            }
//            方式二：方式一改进
            while (((index = mainStr.indexOf(subStr,index)) != -1)){
                count++;
                index +=subLength;
            }
        }
        return count;
    }
}
