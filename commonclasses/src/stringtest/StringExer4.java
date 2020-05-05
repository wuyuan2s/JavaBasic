package stringtest;

import org.junit.Test;

/**
 * @author wuyuan
 * @create 2020-04-18 15:23
 */
public class StringExer4 {
    @Test
    public void test (){
        System.out.println(getMaxSameStr("aa", "cbaabccbanba"));
    }
    public String getMaxSameStr(String str1,String str2){
        if (str1 !=null && str2 !=null){
            String maxStr = str1.length() >= str2.length() ? str1 : str2;
            String minStr = str1.length() < str2.length() ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {//总的次数

                for (int x = 0, y = length-i;y <= length;x++,y++){//每一轮次数
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
}
