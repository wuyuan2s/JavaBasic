package employeetest;

/**
 * @author wuyuan
 * @create 2020-04-22 19:29
 *
 *  * MyDate类包含:
 *  private成员变量year,month,day；并为每一个属性定义 getter, setter 方法；
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        //比较年
        int comYear = this.getYear() - o.getYear();
        if(comYear != 0){
            return comYear;
        }
        //比较月
        int comMonth = this.getMonth() - o.getMonth();
        if (comMonth != 0){
            return comMonth;
        }
        //比较日
        return this.getDay() - o.getDay();

    }
}
