import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;

public class Trooper {
    private String name;
    private boolean mustached;
    public Trooper(String name, boolean hasMustache) {
        this.name = name; mustached = hasMustache;
    }
    public String getName() { return name; }
    public boolean hasMustache() { return mustached; }
    public boolean equals(Object other) {
        if (this == other) return true;
        if (null == other || !(other instanceof Trooper)) return false;
        Trooper that = (Trooper) other;
        return this.name.equals(that.name) && this.mustached == that.mustached;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + (mustached ? 1 : 0);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Trooper> troopers= new ArrayList<>();
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Farva", true));
        troopers.add(new Trooper("Rabbit", false));
        troopers.add(new Trooper("Mac", true));

        Set<Trooper> trooperSet = new HashSet<>(troopers);
        System.out.println(troopers.contains(new Trooper("Mac", true)));
        System.out.println("Practice test answer: " + trooperSet.contains(new Trooper("Mac", true)));
        System.out.println("Practice test answer: trooper.size() = " + troopers.size());
        System.out.println("trooperSet.size() = " + trooperSet.size());
        Set<String> stringSet = new HashSet<>(Arrays.asList("meow", "meow"));
        System.out.println(stringSet.size());

        System.out.println("\ntrooperSet:");
        for(Trooper t: trooperSet) {
            System.out.println(t.getName() + ", " + t.hasMustache());
        }

        System.out.println("\nBefore sorting");
        for(Trooper t: troopers) {
            System.out.println(t.getName() + ", " + t.hasMustache());
        }

        Collections.sort(troopers, new Comparator<Trooper>() {
            public int compare(Trooper a, Trooper b) {
                if (a.hasMustache() && !b.hasMustache()) {
                    return 1;
                } else if (b.hasMustache() && !a.hasMustache()) {
                    return -1;
                } else {
                    return a.getName().compareTo(b.getName());
                }
            }
        });

        System.out.println("\nAfter Sorting");
        for(Trooper t: troopers) {
            System.out.println(t.getName() + ", " + t.hasMustache());
        }
    }
}