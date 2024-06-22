package model;

/**
 * 管理员类，用于表示系统中的管理员账户。
 * 包含管理员的ID、姓名和密码等属性。
 */
public class Admin {
    // 管理员的ID
    private int id;
    // 管理员的姓名
    private String name;
    // 管理员的密码
    private String password;

    public Admin(){}

    public Admin(String name,String password){
        this.name = name;
        this.password = password;
    }

    public Admin(int id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
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
    public String toString(){
        return name+" "+password;
    }
}
