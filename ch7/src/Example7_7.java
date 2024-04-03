public class Example7_7 {
    public static void main(String[] args) {
        int [] sccore={-120,98,89,120,99};
        int sum=0;
        for (int i : sccore) {
            assert i>=0:"负数不能是成绩";
            sum+=i;
        }
        System.out.println(sum);
    }
}
