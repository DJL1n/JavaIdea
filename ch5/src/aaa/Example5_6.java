package aaa;

class A1{
    protected Object get(){
        return null;
    }
}

class B1 extends A1{
    //Integer get(){           //非法，权限不能变高
    public Integer get(){
        return new Integer(100);
    }
}
public class Example5_6 {
    public static void main(String[] args) {
        B1 b=new B1();
        Integer t=b.get();
        System.out.println(t.intValue());
    }
}
