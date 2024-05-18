import pets.*;
import java.util.*;

public class MapOfList {
    public static final Map<Person, List<?extends Pet>> petPeople= new HashMap<>();
    static {
        petPeople.put(new Person("Dawn"),Arrays.asList(
                new Cymric("molly"),
                new Mutt("spat")
        ));
        petPeople.put(new Person("Kate"),Arrays.asList(
                new Cat("Shackleton"),
                new Cat("Elsie May"),
                new Dog("Margrett")
        ));
        petPeople.put(new Person("Marilyn"),Arrays.asList(
                new Pug("Louie aka Louis Snorkelstein Dupree"),
                new Cat("Stanford"),
                new Cat("pinkola")
        ));
        petPeople.put(new Person("Luke"),Arrays.asList(
                new Rat("Fuzzy"),
                new Rat("Fizzy")
        ));
        petPeople.put(new Person("Issac"),Arrays.asList(
                new Rat("Freckly")
        ));
    }

    public static void main(String[] args) {
        System.out.println("petPeople.keySet() = " + petPeople.keySet());
        System.out.println("petPeople.values() = " + petPeople.values());
        for (Person person : petPeople.keySet()) {
            System.out.println(person + "has: ");
            for (Pet pet : petPeople.get(person)) {
                System.out.println("    " + pet);
            }
        }
    }
}
