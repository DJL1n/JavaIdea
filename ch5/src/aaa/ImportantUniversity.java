package src.aaa;

public class ImportantUniversity extends University {
    void enterRule(double math,double english,double chinese){
        double total = math+english+chinese;
        if(total>=220){
            System.out.println(total+"达到重点大学录取线");
        }else{
            System.out.println(total + "未达到重点大学录取线");
        }
    }
}
