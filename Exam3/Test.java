import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class Test {
        static void bar() throws Throwable {
            throw new Throwable("Wee!");
        }
        static void foo() throws Throwable {
            bar();
            System.out.println("Foo!");
        }
        public static void main(String[] args) {
            try {
                foo();
            } catch (Throwable t) {
                System.out.println(t.getMessage());
            }
            System.out.println("I'm still running.");

            Integer[] array = {3, 5, 95, 4, 15, 34, 3, 6, 5};
            ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
            Collections.sort(list);
            System.out.println(list);

            ArrayList<Integer> second = new ArrayList<>(10);
            //System.out.println(second.get(10));
            for(int i = 0; i < 15; i++) {
                second.add(i);
            }
            System.out.println(second.get(10));
            // try {
            //     int a = 5;
            //     int b = 0;
            //     System.out.println("Let's begin");
            //     System.out.println(a/b);
            //     System.out.println("this doesn't work");
            // } catch(IllegalArgumentException e) {
            //     System.out.println("illegal argument");
            // } catch(Exception e) {
            //     System.out.println("some exceptions");
            //     throw new NullPointerException("error");
            // } finally {
            //     System.out.println("Hello World");
            // }
            System.out.println(method(5));
            System.out.println();
            System.out.println(method(4));
        }
        public static int method(int n) {
            try {
                if (n % 2 == 1) {
                    throw new NullPointerException("error");
                } else {
                    throw new IOException("IOError");
                }
            } catch(IOException e) {
                System.out.println("caught IO");
                return 3;
            } finally {
                return 5;
            }
        }
}
