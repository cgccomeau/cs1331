public abstract class Book {
    protected String name;
    protected double price;
    public Book(String n, double p) {
        name = n;
        price = p;
    }
    public boolean equals (Object b) {
        return this.name.equals(((Book)b).name) && this.price == ((Book)b).price;
    }
}