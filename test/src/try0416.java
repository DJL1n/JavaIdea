package src;

public class try0416{
    public static void main(String[] args) {
        Try t=new iucwiu();
        int a=10,b=20,c=15;
        int max=a>b?(a>c?a:c):(b>c?b:c);
        System.out.println(max);

    }
}

class Try {
    int a=10;
}

class iucwiu extends Try{
    int a=100;
    void print(){
        System.out.println(this.a);}

}
