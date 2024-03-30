package aaa;

interface ShowMessage{
    void 显示商标(String s);
    default void outPutStart(){
        System.out.println("*******");
    }
}

class TV implements ShowMessage{
    public void 显示商标(String s){
        System.out.println("tvtvtv");
        System.out.println(s);
        System.out.println("vtvtvt");
    }
}

class PC implements ShowMessage{
    public void 显示商标(String s){
        System.out.println("pcpcc");
        System.out.println(s);
        System.out.println("cpcpc");
    }
}
public class Example6_2 {
    public static void main(String[] args) {
        ShowMessage sm;
        sm=new TV();
        sm.显示商标("长城牌电视机");
        sm =new PC();
        sm.显示商标("华为个人电脑");
        sm.outPutStart();
    }
}
