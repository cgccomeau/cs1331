/** Represents an abstract AI object with a cannon target and secret HQ
 * Has subclasses RandomAI and RogueAI
 * @author ccomeau7
 * @version 1.0
*/
public abstract class AI {
    private boolean destructed = false;
    private Coordinates cannonTarget;
    private Coordinates secretHQ;

    /** Creates an AI object with all required parameters
     * @param cannonTarget Coordinate
     * @param secretHQ Coordinate
    */
    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }

    /**
     * @return true/false value of AI's self-destruction
    */
    public boolean getDestructed() {
        return destructed;
    }

    /**
     * @return Coordinates of cannon Target
     */
    public Coordinates getCannonTarget() {
        return cannonTarget;
    }

    /**
     * @return Coordinates of secret HQ
     */
    public Coordinates getSecretHQ() {
        return secretHQ;
    }

    /** Swaps AI's current cannon target Coordinates with new ones
     * @param newCoords new Coordinates
     * @return boolean value whether cannon target
     * Coordinates were actually swapped
     */
    public boolean swapCannonTarget(Coordinates newCoords) {
        if (!destructed && !newCoords.equals(cannonTarget)) {
            if (shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            } else if (shouldSelfDestruct()) {
                selfDestruct();
                return false;
            }
        }
        return false;
    }

    /**
     * @return boolean value whether AI should swap the cannon target
     */
    public abstract boolean shouldSwapCannonTarget();

    /** Setter method for destructed variable, however only sets
     * destructed as true whenever invoked
     */
    public void selfDestruct() {
        destructed = true;
    }

    /**
     * @return boolean value whether AI should self-destruct
     */
    public abstract boolean shouldSelfDestruct();

    /** Overrides Object's toString method, prints out String representation
     * of an AI object
     * @return String representation of an AI object
     */
    @Override
    public String toString() {
        return String.format("Dr. Chipotle's guacamole cannon is currently "
                + "pointed at %s.", getCannonTarget());
    }
}