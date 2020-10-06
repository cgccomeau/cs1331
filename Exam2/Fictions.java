public class Fictions extends Book {
    private int numCopies;
    public Fictions(String name, double price, int numCopies) {
        super(name, price);
        this.numCopies = numCopies;
    }

    public boolean equals(Object b) {
        if(this == b) {
            return true;
        }
        if (!(b instanceof Fictions)) {
            return false;
        }
        Fictions that = (Fictions) b;
        return this.name.equals(that.name) && this.price == that.price
            && this.numCopies == that.numCopies;
    }
}