package aaa;

interface SpeakHello{
    void speakHello();
}

class Chinese implements SpeakHello{
    @Override
    public void speakHello() {
        System.out.println("你好吃饭了吗");
    }
}
class English implements SpeakHello{
    @Override
    public void speakHello() {
        System.out.println("你好天气不错");
    }
}

class KindHello{
    public void lookhello(SpeakHello hello){
        hello.speakHello();
    }
}

public class Example6_6 {
    public static void main(String[] args) {
        KindHello a=new KindHello();
        Chinese cc=new Chinese();
        a.lookhello(cc);
        a.lookhello(new English());
        a.lookhello(()->{
            System.out.println("no bug");
        });
    }
}
