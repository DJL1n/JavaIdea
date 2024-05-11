import pets.*;
import java.util.*;

public class CrossCollectionIteration2 {
    public static void display(Iterator<Pet> ip){
        Iterator<Pet> it=ip.iterator();
        while (it.hasNext()){
            Pet p=it.next();
            System.out.println(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets=new PetCreator().list(8);
        LinkedList<Pet> petsLL=new LinkedList<>(pets);
        HashSet<Pet> petsHS=new HashSet<>(pets);
        TreeSet<Pet> petsTS=new TreeSet<>(pets);
        display(pets);

    }
}
