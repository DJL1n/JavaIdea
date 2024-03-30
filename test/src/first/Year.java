
package first;
/*
import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        int start=reader.nextInt();
        int end=reader.nextInt();
        int count=0;
        final int LINE=4;
        for (int i = start; i <= end; i++) {
            if ((i%4==0 && i%100!=0) || i%400==0) {

                System.out.print(i + " ");
                count++;
                if (count==LINE) {
                    System.out.println();
                    count = 0;
                }


            }

        }
    }
}
*/
import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // 从键盘输入两个年份
        int startYear = reader.nextInt();
        int endYear = reader.nextInt();

        // 控制每行输出的年份个数
        final int YEARS_PER_LINE = 4;

        int count = 0;

        // 输出[startYear, endYear]范围内的闰年
        for (int year = startYear; year <= endYear; year++) {
            // 判断是否是闰年的条件
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                // 输出年份并控制每行的个数
                System.out.print(year + " ");
                count++;

                // 每行输出 YEARS_PER_LINE 个年份
                if (count == YEARS_PER_LINE) {
                    System.out.println();
                    count = 0; // 重置计数器
                }
            }
        }
    }
}

