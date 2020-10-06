public class Dog extends Animal {

    public Dog (String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "Woof!";
    }

    public void wagTail() {
        System.out.println("(" + getName() + " wags tail.)");
    }
}