import java.util.zip.DataFormatException;

public class CargoBoat {
    int realContent;
    int maxCount;
    public void setRealContent(int c){
        maxCount=c;
    }

    public void loading(int m) throws DangerException{
        realContent+=m;
        if (realContent>maxCount){
            throw new DangerException();
        }
    }
}
