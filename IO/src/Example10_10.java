import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Example10_10 {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream outByte=new ByteArrayOutputStream();
            byte[] byteContent="mid-autumn festival".getBytes();
            outByte.write(byteContent);
            ByteArrayInputStream inByte=new ByteArrayInputStream(outByte.toByteArray());
            byte[] backByte=new byte[outByte.toByteArray().length];

        }
        catch (IOException e){}
    }
}
