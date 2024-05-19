import java.util.Arrays;

public class ArrayIsNotIteratable {
    static <T> void test(Iterable<T> ib){
        for (T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,2,3));
        String[] strings={"A","B","C"};
//        test(strings);
//        不支持数组
        test(Arrays.asList(strings));
    }
}
