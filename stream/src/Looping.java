import java.text.spi.BreakIteratorProvider;



public class Looping {
    static void hi(){
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        Repeat.repeat(3,()-> System.out.println("Looping!"));
        Repeat.repeat(2,Looping::hi);
    }
}
