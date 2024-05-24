package src.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Container{
    int id,weight;

    public Container(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Ship{
    int id;
    String name;
    int maxWeight;
    int realWeight=0;
    List<Container> containers=new ArrayList<>();

    public Ship(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.maxWeight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getRealWeight() {
        return realWeight;
    }

    public void setRealWeight(int realWeight) {
        this.realWeight = realWeight;
    }

    public void add(Container container){
        containers.add(container);
    }

    public List<Container> getContainers() {
        return containers;
    }
}

class LoadService{
    public static Ship loadShip(Ship ship, List<Container> containers)
            throws OverWeightException {
        int sum =containers.stream().mapToInt(i->i.getWeight()).sum();
        ship.setRealWeight(sum);
        if (ship.getMaxWeight()<ship.getRealWeight()) throw new OverWeightException();
        return ship;
    }

}

class OverWeightException extends Exception{
    public String warnMess(Ship ship){
        return "超重："+ (double)(ship.getRealWeight()-ship.getMaxWeight());
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Ship ship=new Ship(scanner.nextInt(),scanner.next(),scanner.nextInt());
        int group=scanner.nextInt();
        for (int i = 0; i < group; i++) {
            int containerNum=scanner.nextInt();
            try {
                for (int j = 0; j < containerNum; j++) {
                    ship.add(new Container(scanner.nextInt(),scanner.nextInt()));
                }
                LoadService.loadShip(ship,ship.getContainers());
            }catch (OverWeightException e){
                System.out.println("货船ID："+ship.getId()+"；货船名称："
                        +ship.getName()+"；"+e.warnMess(ship));
            }finally {
                System.out.println("货船ID："+ship.getId()+"；货船名称："
                        +ship.getName()+"；第"+(i+1)+"次货物装载完毕");
            }
        }
    }

}
