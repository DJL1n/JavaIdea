import pets.*;

import java.lang.reflect.Array;
import java.util.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand=new Random(47);
        List<Pet> pets=new PetCreator().list(7);
        System.out.println("l: "+pets);
        Hamster h=new Hamster();
        pets.add(h);//自动调整大小
        System.out.println("2: "+pets);
        System.out.println("3: "+pets.contains(h));
        pets.remove(h);//按对象移除
        Pet p=pets.get(2);
        System.out.println("4: "+p+" "+pets.indexOf(p));
        Pet cymric =new Cymric();
        System.out.println("5: "+pets.indexOf(cymric));
        System.out.println("6: "+pets.remove(cymric));
        //必须是类型精准匹配的对象
        System.out.println("7: "+pets.remove(p));
        System.out.println("8: "+pets);
        pets.add(3,new Mouse());//在某个索引处插入
        System.out.println("9: "+pets);
        List<Pet> sub=pets.subList(1,4);
        System.out.println("sub: "+sub);
        System.out.println("10: "+pets.containsAll(sub));
        Collections.sort(sub);//就地排序
        System.out.println("sorted subList: "+sub);
        //在containAll()中顺序并不重要
        System.out.println("11: "+pets.containsAll(sub));
        Collections.shuffle(sub,rand);//混合一下
        System.out.println("shuffled subList: "+sub);
        System.out.println("12: "+pets.containsAll(sub));
        List<Pet> copy=new ArrayList<>(pets);
        sub= Arrays.asList(pets.get(1),pets.get(4));
        System.out.println("sub="+sub);
        copy.retainAll(sub);
        System.out.println("13: "+copy);
        copy=new ArrayList<>(pets);//获得一个新副本
        copy.remove(2);//按索引移除
        System.out.println("14: "+copy);
        copy.removeAll(sub);//仅移除类型精确匹配的对象
        System.out.println("15: "+copy);
        copy.set(1,new Mouse());//替换一个元素
        System.out.println("16: "+copy);
        copy.addAll(2,sub);//在中间插入一个列表
        System.out.println("17: "+copy);
        System.out.println("18: "+pets.isEmpty());
        pets.clear();//移除所有元素
        System.out.println("19: "+pets);
        System.out.println("20: "+pets.isEmpty());
        pets.addAll(new PetCreator().list(4));
        System.out.println("21: "+pets);
        Object[] o=pets.toArray();
        System.out.println("22: "+o[3]);
        Pet[] pa=pets.toArray(new Pet[0]);
        System.out.println("23: "+ pa[3].id());
    }


}
