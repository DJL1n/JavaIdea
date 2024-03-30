package aaa;

public class Application2 {
    public static void main(String[] args) {
        MobileTelephone telephone=new MobileTelephone();
        SIM sim=new SIMOfChinaMobile();
        sim.setNumber("12222");
        telephone.useSIM(sim);
        telephone.showMess();
        sim=new SIMOfChinaUnicom();
        sim.setNumber("1333");
        telephone.useSIM(sim);
        telephone.showMess();
    }
}
