package src.Optional;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class College {
    private String name;

    public College(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Teacher {
    private int number;
    private String name;
    private College college;

    public Teacher(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
class Student {
    private int number;
    private String name;
    private int year;
    private Teacher teacher;

    public Student(int number, String name, int year) {
        this.number = number;
        this.name = name;
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
class DatabaseUtils {
    private static final List<Student> STUDENTS = create();

    private static List<Student> create() {
        College c1 = new College("信息学院");
        College c2 = new College("计控学院");

        Teacher t1 = new Teacher(1001, "吕惠玲");
        t1.setCollege(c1);
        Teacher t2 = new Teacher(1002, "曾志优");
        t2.setCollege(c2);
        Teacher t3 = new Teacher(1003, "郭晓静");


        Student s1 = new Student(202301,"赵阳阳", 2023);
        s1.setTeacher(t1);
        Student s2 = new Student(202302,"邵鹏", 2023);
        s2.setTeacher(t1);
        Student s3 = new Student(202203,"高学斌", 2022);
        s3.setTeacher(t2);
        Student s4 = new Student(202204,"张扬", 2022);
        s4.setTeacher(t2);
        Student s5 = new Student(202405,"张晓莲", 2024);
        s5.setTeacher(t3);
        Student s6 = new Student(202406,"刘静扬", 2024);
        Student s7=null;

        List<Student> students = new ArrayList<>();
        students.add(s1); students.add(s2);
        students.add(s3); students.add(s4);
        students.add(s5); students.add(s6);
        students.add(s7);
        return students;
    }

    public static List<Student> getStudents() {
        return STUDENTS;
    }



}

public class Test {
//    第一题
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int index=scanner.nextInt();
//
//        String collegeName=Optional.ofNullable(
//                DatabaseUtils.getStudents().get(index)
//        ).map(Student::getTeacher)
//                .map(Teacher::getCollege)
//                .map(College::getName)
//                .orElse(null);
//        System.out.println(collegeName==null?"未知学院":collegeName);
//    }
//    第二题
//public static void main(String[] args) {
//    Scanner scanner=new Scanner(System.in);
//    int index=scanner.nextInt();
//    String teacherName=scanner.next();
//    String tn=Optional.ofNullable(DatabaseUtils.getStudents().get(index))
//            .map(Student::getTeacher)
//            .map(Teacher::getName)
//            .orElse(null);
////    System.out.println(tn);
//    System.out.println(teacherName.equals(tn));
//
//}
//    第三题
//public static void main(String[] args) {
//    int num=new Scanner(System.in).nextInt();
//    System.out.println(
//            DatabaseUtils.getStudents().stream()
//            .filter(i->i.getNumber()==num)
//            .findFirst()
//            .map(Student::getTeacher)
//            .map(Teacher::getCollege)
//            .map(College::getName)
//            .orElse("未知学院")
//    );
//}
//    第四题
public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    int stuNum=scanner.nextInt();
    int teaNum=scanner.nextInt();
    System.out.println(
            DatabaseUtils.getStudents().stream()
            .filter(i->i.getNumber()==stuNum)
                    .findFirst()
            .map(Student::getTeacher)
                    .filter(i->i.getNumber()==teaNum)
            .map(Teacher::getCollege)
            .map(College::getName)
            .orElse("未知学院")
    );
}
}
