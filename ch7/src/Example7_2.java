public class Example7_2 {
    public static void main(String[] args) {
        ShowBnak showBnak=new ShowBnak();
        showBnak.showMess(new Bank() {
            @Override
            public void output() {
                money+=100;
                System.out.println("农行"+money);
            }
        });
        showBnak.showMess(new Bank(500) {
            @Override
            public void output() {
                money+=100;
                System.out.println("建行" + money);
            }
        });
    }
}
