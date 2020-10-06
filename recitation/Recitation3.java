import java.util.Scanner;

public class Recitation3 {

    // Scanner example
    public static void echo() {
        Scanner s = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.print("Enter your message: ");
            String input = s.next();
            if (input.equals("quit")) {
                running = false;
                System.out.println("Goodbye");
            } else {
                System.out.println(input);
            }
        }
        s.close();
    }

    public static void main(String[] args) {
        // 9-4-18 Recitation
        // switch statement example
        echo();

        char grade = 'B';
        switch (grade) {
            case('A'):
                System.out.println("Woah there genius: " + grade);
                break;
            case('B'):
                System.out.println("Great job!: " + grade);
                break;
            case ('C'):
                System.out.println("You did good, kid: " + grade);
                break;
            case ('D'):
                System.out.println("Booooo: " + grade);
                break;
            default:
                System.out.println("Why didn't you take the test");
        }

        // do while loop example
        // despite boolean expression outcome, do while loop
        // will run always once
        int num = -10000;
        do {
            System.out.println("Loops!");
            num--;
        } while (num > 0);

        // prints out 0, 2, 4, 6, 8
        for (int i = 0; i < 10; i++) {
            System.out.println(i++);
        }

        String[] arr = {"Foo", "Bar", "00P", "Fizz", "Yikes"}; /*
        System.out.println("Elements of the original arrays: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%s%n", arr[i]);
        }
*/
        for (var word: arr) {
            System.out.printf("%s%n", word);
        }

        Scanner s = new Scanner(System.in);
        s.close();


        // for each loop printing
        // can use var for variable type, something new in java
    }
}