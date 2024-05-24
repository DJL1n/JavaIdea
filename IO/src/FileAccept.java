import java.io.File;
import java.io.FilenameFilter;

public class FileAccept implements FilenameFilter {
    private String extendName;
    public void setExtendName(String s){
        extendName="."+s;
    }
    @Override
    public boolean accept(File file, String s) {
        return s.endsWith(extendName);
    }
}
