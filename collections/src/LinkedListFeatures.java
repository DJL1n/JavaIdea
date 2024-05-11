import pets.*;
import java.util.*;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets=new LinkedList<>(new PetCreator().list(5));
        System.out.println(pets);
        //完全相同
        System.out.println("pets.getFirst():" + pets.getFirst());
    }
}
