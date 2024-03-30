package aaa;


class Student2{
    int number;String name;
    Student2(){

    }

    Student2(int number,String name){
        this.number=number;
        this.name=name;
        System.out.println("我的名字是：" + name + "学号是" + number);
    }
}

class UniverStudent2 extends Student2{
    boolean 婚否;
    UniverStudent2(int number,String name,boolean b){
        super(number,name);
        婚否=b;
        System.out.println("婚否 = " + 婚否);
    }
}

public class Example5_8{
    public static void main(String[] args) {
        UniverStudent2 zhang=new UniverStudent2(9901,"何小丽",false);
    }
}

