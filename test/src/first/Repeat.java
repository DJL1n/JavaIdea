package first;

import java.util.Scanner;

public class Repeat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int repeat=scanner.nextInt();
        for (int k = 0; k < repeat; k++) {
            int a = scanner.nextInt();
            int n = scanner.nextInt();
            long sum = 0;
            for (int i = 1; i < n + 1; i++) {
                long tmp = 0;
                for (int j = 0; j < i; j++) {
                    tmp += (int) Math.pow(10, j) * a;
                }
                sum += tmp;
            }
            System.out.println(sum);
        }
    }
}
