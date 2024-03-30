package aaa;

public class SIMOfChinaMobile extends SIM {
    String number;
    public void setNumber(String a){
        number=a;
    }
    public String giveNumber(){
        return number;
    }
    public String giveCorpName(){
        return "中国移动";
    }
}
