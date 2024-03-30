package src.basics;

import java.util.Scanner;

public class Example3_9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double sum=0;
        int m=0;
        while (scanner.hasNextDouble()){
            double x =scanner.nextDouble();
            m+=1;
            sum+=x;

        }
        System.out.printf("%d个数的和为%f\n",m,sum);
        System.out.printf("%d个数的平均值是%f\n",m,sum/m);
    }
}
