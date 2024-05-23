import java.util.stream.*;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1,2,3)
                .map(i->Stream.of("Gonzo","Fozzie","Beaker"))
                .map(e->e.getClass().getName())
                .forEach(System.out::println);
    }
}
