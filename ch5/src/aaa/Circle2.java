package aaa;

public class Circle2 extends Geometry{
    double r;
    Circle2(double r){
        this.r=r;
    }
    public double getArea(){
        return (3.14*r*r);
    }
}
