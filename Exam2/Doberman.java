import java.util.ArrayList;

public class Doberman {
    private static int dobieCount = 0;
    private String name;

    public Doberman(String name) {
        this.name = name;
        dobieCount++;
    }

    public String reportDobieCount() {
        return name + " says there are " + dobieCount + " dobies.";
    }

    public boolean equals(Doberman other) {
        return this.name.equals(other.name);
    }

    public static void main(String[] args) {
        Doberman fido = new Doberman("Fido");
        Doberman chloe = new Doberman("Chloe");
        System.out.println(chloe.reportDobieCount());
        Doberman prince = new Doberman("Prince");
        ArrayList daringDobermans = new ArrayList();
        daringDobermans.add(new Doberman("Chloe"));
        daringDobermans.add(chloe);
        System.out.println(daringDobermans.contains(new Doberman("Chloe")));
        System.out.println(daringDobermans.contains(chloe));
    }
}