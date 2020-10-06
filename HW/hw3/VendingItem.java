/** This is my hw3 enum file for Vending Machine
 * that defines the legal characteristics and methods
 * for a VendingItem object
 * @author 903359699
 * @version 1.0
*/

public enum VendingItem {
    Lays (1.5),
    Doritos(1.5),
    Coke(2.5),
    Ramblin_Reck_Toy(180.75),
    Rubiks_Cube(30.0),
    Rat_Cap(15.0),
    FASET_Lanyard(10.0),
    Graphing_Calculator(120.0),
    UGA_Diploma(0.10),
    Pie(3.14),
    Clicker(55.55),
    Cheetos(1.25),
    Sprite(2.50),
    Red_Bull(4.75),
    Ramen(3.15),
    Cold_Pizza(0.99);

    private final double price;

    /** This is the private Vending Item constructor that creates a
     * Vending Item object and initializes its price
     * @param price price of Vending Item
    */
    private VendingItem(double price) {
        this.price = price;
    }

    /** This is an accessor method that returns a Vending Item object's price
    * @return price of a Vending Item object
    */
    public double getPrice() {
        return price;
    }
    /** This is the toString method for the Vending Item object that prints
     * a String representation of the Vending item's name and price
     * @return String representation of Vending item's name and price
    */
    public String toString() {
        String result = String.format("%s: $%2.2f", name(), getPrice());
        return result;
    }
}