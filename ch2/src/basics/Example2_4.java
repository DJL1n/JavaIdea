package basics;

public class Example2_4 {
    public static void main(String[] args) {
        int a[]={1,2,3,4};
        int b[]={100,200,300};
        System.out.println("a.length = " + a.length);
        System.out.println("b.length = " + b.length);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        int address=System.identityHashCode(a);
        int address2=System.identityHashCode(b);
        a=b;
        int address3=System.identityHashCode(a);
        System.out.println(address == address2);
        System.out.println(address2 == address3);
        char aaa[]={'a','b','c'};
        System.out.println(aaa);
        System.out.println(""+aaa);
    }
}
