import java.util.Scanner;
import java.io.File;

public class Eval {

    public static void process(String line) {
        System.out.println(line);
    }

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            process(line);
        }
    }
}