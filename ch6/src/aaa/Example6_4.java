package aaa;

abstract class MotorVehicles{
    abstract void brake();
}
interface MoneyFare{
    void charge();
}
interface ControlTemperature{
    void controlAirTemperature();
}
class Bus extends MotorVehicles implements MoneyFare{
    void brake(){
        System.out.println("公交汽车使用毂式刹车技术");
    }
    public void charge(){
        System.out.println("公交汽车：一元/张，不计算公里数");
    }
}
class Taxi extends MotorVehicles implements MoneyFare,ControlTemperature{
    void brake(){
        System.out.println("出租车使用盘式刹车方法");
    }
    public void charge(){
        System.out.println("出租车：2元/公里,起价3公里");
    }
    public void controlAirTemperature(){
        System.out.println("出租车安装了hair空调");
    }
}
class Cinema implements MoneyFare,ControlTemperature{
    @Override
    public void charge() {
        System.out.println("电影院：门票，10元/张");
    }

    @Override
    public void controlAirTemperature() {
        System.out.println("电影院安装了中央空调");
    }
}
public class Example6_4 {
    public static void main(String[] args) {
        Bus bus101 = new Bus();
        Taxi bluetaxi=new Taxi();
        Cinema cinema=new Cinema();
        MoneyFare fare;
        ControlTemperature controlTemperature;
        fare=bus101;
        bus101.brake();
        fare.charge();
        fare=bluetaxi;
        controlTemperature=bluetaxi;
        bluetaxi.brake();
        fare.charge();
        controlTemperature.controlAirTemperature();
        fare=cinema;
        controlTemperature=cinema;
        fare.charge();
        controlTemperature.controlAirTemperature();
    }
}
