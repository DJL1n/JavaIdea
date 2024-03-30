package src.aaa;

public class MobileTelephone {
    SIM sim;
    void setSim(SIM card){
        sim=card;
    }
    long lookNumber(){
        return sim.getNumber();
    }
}
