public class Blockbuster {

    public static void main(String[] args) {
        Movie[] cart = {
                new Movie ( "ACADEMY DINOSAUR",  "A Epic Drama",
                    "drama", "sappy"),
                new Movie ("ALADDIN CALEDNAR", "An Action-Packed Tale",
                    "drama", "car chases n stuff"),
                new Movie ("Terminator", "Governating",
                    "action", "car chases n stuff")
            };

        double total = 0.0;
        for (Movie m: cart) {
            if (m.getType().equals("drama")) {
                total += 4;
            } else if (m.getType().equals("action")) {
                total += 3;
            } else {
                total += 1;
            }
        }
        System.out.println("total = " + total);
    }
}