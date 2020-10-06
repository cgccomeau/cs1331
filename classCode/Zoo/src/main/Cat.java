public class Cat extends Animal {

    public Cat (String name) {
        super(name);
    }

    @Override
    public String speak() {
        return "Meow!";
    }

    public void purr() {
        System.out.println("(" + getName() + " purrs.)");
    }
}