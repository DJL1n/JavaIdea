package src.aaa;

public class Circular {
    Circle botteom;
    double height;

    public void setBotteom(Circle botteom) {
        this.botteom = botteom;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    double getVolume(){
        if(botteom==null){
            return -1;
        }else{
            return botteom.getArea()*height/3.0;
        }
    }
    double getBottomRadius(){
        return botteom.getRadius();
    }
    public void setBottomRadius(double r){
        botteom.setRadius(r);
    }
}
