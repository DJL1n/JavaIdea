package basics;

import java.util.Scanner;

public class Example2_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        double sum=0;
        double x=reader.nextDouble();
        while(x!=0){
            sum+=x;
            x=reader.nextDouble();

        }
        System.out.printf("sum=%10.5f\n", sum);
    }
}
