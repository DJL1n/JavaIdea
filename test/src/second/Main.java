package second;

import java.util.Scanner;

class User{
    String name,addr;
    double account;
    User(String name,double account,String addr){
        this.name=name;
        this.account=account;
        this.addr=addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}

class Product{
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Item {
    Product product;
    int num;

    public Item(Product product, int num) {
        this.product = product;
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class Order{
    User user;
    Item[] items;
    double cost;

    public Order(User user, Item[] items, double cost) {
        this.user = user;
        this.items = items;
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

class OrderService {
    static Order addOrder(User user, Item[] items) {
        double totalCost=0.0;
        for (Item item : items) {
            totalCost+=item.num*item.product.price;
        }
        if (user.account>=totalCost){
            return new Order(user,items,totalCost);
        }else{
            return null;
        }
    }

}
public class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String userName=scanner.next();
        double acount=scanner.nextDouble();
        String addr=scanner.next();
        User user=new User(userName,acount,addr);

        Product p1 = new Product("方便面", 5.5);
        Product p2 = new Product("火腿肠", 2.2);
        Product p3 = new Product("矿泉水", 1.0);
        Product p4 = new Product("饮料", 3.5);

        Product[] products={p1,p2,p3,p4};

        int n=scanner.nextInt();
        Item[] items=new Item[n];
        for (int i = 0; i < n; i++) {
            String product=scanner.next();
            int num=scanner.nextInt();
            for (Product product1 : products) {
                if (product.equals(product1.name)){
                    items[i]=new Item(product1,num);
                    break;
                }
            }
        }
        Order order=OrderService.addOrder(user,items);

        if (order != null) {
            System.out.printf("购买商品总额：%.2f\n", order.getCost());
            System.out.printf("用户余额：%.2f\n", user.getAccount());
            System.out.println("地址：" + user.getAddr());
        } else {
            System.out.println("用户余额不足");
        }
    }


}
