import java.util.ArrayList;

public class Doberman {
    private static int dobieCount = 0;
    private String name;

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Doberman)) return false;
           return ((Doberman) other).name.equals(this.name);
        // return this.name.equals(other.name);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Doberman> daringDobermans = new ArrayList();
        daringDobermans.add(new Doberman("Chloe"));
        System.out.println(daringDobermans.contains(new Doberman("Chloe")));
    }
}