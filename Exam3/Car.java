import java.util.HashMap;

public class Car {
    public void calculateVroom(int b) throws Exception {
        System.out.println("Speed: " + b);
        if (b < 0) {
            help();
        }
        System.out.println("Goin' vroom");
    }

    public static void help() throws Exception {
        throw new Exception("no vroom");
    }

    public static void main(String[] args) throws Exception {
        Car c = new Car();
        try {
            System.out.println("Rev!!");
            c.calculateVroom(1);
            System.out.println("faster!");
        } catch(Exception e) {
            e.getMessage();
        } finally {
            System.out.println("Phew!");
        }
        HashMap <String, Integer> nameToAge= new HashMap<>();
    }
}