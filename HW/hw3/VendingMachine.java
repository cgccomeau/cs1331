import java.util.Random;

/**
 * This is my hw3 class file for Vending Machine
 * that simulates the actions of an actual
 * Vending Machine
 * @author 903359699
 * @version 1.0
*/
public class VendingMachine {
    private static double totalSales = 0.0;
    private VendingItem[][][] shelf;
    private int luckyChance;
    private Random rand = new Random();

    /** This is the Vending Item Constructor that creates a
     * Vending Machine object through a 3-D array
    */
    public VendingMachine() {
        shelf = new VendingItem[6][3][5];
        luckyChance = 0;
        restock();
    }

    /** This method simulates the action of the Vending
     * machine dispensing an item
     * @param code is the user's String input
     * @return Vending Item that is being dispensed
    */
    public VendingItem vend(String code) {
        if (code.length() != 2) {
            System.out.println("Error - that is not a valid choice. "
                + "Please try again.");
            return null;
        }
        int row = code.charAt(0) - 'A';
        int col = code.charAt(1) - '0' - 1;

        if (code.charAt(1) - '0' > 3 || code.charAt(0) > 'F') {
            System.out.println("Error - that is not a valid choice. "
                + "Please try again.");
            return null;
        }
        if (shelf[row][col][0] == null) {
            System.out.println("Item out of stock");
            return null;
        }

        double revenue = 0;

        if (free()) {
            revenue = 0;
            System.out.println("Congrats! Your item is free.");
        } else {
            revenue = shelf[row][col][0].getPrice();
        }
        totalSales += revenue;
        VendingItem dispense = shelf[row][col][0];
        int k = 0;
        for (; k < shelf[row][col].length - 1
            && shelf[row][col][k] != null; k++) {
            shelf[row][col][k] = shelf[row][col][k + 1];
        }
        shelf[row][col][k] = null;
        return dispense;
    }

    /** This is a private helper method that determines
     * the user's probability of winning a free item
     * using the Random class
     * @return boolean value of user winning a free item
    */
    private boolean free() {
        if (rand.nextInt(100) < luckyChance) {
            luckyChance = 0;
            return true;
        } else {
            luckyChance++;
            return false;
        }
    }

    /** This method simulates the Vending Machine randomly
     * restocking all of itself, using the Random class
    */
    public void restock() {
        VendingItem[] snacc = VendingItem.values();
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    shelf[i][j][k] = snacc[rand.nextInt(16)];
                }
            }
        }
    }

    /** This is a static accessor method that returns the static
     * total sales variable made by all the vending machines
     * @return total sales made by all vending machines
    */
    public static double getTotalSales() {
        return totalSales;
    }

    /** This helper method returns the total number of Vending Items
     * in the machine
     * @return total number of Vending Items in the machine
    */
    public int getNumberOfItems() {
        int count = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /** This helper method returns the total monetary value of all
    * the Vending items currently in the machine
    * @return total monetary value of all items in the machine
    */
    public double getTotalValue() {
        double totalVal = 0.0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        totalVal += shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return totalVal;
    }

    /** This helper method returns the current value of luckyChance.
     * Really only used as a diagnostic during testing
     * @return current chances of user winning a free item
    */
    public int getLuckyChance() {
        return luckyChance;
    }

    /** This is the given toString for the Vending Machine that prints a
     * String representation of the Vending Machine
     * @return String representation of the Vending Machine
    */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }

}