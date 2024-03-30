package src.aaa;

class 类人猿{
    void crySpeak(String s){
        System.out.println(s);
    }
}

class Human extends 类人猿{
    void computer(int a,int b){
        int c=a*b;
        System.out.println(c);
    }

    void crySpeak(String s){
        System.out.println("***" + s + "***");
    }
}
public class Example5_10 {
    public static void main(String[] args) {
        类人猿 monkey;
        Human geng=new Human();
        System.out.println(geng instanceof Human);
        monkey=geng;
        System.out.println(monkey instanceof Human);
        System.out.println(geng.getClass());
        monkey.crySpeak("I love this game");
        Human human=(Human)monkey;
        human.computer(10,10);
    }
}
