package aaa;

public class Example6_3 {
    public static void main(String[] args) {
        ShowMessage sm;
        sm=(s)->{
            System.out.println("tvtvvt");
            System.out.println(s);
            System.out.println("tvtvvt");
        };
        sm.显示商标("长城牌电视");

        sm =(s)->{
            System.out.println("pcpcpc");
            System.out.println(s);
            System.out.println("pcpcp");
        };

        sm.显示商标("华为个人电脑");
    }
}
