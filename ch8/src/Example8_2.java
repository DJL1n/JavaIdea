public class Example8_2 {
    public static void main(String[] args) {
        String s1,s2;
        s1=new String("天道酬勤");
        s2=new String("天道酬勤");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("二者的实体相同吗" + s1.equals(s2));
        int address1=System.identityHashCode(s1);
        int address2=System.identityHashCode(s2);
        System.out.println("String对象s1和s2的引用分别是" + address1 + "," + address2);
        System.out.println("二者的引用相同吗" + s1 == s2);
        String s3,s4;
        s3="we are students";
        s4=new String("we are student");
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("二者实体相同吗" + s3.equals(s4));
        int address3=System.identityHashCode(s3);
        int address4=System.identityHashCode(s4);
        System.out.printf("String对象s3和s4的引用分别是%x,%x\n",address3,address4);
        System.out.println("二者引用相同吗" + s3 == s4);

    }
}
