package src.aaa;

public class AdvertisementBoard {
    Advertisement adver;
    public void setAdvertisement(Advertisement adver){
        this.adver=adver;
    }
    public void show(){
        if(adver==null){
            System.out.println("广告招商中");
        }
        else{
            adver.showAdvertisement();
        }
    }
}
