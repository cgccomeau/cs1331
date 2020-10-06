import java.util.Scanner;
import java.io.File;

/**
 * This is my hw1 class file
 * that organizes grades
 * @author Charlie Comeau
 * @version 23456789
 */
public class Histogram {

    /**
    * The main method of this Histogram program
    * is to take input data from grades.csv and
    * create a visual histogram of grades with n bins,
    * n being determined by the user's input.
    * @param args inputs grades.csv and number of bins,
    * if given by user
    */
    public static void main(String[] args) throws Exception {
        File f = new File(args[0]);
        Scanner s = new Scanner(System.in);
        Scanner t = new Scanner(f);
        int bins;
        if (args.length < 2) {
            System.out.println("How many bins would you like?");
            bins = s.nextInt();
        } else {
            bins = Integer.parseInt(args[1]);
        }

        int[] num = new int[bins];
        int range = 101 / bins;
        int top = 100;
        int bottom = top - range + 1;
        int dif = 101 - bins;

        while (t.hasNext()) {
            String[] parts = t.nextLine().split(",");
            int current = Integer.parseInt(parts[1].replaceAll(" ", ""));
            int k = 0;
            for (int i = bins; i > 0 && bottom >= 0; i--) {
                if (bottom < range || (bins > 50 && top <= dif)) {
                    bottom = 0;
                }
                if (k == num.length - 1) {
                    bottom = 0;
                }
                if (current <= top && current >= bottom) {
                    num[k]++;
                    break;
                }
                top -= range;
                bottom -= range;
                k++;
            }
            top = 100;
            bottom = top - range + 1;
        }

        /*for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]); //diagnostic
        }*/
        int k = 0;
        //System.out.println(); // diagnostic

        for (int i = bins; ((i > 0) && (bottom >= 0)); --i) {
            if (bottom < range || (bins > 50 && top <= dif)) {
                bottom = 0;
            }
            if (k == num.length - 1) {
                bottom = 0;
            }
            System.out.printf("%3d - %2d | ", top, bottom);
            while (num[k] > 0) {
                System.out.print("[]");
                num[k]--;
            }
            top -= range;
            bottom -= range;
            System.out.println();
            k++;
        }
        s.close();
        t.close();
    }
}