public class Test0416 {
    public static void main(String[] args) {
        // contains
        String tom="student";
        System.out.println(tom.contains("stu"));

        //index &&lastindex
        tom = "I am a good cat";
        tom.indexOf("a");
        tom.indexOf("good",2);
        tom.indexOf("a",7);
        tom.indexOf("w",2);

        //针对转义字符\
        String path="C:\\book\\Java Programmer.doc";
        int indexOne=path.indexOf("\\");
        int indexTwo=path.lastIndexOf("\\");

        //substring
    }
}
