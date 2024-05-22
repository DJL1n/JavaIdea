public class RecursionFibonacci {
    IntCall fib;
    RecursionFibonacci(){
        fib=n->n==0?0:
                n==1?1:
                        fib.call(n-1)+fib.call(n-2);
    }
    int fibonacci(int n){return fib.call(n);}

    public static void main(String[] args) {
        RecursionFibonacci rf=new RecursionFibonacci();
        for (int i = 0; i < 11; i++) {
            System.out.println(rf.fibonacci(i));
        }
    }
}
