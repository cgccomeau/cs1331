public class Fibonacci {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for(; n >= 0; n--) {
            System.out.println("fibonacci(" + n + ") = " + fibonacci(n));
        }

        String[] pizzas = {"cheese", "pepperoni", "veggie"};
        String favorite = "meat";
        for (String pizza: pizzas) {
            favorite = pizza;
            pizza = "anchovies";
        }
        System.out.println(pizzas[1]);
        System.out.println(favorite);
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public void warg(int a) {}
}