package model;

/**
 * 枚举类，用于定义系统中不同用户类型。
 * 包含系统管理员、学生和教师三种用户类型，并为每种类型赋予了特定的索引值。
 */
public enum UserType {
    // 系统管理员，索引值为0
    ADMIN("系统管理员", 0),
    // 学生，索引值为1
    STUDENT("学生", 1),
    // 教师，索引值为2
    TEACHER("教师", 2);

    // 用户类型的名称
    private String name;
    // 用户类型的索引值，用于在程序中标识不同的用户类型
    private int index;

    private UserType(String name,int index) {
        this.name=name;
        this.index=index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String toString(){
        return name;
    }
}