import pets.*;
import java.util.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets=new PetCreator().list(12);
        Iterator<Pet> it=pets.iterator();
        while(it.hasNext()){
            Pet p=it.next();
            System.out.println(p.id()+":"+p+" ");
        }
        System.out.println();
        // 如果情况允许的话，这种方式更简单：
        for (Pet p : pets) {
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
        //迭代器也可以用来删除元素
        it=pets.iterator();
        for (int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets
        );
    }
}
