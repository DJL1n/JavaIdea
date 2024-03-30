package aaa;

interface ComputerAverage{
    public double average(double a,double b);
}

class A implements ComputerAverage{
    @Override
    public double average(double a, double b) {
        double aver=0;
        aver=(a+b)/2;
        return aver;
    }
}

class B implements ComputerAverage{
    @Override
    public double average(double a, double b) {
        double aver=0;
        aver=Math.sqrt(a*b);
        return aver;
    }
}
public class Example6_5 {
    public static void main(String[] args) {
        ComputerAverage computerAverage;
        double a=11.23,b=22.78;
        computerAverage=new A();
        double result=computerAverage.average(a,b);
        System.out.printf("算术平均值%5.2f",result);
        computerAverage=new B();
        result=computerAverage.average(a,b);
        System.out.printf("几何平均值%5.2f",result);
    }
}
