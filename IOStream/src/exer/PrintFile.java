package exer;

import org.junit.Test;

import java.io.File;

/**
 * @author wuyuan
 * @create 2020-04-23 21:29
 *
 *  * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 	拓展1：并计算指定目录占用空间的大小
 * 	拓展2：删除指定文件目录及其下的所有文件
 */
public class PrintFile {
    public static void main(String[] args) {
        File f = new File("G:\\Music");
        printFile(f);
    }

    /**
     * 递归实现遍历指定目录所有文件名称，包括子文件目录中的文件
     * @param dir
     */
    public static void printFile(File dir){
        File[] subFiles = dir.listFiles();
        for (File f :
                subFiles) {
        if (f.isDirectory()){
            printFile(f);
        }else{
            System.out.println(f.getAbsolutePath());
        }

        }
    }

    // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    // 建议使用File类的File[] listFiles()
    public void listAllSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            File[] all = file.listFiles();
            // 如果all[i]是文件，直接打印
            // 如果all[i]是目录，接着再获取它的下一级
            for (File f : all) {
                listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
            }
        }
    }
    @Test
    public void test (){
        File f = new File("G:\\Music");
        listAllSubFiles(f);
        System.out.println(getDirectorySize(f));
    }

    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] all = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);// f的大小;
            }
        }
        return size;
    }

    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {// f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
//        file.delete();
    }
}
