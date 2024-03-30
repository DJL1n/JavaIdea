package second;

import java.util.Scanner;

class Student{
    String sNO,sName;
    int sJava;
    Student(String a,String b,int c){
        sNO=a;
        sName=b;
        sJava=c;
    }

    String getsNO() {
        return sNO;
    }

    void setsNO(String sNO) {
        this.sNO = sNO;
    }

    String getsName() {
        return sName;
    }

    void setsName(String sName) {
        this.sName = sName;
    }

    int getsJava() {
        return sJava;
    }

    void setsJava(int sJava) {
        this.sJava = sJava;
    }


}
public class Score {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Student[] students=new Student[n];
        for (int i = 0; i < n; i++) {
            String no=scanner.next();
            String name=scanner.next();
            int java=scanner.nextInt();
            students[i]=new Student(no,name,java);
        }
        System.out.println(getHigh(students));

    }
    public static int getHigh(Student[] students){
        int max_score=0;
        int n=students.length;
        for (int i = 0; i < n; i++) {
            if (students[i].sJava>max_score){
                max_score=students[i].sJava;
            }
        }
        return max_score;
    }
}
