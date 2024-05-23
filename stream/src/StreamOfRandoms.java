import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfRandoms {
    static Random ran=new Random(47);

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5)
                .flatMapToInt(i-> IntStream.concat(
                        ran.ints(0,100).limit(i),IntStream.of(-1)
                ))
                .forEach(n->System.out.format("%d ",n));
    }
}
