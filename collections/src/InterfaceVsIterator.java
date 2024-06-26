import pets.Pet;
import pets.PetCreator;

import java.util.*;

public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it){
        while(it.hasNext()){
            Pet pet=it.next();
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
    }
    public static void display(Collection<Pet> pets){
        for (Pet pet : pets) {
            System.out.print(pet.id() + ":" + pet + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList=new PetCreator().list(8);
        Set<Pet> petSet=new HashSet<>(petList);
        Map<String,Pet> petMap=new LinkedHashMap<>();
        String[] names="Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy".split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i],petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator()
        );
    }
}
