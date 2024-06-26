import java.util.*;
import java.util.stream.*;

class Numbered{
    final int n;
    Numbered(int n){this.n=n;}
    public String toString(){
        return "Numbered("+n+")";
    }
}

public class FunctionMap2 {
    public static void main(String[] args) {
        Stream.of(1,5,7,9,11,3)
                .map(Numbered::new)
                .forEach(System.out::println);
    }

}
