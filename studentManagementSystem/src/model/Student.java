package model;

/**
 * 学生类，用于表示学生管理系统中的一个学生。
 * 包含学生的基本信息，如ID、姓名、密码、性别、年龄和系部。
 */
public class Student {
    // 学生的ID，唯一标识一个学生
    private int id;
    // 学生的姓名
    private String name;
    // 学生的密码，用于登录系统
    private String password;
    // 学生的性别
    private String sex;
    // 学生的年龄
    private int age;
    // 学生所属的系部或学院
    private String dept;

    public Student(){}

    public Student(String name,String password){
        this.name = name;
        this.password = password;
    }

    public Student(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Student(int id,String name,String sex,int age,String dept) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String toString(){
        return name+" "+password;
    }
}
