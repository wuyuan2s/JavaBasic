package stringtest;

/**
 * @author wuyuan
 * @create 2020-04-18 11:04
 */
public class StringExer2 {
    public static void main(String[] args) {
        System.out.println(reverse4("String", 1, 4));
    }

    public static String reverse1 (String str1, int start, int end){
        //题目：传入字符串反转指定范围的字符
        char[] charArray = str1.toCharArray();//String转换为char型数组
        char[] newChar;
        newChar = charArray.clone();
        int j = 1;
        for (int i = charArray.length-2; i > 0; i--) {
            newChar[j++] = charArray[i];
        }
        String s2 = new String(newChar);
        System.out.println(s2);
        return s2;
    }

    public static String reverse2 (String str, int start, int end){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int i = start, j = end; i < j; i++,j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
            return new String(arr);
        }
        return null;
    }
    //方式三：
    public static String reverse3 (String str, int start, int end){
        if (str != null){
            //第一部分
            String reverseStr = str.substring(0,start);
            //第二部分
            for (int i = end; i >= start; i--) {
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(end + 1);
            return reverseStr;
        }
        return null;
    }

    //方式4：
    public static String reverse4 (String str, int start, int end){
        if (str != null){
            StringBuilder builder = new StringBuilder(str.length());

            builder.append(str.substring(0,start));
            for (int i = end; i >= start ; i--) {
                builder.append(str.charAt(i));
            }

            builder.append(str.substring(end+1));
            return  builder.toString();
        }
        return null;
    }
}
