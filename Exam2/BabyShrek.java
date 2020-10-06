public class BabyShrek extends Shrek {
    public int stinkyLevel = 80;
    public int getStinkyLevel() {
        return stinkyLevel;
    }

    public String action() {
        return "roar";
    }

        public static void main(String[] args) {
        System.out.println();
        BabyShrek baby = new BabyShrek();
        Shrek shrek = new Shrek();
        Onion onion = new Onion();
        Onion mark = new Shrek();
        Shrek chosen = new BabyShrek();
        System.out.println();
        Onion[] onions = {onion, shrek, baby};
        for(int i = 0; i < onions.length; i++) {
            System.out.println(onions[i].stinkyLevel + onions[i].getStinkyLevel());
        }
        System.out.println();
        System.out.println(baby.getStinkyLevel());
        System.out.println(((Shrek)baby).getStinkyLevel());
        System.out.println(((Onion)baby).action());
        //System.out.println(((BabyShrek)onion).getStinkyLevel());
        System.out.println();
        System.out.println(onion instanceof Shrek);
        System.out.println();
        System.out.println(chosen instanceof Shrek);
        System.out.println(mark instanceof Shrek);
        mark.test();
        chosen.test();
        baby.test();
    }
}