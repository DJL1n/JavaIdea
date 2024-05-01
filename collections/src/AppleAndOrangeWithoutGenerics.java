import java.util.*;

class Apple{
    private static long counter;
    private final long id = counter++;
    public long id(){return id;}
}

class Orange{
}

//public class AppleAndOrangeWithoutGenerics {
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        ArrayList apples=new ArrayList();
//        for (int i = 0; i < 3; i++) {
//            apples.add(new Apple());
//        }
//        apples.add(new Orange());
//        for (Object apple : apples) {
//            ((Apple)apple).id();
//        }
//    }
//}
//上面的都是Object的子类所以可以放进去，但是不能强转
//下面使用泛型的概念
public class AppleAndOrangeWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples=new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (Object apple : apples) {
            ((Apple)apple).id();
        }
    }
}