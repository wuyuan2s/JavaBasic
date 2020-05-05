package exam;

import java.util.Scanner;

/**
 *              1-n个动物选大王，按照编号每个动物只会崇拜比自己能力值高的，他们互相投票，可能投给自己或者崇拜的动物（编号越小能力值越大）
 *              input：第一行：n（n个动物），第二行：从一开始崇拜的动物，0表示没有崇拜的动物
 *              output：n行，每行是第i个动物的可能的最高票数
 * @author wuyuan
 * @create 2020-04-13 18:46
 *
 */
public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
            int[] b = a.clone();
            int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
            if(a[i] > 0 && a[i] == (k+1))
            c[k] += 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(c[i]);
        }

    }
}
