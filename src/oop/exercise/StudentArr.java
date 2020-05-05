package oop.exercise;

public class StudentArr {

    public static void main(String[] args) {
        //Student[] student：这里声明了一个类类型的数组，属于引用类型的数组
        Student[] student = new Student[20];
        for (int i = 0; i < 20; i++) {
            student[i] = new Student();
            student[i].number = i + 1;
            System.out.println();
            //使用Math.random生成随机数时返回值为double型，且范围是0.0~1.0
            //所以当需要生成 a~b 的随机数公式为：(int)(Math.random() * (b - a + 1) + a);
            student[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
            student[i].score = (int) (Math.random() * (100 - 0 + 1) + 0);

//            如果看Math的random方法的实现代码的话，就会发现，该方法就是调用的Random类的nextDouble()方法。
//            因为Math类的random方法使用较方便，不需要导包、创建对象，所以许多人习惯于使用该方法。
            System.out.println(student[i].score);
            System.out.println("hello World");
            System.out.println(student[i].toString());
            System.out.println(1);
            


        }
    }
}
    class Student{
        int number;
        int state;
        int score;

        @Override
        public String toString() {
            return "Student{" +
                    "number=" + number +
                    ", state=" + state +
                    ", score=" + score +
                    '}';
        }
    }
