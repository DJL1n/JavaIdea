
public class ForEach {
    static final int SZ=14;

    public static void main(String[] args) {
        RandInts.rands().limit(SZ)
                .forEach(n->System.out.format("%d ",n));
        System.out.println();
        RandInts.rands().limit(SZ)
                .parallel()
                .forEach(n->System.out.format("%d ",n));
        System.out.println();
        RandInts.rands().limit(SZ)
                .parallel()
                .forEachOrdered(n->System.out.format("%d ",n));
    }
}
