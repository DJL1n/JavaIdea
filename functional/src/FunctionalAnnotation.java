interface Functional{
    String goodbye(String arg);
}

interface FunctionalNoAnn{
    String goodbye(String arg);
}

public class FunctionalAnnotation {
    public String goodbye(String arg){
        return "Goodbye: "+arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa=new FunctionalAnnotation();
        Functional f=fa::goodbye;
        FunctionalNoAnn fna=fa::goodbye;
        Functional f1=a->"Goodbye, "+a;
        FunctionalNoAnn fnal=a->"Goodbye, "+a;
    }
}
