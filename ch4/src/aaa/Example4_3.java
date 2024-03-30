package src.aaa;

class Xiyoujirenwu{
    float height,weight;
    String head,ear;
    void speak(String s){
        head="歪着头";
        System.out.println(s);
    }
}
public interface Example4_3 {
    public static void main(String[] args) {
        Xiyoujirenwu zhubajie,sunwukong;
        zhubajie=new Xiyoujirenwu();
        sunwukong=new Xiyoujirenwu();
        zhubajie.height=1.80f;
        zhubajie.head="大头";
        zhubajie.ear="一双大耳朵";
        sunwukong.height=1.62f;
        sunwukong.weight=1000f;
        sunwukong.head="秀发飘飘";
        System.out.println("zhubajie.height = " + zhubajie.height);
        System.out.println("zhubajie.head = " + zhubajie.head);
        System.out.println("sunwukong.weight = " + sunwukong.weight);
        System.out.println("sunwukong.head = " + sunwukong.head);
        zhubajie.speak("俺老猪想娶媳妇");
        System.out.println("zhubajie.head = " + zhubajie.head);
        sunwukong.speak("老孙我重1000斤，我想骗八戒背我");
        System.out.println("sunwukong.head = " + sunwukong.head);
    }
}
