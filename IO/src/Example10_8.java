import java.io.IOException;
import java.io.RandomAccessFile;

public class Example10_8 {
    public static void main(String[] args) {
        RandomAccessFile inAndOut=null;
        int data[]={1,2,3,4,5,6,7,8,9,10};
        try {
            inAndOut=new RandomAccessFile("tom.dat","rw");
            for (int i = 0; i < data.length; i++) {
                inAndOut.writeInt(data[i]);
            }
            for (long i = data.length-1; i >= 0; i++) {
                inAndOut.seek(i*4);
                System.out.printf("\t%d",inAndOut.readInt());
            }
            inAndOut.close();
        }catch (IOException e){}
    }
}
