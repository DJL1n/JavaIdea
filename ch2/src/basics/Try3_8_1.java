package src.basics;

public class Try3_8_1 {
    public static void main(String[] args) {
        int m=1,n=2;
        System.out.println(m+"好好好"+n);
        System.out.println("xing" +
                "x");
        int mytwo[][]=new int[3][4];
        mytwo[0][0]=1;
        float boy[]={21.3f,13.6f,7.7f};
        int a[][]={{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}};
        int c[]={1,2,3},b[]={4,5};
        c=b;
        int address=System.identityHashCode(a);
        System.out.println(a);

    }
}
