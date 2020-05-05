package oop.recursion;

/**
 * @author wuyuan
 * @create 2020-04-02 23:01
 */
        public class Fibonacci {

            public static void main(String[] args) {
                int a = fibonacci(5);
                System.out.println(a);
    }
    public static int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        if (n > 2){
            return fibonacci(n - 1) + fibonacci(n-2);
        }
        return -1;
    }

}