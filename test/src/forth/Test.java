package src.forth;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int id =scanner.nextInt();
//        String sex=scanner.next();
//        Student.Sex Sex=sex.equals("女")?Student.Sex.FEMALE:Student.Sex.MALE;
//        String name = scanner.next();
//        int year=scanner.nextInt();
//        Student student=new Student(id,Sex,name,year);
//        StudentService studentService=new StudentServicelmpl();
//        studentService.addStudent(student).forEach(System.out::println);
//    }
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        StudentService studentService=new StudentServicelmpl();
//        studentService.listStudentsByYear(scanner.nextInt()).forEach(System.out::println);
//    }
    //public static void main(String[] args) {
    //    Scanner scanner=new Scanner(System.in);
    //    int year=scanner.nextInt();
    //    Student.Sex sex=scanner.next().equals("女")? Student.Sex.FEMALE: Student.Sex.MALE;
    //    StudentService studentService=new StudentServicelmpl();
    //    studentService.listStudentsNames(year,sex).forEach(System.out::println);
    //}
//public static void main(String[] args) {
//    StudentService studentService=new StudentServicelmpl();
//    Map<Student.Sex,List<Student>> map=studentService.mapStudentsBySex();
//    System.out.println("女");
//    map.get(Student.Sex.FEMALE).forEach(System.out::println);
//    System.out.println("男");
//    map.get(Student.Sex.MALE).forEach(System.out::println);
//}
public static void main(String[] args) {
    StudentService studentService=new StudentServicelmpl();
    Scanner scanner=new Scanner(System.in);
    studentService.removeStudent(scanner.nextInt());
}
}


class Student {
    public enum Sex {
        MALE, FEMALE
    }

    private int id;
    private Sex sex;
    private String name;
    private int year;

    public Student(int id, Sex sex, String name, int year) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
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


    @Override
    public String toString() {
        String s = "女";
        if(sex == Sex.MALE)
            s = "男";
        return "Student{" +
                "id=" + id +
                ", sex=" + s +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}



class  DatabaseUtils {

    private static final List<Student> STUDENTS = create();

    private static List<Student> create() {

        List<Student> students = new ArrayList<>();

        students.add(new Student(201001, Student.Sex.FEMALE, "赵阳阳", 2010));

        students.add(new Student(201002, Student.Sex.MALE, "邵鹏", 2010));

        students.add(new Student(201103, Student.Sex.MALE, "高学斌", 2011));

        students.add(new Student(201104, Student.Sex.MALE, "张扬", 2011));

        students.add(new Student(201205, Student.Sex.FEMALE, "吕惠玲", 2012));

        students.add(new Student(201206, Student.Sex.MALE, "曾志优", 2012));


        return students;
    }

    public static List<Student> getStudents() {
        return STUDENTS;
    }

}


class StudentServicelmpl implements StudentService{
    private List<Student> studentList = DatabaseUtils.getStudents();

    @Override
    public List<Student> addStudent(Student student) {
        studentList.add(student);
        return studentList;
    }

    @Override
    public List<Student> listStudentsByYear(int year) {
        return studentList.stream().filter(student -> student.getYear()==year)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return studentList.stream().filter(student -> student.getYear()==year)
                .filter(student -> student.getSex()==sex).map(Student::getName).collect(Collectors.toList());
    }

    @Override
    public Map<Student.Sex, List<Student>> mapStudentsBySex() {
        Map<Student.Sex,List<Student>> map= new HashMap<>();
        List<Student> male=new ArrayList<>();
        List<Student> female=new ArrayList<>();
        studentList.stream().filter(student -> student.getSex()==Student.Sex.MALE).forEach(male::add);
        studentList.stream().filter(student -> student.getSex()== Student.Sex.FEMALE).forEach(female::add);
        map.put(Student.Sex.MALE,male);
        map.put(Student.Sex.FEMALE,female);
        return map;
    }

    @Override
    public boolean removeStudent(int id) {
        boolean res=studentList.removeIf(student -> student.getId()==id);
        studentList.stream().forEach(System.out::println);
        return res;
    }
}



interface StudentService {
    /**
     * 向集合添加一个学生，返回当前全部学生
     * @param student
     * @return
     */
    List<Student> addStudent(Student student);
    /**
     * 返回指定届的全部学生
     * @param year
     * @return
     */
    List<Student> listStudentsByYear(int year);
    /**
     * 返回指定届，指定性别的全部学生的姓名
     * @param year
     * @param sex
     * @return
     */
    List<String> listStudentsNames(int year, Student.Sex sex);
    /**
     * 将所有学生，以性别分组
     * @return
     */
    Map<Student.Sex, List<Student>> mapStudentsBySex();
    /**
     * 删除指定学号的学生，返回是否成功删除
     * @param id
     * @return
     */
    boolean removeStudent(int id);
}
