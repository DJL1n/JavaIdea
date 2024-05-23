public class FileToWordsTest {
    public static void main(String[] args) throws Exception{
        FileToWords.stream("E:\\临时\\软件学习\\JavaIdea\\stream\\src\\FunctionMap.java")
                .limit(7)
                .forEach(s -> System.out.format("%s ",s));
        System.out.println();
        FileToWords.stream("E:\\临时\\软件学习\\JavaIdea\\stream\\src\\FunctionMap.java")
                .skip(7)
                .limit(7)
                .forEach(s -> System.out.format("%s ",s));
    }
}
