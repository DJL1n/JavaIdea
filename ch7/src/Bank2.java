public class Bank2 {
    private int money;
    public void income(int in, int out)throws BankException{
        if(in<=0||out>=0||in+out<=0){
            throw new BankException(in,out);
        }
        int netIncome=in+out;
        System.out.printf("本次计算出的纯收入是：%d元\n", netIncome);
        money=money+netIncome;
    }
    public int getMoney(){
        return money;
    }

}
