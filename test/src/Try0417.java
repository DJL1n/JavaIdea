package src;

class A{
    int t=2;
    double f(double m, double n){//m=4,n=5
        t=t*t;//4 //16
        return n+m+t;//13  //25
    }

    protected Object g(int a,int b){return "";}
}

class B extends A{
    int t=3;
    double f(double m,double n){//m=4,n=5
        double c=super.f(m,n);//13
        return m*n+t*super.t;//32 //68
    }

    public Integer g(int a,int b){return 0;}
}



public class Try0417 {
    public static void main(String[] args) {
       double m=4,n=5;
       B b=new B();
        System.out.println(b.f(m, n));
        System.out.println(b.f(m, n));
    }
}
