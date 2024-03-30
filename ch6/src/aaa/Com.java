package aaa;

public interface Com {
    int Max=100;
    void on();
    float sum(float x,float y);
    default int max(int a,int b){
        outPutJava();
        return a>b?a:b;
    }
    static void f(){
        System.out.println("注意是从Java SE 8 开始的");
    }

    private void outPutJava(){
        System.out.println("Java");
    }

}
