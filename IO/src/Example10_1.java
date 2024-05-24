import java.io.File;
import java.io.IOException;

public class Example10_1 {
    public static void main(String[] args) {
        File f=new File("E:\\临时\\软件学习\\JavaIdea\\IO\\src\\Example10_1.java");
        System.out.println(f.canRead());
        System.out.println(f.length());
        System.out.println(f.getAbsoluteFile());
        File file =new File("new.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
                System.out.println(file.getName());
            }catch (IOException e){
        }
    }
}
