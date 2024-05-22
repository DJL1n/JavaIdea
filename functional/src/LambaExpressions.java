interface Description{
    String brief();
}

interface Body{
    String detailed(String head);
}

interface Multi{
    String twoArg(String head,Double d);
}

public class LambaExpressions {

    static Body bod=h -> h+"No parents";

    static Body bod2=(h)->h+"More details";

    static Description desc=()->"Short info";

    static Multi multi=(h,n)->h+n;

    static Description moreLines=()->{
        System.out.println("moreLine");
        return "from moreLine()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("oh!"));
        System.out.println(bod2.detailed("hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Pi!", 3.14159));
        System.out.println(moreLines.brief());
    }

}
