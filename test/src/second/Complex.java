package second;

import java.util.Scanner;

public class Complex {
    int a, b;

    Complex() {
        a=0;
        b=0;
    }

    Complex(Complex other) {
        this.a = other.a;
        this.b = other.b;
    }

    void add(Complex other) {
        this.a+=other.a;
        this.b+=other.b;
    }

    void sub(Complex other){
        this.a-=other.a;
        this.b-=other.b;
    }

    void printComplex(){
        if (this.a==0 && this.b==0){
            System.out.println(0);
        }else{
            System.out.println(this.a + " " + this.b + "i");
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Complex c1=new Complex();
        Complex c2=new Complex();
        c1.a=scanner.nextInt();
        c1.b=scanner.nextInt();
        Complex c3=new Complex(c1);
        c2.a=scanner.nextInt();
        c2.b=scanner.nextInt();
        c1.add(c2);
        c1.printComplex();
        c3.sub(c2);
        c3.printComplex();
    }
}