public class Shrek extends Onion {
    public int stinkyLevel = 100;
    public Shrek() {
        System.out.println("Ogres are like Onions");
    }

    public int getStinkyLevel() {
        return stinkyLevel;
    }

    public String action() {
        return "ROAR";
    }

    public static void test() {
        System.out.println("early mornings");
    }
}