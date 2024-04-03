public class Example8_1 {
    public static void main(String[] args) {
        String hello="你好";
        String testOne="你"+"好";
        int address =System.identityHashCode("你好");
        System.out.println("你好的引用" + address);
        address=System.identityHashCode(hello);
        System.out.println("hello的引用" + address);
        address=System.identityHashCode(testOne);
        System.out.println("testOne的引用" + address);
        System.out.println(hello == testOne);
        System.out.println("你好" == testOne);
        System.out.println("你好" == hello);
        String you="你";
        String hi="好";
        String testTwo=you+hi;
        address=System.identityHashCode(testTwo);
        System.out.println("testTwo的引用" + address);
        System.out.println(hello == testTwo);
    }
}
