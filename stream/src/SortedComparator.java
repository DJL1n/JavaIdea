import java.util.Comparator;

public class SortedComparator {
    public static void main(String[] args) throws Exception{
        FileToWords.stream("E:\\临时\\软件学习\\JavaIdea\\stream\\src\\RandomGenerators.java")
                .skip(21)
                .limit(4)
                .sorted(Comparator.reverseOrder())
                .peek(System.out::println)
                .map(w->w+" ")
                .forEach(System.out::println);
    }
}
