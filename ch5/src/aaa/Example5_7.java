package src.aaa;

class Sum{
    int n;
    float f(){
        float sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }
}

class Average extends Sum{
    int n;
    float f(){
        float c;
        super.n=n;
        c=super.f();
        return c/n;
    }

    float g(){
        float c;
        c=super.f();
        return c/2;
    }
}
public class Example5_7 {
    public static void main(String[] args) {
        Average average=new Average();
        average.n=100;
        float resultTwo=average.g();
        float resultOne=average.f();
//        float resultTwo=average.g();
        System.out.println("resultOne = " + resultOne);
        System.out.println("resultTwo = " + resultTwo);
    }
}
