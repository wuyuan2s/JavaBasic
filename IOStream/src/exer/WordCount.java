package exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wuyuan
 * @create 2020-04-25 16:47
 *
 *  * 练习3:获取文本上字符出现的次数,把数据写入文件
 *  *
 *  * 思路：
 *  * 1.遍历文本每一个字符
 *  * 2.字符出现的次数存在Map中
 *  *
 *  * Map<Character,Integer> map = new HashMap<Character,Integer>();
 *  * map.put('a',18);
 *  * map.put('你',2);
 *  *
 *  * 3.把map中的数据写入文件
 */
public class WordCount {
   @Test
    public void WordCountTest(){

       Map<Character, Integer> map = new HashMap<>();

       FileReader fr = null;
       BufferedWriter bw = null;
       try {
           File f = new File("hello.txt");
           fr = new FileReader(f);

           char chars;
           int data;
           while((data = fr.read()) != -1){
               chars = (char) data;
               if (map.get(chars) == null){
                   map.put(chars,1);
               }else {
                   map.put(chars,(map.get(chars)+1));
               }
           }
           bw = new BufferedWriter(new FileWriter("count.txt"));

           Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
           for (Map.Entry<Character, Integer> entrys: entrySet){
                switch (entrys.getKey()){
                    case ' ':
                        bw.write("空格" + entrys.getValue());
                        break;
                    case '\t':
                        bw.write("制表符" + entrys.getValue());
                        break;
                    case '\r':
                        bw.write("回车" + entrys.getValue());
                        break;
                    case '\n':
                        bw.write("换行" + entrys.getValue());
                        break;
                    default:
                        bw.write(entrys.getKey()+"\t" + entrys.getValue());
                        break;
                }
                bw.newLine();
           }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (bw != null) {
               try {
                   bw.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           if (fr != null) {
               try {
                   fr.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
   }

}
