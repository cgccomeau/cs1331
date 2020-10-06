import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LinkedListTest {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("red", "yellow", "green"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("red", "yellow", "blue"));
        //list1.removeAll(list2);
        //list1.remove(list2);
        list1.retainAll(list2);
        list1.clear();
        System.out.println(list1);
        System.out.println(list2);
        // try {
        //     throw new VirtualMachineError("yikes");
        // } catch (VirtualMachineError e) {
        //     System.out.println("nice");
        // }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(new Integer(2));
        list.add(1);
        list.add(new Integer(3));
        list.add(4);
        list.add(new Integer(5));
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        list.remove(new Integer(1));
        System.out.println(list);
    }
}