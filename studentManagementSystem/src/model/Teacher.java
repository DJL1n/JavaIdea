package model;

/**
 * 教师类，用于表示教师管理系统中的一个教师。
 * 包含教师的基本信息，如ID、姓名、密码和所教授的课程名称。
 */
public class Teacher {
    // 教师的ID，唯一标识一个教师
    private int id;
    // 教师的姓名
    private String name;
    // 教师的密码，用于登录系统
    private String password;
    // 教师所教授的课程名称
    private String TeachCourseName;

    public Teacher(){}

    public Teacher(String name,String password){
        this.name = name;
        this.password = password;
    }

    public Teacher(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Teacher(int id,String name,String password,String TeachCourseName){
        this.id = id;
        this.name = name;
        this.password = password;
        this.TeachCourseName = TeachCourseName;
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
    public String getTeachCourse() {
        return TeachCourseName;
    }
    public void setTeachCourse(String TeachCourse) {
        this.TeachCourseName = TeachCourse;
    }

    public String toString(){
        return name+" "+password;
    }
}
