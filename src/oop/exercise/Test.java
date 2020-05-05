package oop.exercise;

/**
 * @author wuyuan
 * @create 2020-04-01 22:32
 */
import java.util.Scanner;
public class Test {

        public static void main(String[] args) {
            int N, L;
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            L = sc.nextInt();

            for (int i = L; i <= 100; i++) {
                if ((2 * N + i - i * i) % (2 * i) == 0) {
                    int start = (2 * N + i - i * i) / (2 * i);
                    for (int j = 0; j < i - 1; j++) {
                        System.out.print(start + j + " ");
                    }
                    System.out.print(start + i - 1);
                    return;
                }
                }
            System.out.println("no");

        }

        }
