package third;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Manager manager=new Manager(scanner.next(),scanner.nextDouble(),scanner.nextInt());
        Seller seller=new Seller(scanner.next(),scanner.nextDouble(),scanner.nextInt(),scanner.nextDouble());
        double totalSalaries=SalaryService.getTotalSalaries(manager,seller);
        System.out.printf("薪资总额: %.2f", totalSalaries);
    }


}

interface Workable{
    abstract void updateName(String s);
    abstract double calculateSalary();
}

class Employee implements Workable{
    String name;
    double basicSalary;

    @Override
    public void updateName(String s) {
        name=s;
    }
    @Override
    public double calculateSalary() {
        return basicSalary;
    }
}

class Manager extends Employee{
    int level;

    public Manager(String name, double basicSalary, int level) {
        this.name=name;
        this.level = level;
        this.basicSalary = basicSalary;
    }

    @Override
    public double calculateSalary() {
        return basicSalary*level*0.8;
    }
}
class Seller extends Employee{
    int sale;
    double royalty;

    public Seller(String name, double basicSalary, int sale, double royalty) {
        this.name=name;
        this.sale = sale;
        this.basicSalary = basicSalary;
        this.royalty = royalty;
    }

    @Override
    public double calculateSalary() {
        return basicSalary+sale*royalty;
    }
}

class SalaryService{
    public static double getTotalSalaries(Manager manager,Seller seller){
        return manager.calculateSalary()+seller.calculateSalary();
    }
}