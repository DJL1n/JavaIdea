package src.aaa;

public class Example4_9 {
    public static void main(String[] args) {
        SIM simOne=new SIM(13889776509L);
        MobileTelephone mobileTelephone=new MobileTelephone();
        mobileTelephone.setSim(simOne);
        System.out.println("手机号码" + mobileTelephone.lookNumber());
        SIM simTwo=new SIM(15967563567L);
        mobileTelephone.setSim(simTwo);
        System.out.println("手机号码" + mobileTelephone.lookNumber());
    }
}
