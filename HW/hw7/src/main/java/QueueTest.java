/**
 * A testing class for LinkedQueue on hw7
 * @author fyoussef3
 * @version 1.0
 */
public class QueueTest {
    public static void main(String[] args) {
        enqTest();
        deqTest();
        sizeTest();
        isEmptyTest();
        doAddTest();
        doRemTest();
        getTest();
        doSetTest();
        clearTest();
        iterateTest();
    }
    public static void enqTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        String str = "";
        for (String s : a) {
            str += s;
        }
        if (str.equals(("123"))) {
            System.out.println("enqueue() Passes!");
        } else {
            System.out.println("enqueue() Fails");
        }
    }

    public static void doAddTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        Boolean part1True = false;
        Boolean part2True = false;
        Boolean part3True = false;
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        String str1 = "";
        a.doAdd(2, "4");
        a.doAdd(0, "1");
        for (String s : a) {
            str1 += s;
        }
        if (str1.equals(("11243"))) {
            part1True = true;
        } else {
            System.out.println("Part 1 Failed: " + str1);
        }
        try {
            a.doAdd(80, "90");
            System.out.println("Part 2 Failure");
        } catch (IndexOutOfBoundsException e) {
            part2True = true;
        }
        try {
            a.doAdd(-1, "90");
        } catch (IndexOutOfBoundsException e) {
            part3True = true;
        }
        if (part1True && part2True && part3True) {
            System.out.println("doAdd() Passed");
        } else {
            System.out.println("doAdd() Failed");
        }
    }

    public static void deqTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        String str = "";
        for (String s : a) {
            str += s;
        }
        String str1 = "";
        str1 += a.dequeue();
        str1 += a.dequeue();
        str1 += a.dequeue();
        String s = a.dequeue();
        if (s == null && str.equals((str1))) {
            System.out.println("dequeue() Passes");
        } else {
            System.out.println("dequeue() Fails");
        }
    }

    public static void doRemTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        Boolean part1True = false;
        Boolean part2True = false;
        Boolean part3True = false;
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.enqueue("5");
        a.enqueue("6");
        String str1 = "";
        a.doRemove(2);
        a.doRemove(0);
        a.doRemove(a.size()-1);
        for (String s : a) {
            str1 += s;
        }
        if (str1.equals(("245"))) {
            part1True = true;
        } else {
            System.out.println("DoRem Part 1 Failed: " + str1);
        }
        try {
            a.doRemove(80);
            System.out.println("DoRem Part 2 Failure");
        } catch (IndexOutOfBoundsException e) {
            part2True = true;
        }
        try {
            a.doRemove(-1);
        } catch (IndexOutOfBoundsException e) {
            part3True = true;
        }
        if (part1True && part2True) {
            System.out.println("doRemove() Passed");
        } else {
            System.out.println("doRemove() Failed");
        }
    }

    public static void getTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        Boolean part1True = false;
        Boolean part2True = false;
        Boolean part3True = false;
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.enqueue("5");
        a.enqueue("6");
        String str1 = "";
        for (int i = 0; i < a.size(); i++) {
            str1 += a.get(i);
        }
        if (str1.equals(("123456"))) {
            part1True = true;
        } else {
            System.out.println("Get Part 1 Failed: " + str1);
        }
        try {
            a.get(80);
            System.out.println("Get Part 2 Failure");
        } catch (IndexOutOfBoundsException e) {
            part2True = true;
        }
        try {
            a.get(-1);
        } catch (IndexOutOfBoundsException e) {
            part3True = true;
        }
        if (part1True && part2True && part3True) {
            System.out.println("get() Passed");
        } else {
            System.out.println("get() Failed");
        }
    }

    public static void doSetTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.enqueue("5");
        a.enqueue("6");
        a.enqueue(null);
        try{
            a.doSet(0, "1");
            System.out.println("doSet() Failed");
        } catch (UnsupportedOperationException e) {
            System.out.println("doSet() Passed");
        }

    }

    public static void iterateTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        LinkedQueue<String> b = new LinkedQueue<>();
        Boolean part1True = false;
        Boolean part2True = false;
        a.enqueue("1");
        a.enqueue("2");
        a.enqueue("3");
        a.enqueue("4");
        a.enqueue("5");
        a.enqueue("6");
        String str = "";
        for (String s : b) {
            str += s;
        }
        String str1 = "";
        for (String s : a) {
            str1 += s;
        }
        if (str1.equals("123456")) {
            part1True = true;
        } else {
            System.out.println("Iterate Part 1 Failed: " + str1);
        }
        if (str.equals("")) {
            part2True = true;
        } else {
            System.out.println("Iterate Part 2 Failed: " + str);
        }
        if (part1True && part2True) {
            System.out.println("Iterate Passed");
        } else {
            System.out.println("Iterate Failed");
        }
    }

    public static void sizeTest() {
        LinkedQueue<String> s = new LinkedQueue<>();
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("1");
        a.enqueue("1");
        a.enqueue("1");
        if (s.size() == 0 && a.size() == 3) {
            System.out.println("size() Passes");
        } else {
            System.out.println("size() Fails");
        }

    }

    public static void clearTest() {
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("1");
        a.enqueue("1");
        a.enqueue("1");
        a.enqueue(null);
        a.clear();
        if (a.size() == 0 && a.isEmpty()) {
            System.out.println("clear() Passed");
        } else {
            System.out.println("clear() Failed");
        }
    }

    public static void isEmptyTest() {
        LinkedQueue<String> s = new LinkedQueue<>();
        LinkedQueue<String> a = new LinkedQueue<>();
        a.enqueue("hi");
        a.dequeue();
        if (a.isEmpty() && s.isEmpty()) {
            System.out.println("isEmpty() Passes");
        } else {
            System.out.println("isEmpty() Fails");
        }
    }

}
