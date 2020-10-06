import java.util.Random;

/** Represents an AI object that is not very smart
 * @author ccomeau7
 * @version 1.0
 */
public class RandomAI extends AI {

    private static final Random randomizer = new Random();

    /** Creates a Random AI with all required parameters
     * @param cannonTarget Coordinate
     * @param secretHQ Coordinate
     */
    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
    }

    @Override
    public boolean shouldSwapCannonTarget() {
        return randomizer.nextInt(2) == 0;
    }

    @Override
    public boolean shouldSelfDestruct() {
        return randomizer.nextInt(2) == 0;
    }
}