import pets.*;
import java.util.*;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets=new LinkedList<>(new PetCreator().list(5));
        System.out.println(pets);
        //完全相同
        System.out.println("pets.getFirst():" + pets.getFirst());
        System.out.println("pets.element():" + pets.element());
        //仅当列表为空时存在区别
        System.out.println("pets.peek() = " + pets.peek());
        //完全相同；移除并返回第一个元素
        System.out.println("pets.remove() = " + pets.remove());
    }
}
