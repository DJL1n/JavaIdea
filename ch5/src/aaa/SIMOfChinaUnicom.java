package src.aaa;

public class SIMOfChinaUnicom extends SIM{
    String number;
    public void setNumber(String a){
        number=a;
    }
    public String giveNumber(){
        return number;
    }
    public String giveCorpName(){
        return "中国联通";
    }

}
