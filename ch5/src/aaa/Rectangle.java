package aaa;

public class Rectangle extends Geometry{
    double a,b;
    Rectangle(int a,int b){
        this.a=a;
        this.b=b;
    }
    public double getArea(){
        return a*b;
    }
}
