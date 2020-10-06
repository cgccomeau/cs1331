import java.util.Random;

public class Study {

    private static int TACount = 0;

    public Study() {
        this ("Josh", "Emily");
    }

    public Study(String ... names) {
        this(names.length, names);
    }

    public Study(int count, String ... names) {
        TACount = count;
        for(String s: names) {
            System.out.println(s);
        }
    }


    public static void main(String... args) {
        Study i = new Study();
        String it[][] = new String[2][2];
        System.out.println(i.TACount);
        for(String a: args) {
            System.out.println(a);
        }


    }
}