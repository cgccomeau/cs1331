import java.util.Arrays;

public class TestAgain {
    public static void main(String[] args) {
        MyList<Integer> money = new MyList<>();
        for(int i = 0; i < 5; i++) {
            money.add(i);
        }
        Integer[] dagger = new Integer[11];
        for(int i = 0; i < 11; i++) {
            dagger[i] = i;
        }
        System.out.println(Arrays.toString(dagger));
        Integer[] chief = money.toArray(dagger);
        Integer[] aintIt = money.toArray(new Integer[3]);
        System.out.println(Arrays.toString(chief));
        System.out.println(Arrays.toString(aintIt));

    }
}