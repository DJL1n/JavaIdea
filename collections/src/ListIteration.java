import pets.*;
import java.util.*;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets=new PetCreator().list(8);
        ListIterator<Pet> it =pets.listIterator();
        while (it.hasNext()){
            System.out.print(it.next()+","+it.nextIndex()+","+it.previousIndex()+";");
        }
        System.out.println();
        while (it.hasPrevious()){
            System.out.print(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it=pets.listIterator(3);
        while(it.hasNext()){
            it.next();
            it.set(new PetCreator().get());
        }
        System.out.println(pets);
    }
}
