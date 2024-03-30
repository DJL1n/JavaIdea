package basics;

import java.util.Scanner;

public class Example3_4 {
    public static void main(String[] args) {
        int number=0;
        System.out.println("输入正整数（回车确定）");
        Scanner scanner=new Scanner(System.in);
        number = scanner.nextInt();
        switch (number){
            case 9:
            case 131:
            case 12:
                System.out.println(number + "是三等奖");
                break;
            case 209:
            case 596:
            case 27:
                System.out.println(number + "是二等奖");
                break;
            case 875:
            case 316:
            case 59:
                System.out.println(number + "是一等奖");
                break;
            default:
                System.out.println(number + "未中奖");
        }
    }
}
