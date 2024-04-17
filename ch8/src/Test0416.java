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

        //substring 实质上就是切片
        String str=tom.substring(1,5);
        System.out.println(str);

        //trim 去除两边空格，得到的是一个新String
        String jerry=" iuwfheiufhew ";
        System.out.println(jerry.trim());

        //将String转化为其他数据类型
        int x;
        String s="876";
        x=Integer.parseInt(s);

        //将其他数据类型转化为String
        String str1=String.valueOf(x);
        System.out.println(str1);

        //进制表示
        String str2=Integer.toBinaryString(x);
        System.out.println(str2);
    }
}
