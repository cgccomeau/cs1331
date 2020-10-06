public class Onion {
    public int stinkyLevel = 30;
    public Onion() {
        System.out.println("I am layered");
    }

    public String action() {
        return "stink";
    }

    public int getStinkyLevel() {
        return stinkyLevel;
    }

    public static void test() {
        System.out.println("late nights");
    }
}