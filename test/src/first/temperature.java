package first;

import java.util.Scanner;

public class temperature {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        double f=reader.nextDouble();
        double c=5*(f-50)/9+10;
        System.out.printf("The temprature is %.2f.", c);
    }
}
