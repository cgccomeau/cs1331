/** Represents an AI object that can detect the guac cannon's firewalls
 * and alert levels
 * @author ccomeau7
 * @version 1.0
 */
public class RogueAI extends AI {

    private int firewallProtection;
    private int alertLevel;
    private final int maxAlert;

    /** Creates a RogueAI with all required parameters
     * @param firewallProtection of guac cannon
     * @param alertLevel of guac cannon
     * @param maxAlert alert level of guac cannon at which the computer
     * self destructs
     * @param cannonTarget Coordinates
     * @param secretHQ Coordinates
     */
    public RogueAI(int firewallProtection, int alertLevel, int maxAlert,
                    Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }

    /** Creates a RogueAI with alert level of 0
     * @param firewallProtection of guac cannon
     * @param maxAlert alert level of guac cannon at which the computer
     * self destructs
     * @param cannonTarget Coordinates
     * @param secretHQ Coordinates
    */
    public RogueAI(int firewallProtection, int maxAlert,
                    Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, maxAlert, 0, cannonTarget, secretHQ);
    }

    /** Creates a RogueAI with alert level of 0 and max alert level as 10
     * @param firewallProtection of guac cannon
     * @param cannonTarget Coordinates
     * @param secretHQ Coordinates
     */
    public RogueAI(int firewallProtection, Coordinates cannonTarget,
                    Coordinates secretHQ) {
        this(firewallProtection, 0, 10, cannonTarget, secretHQ);
    }

    /**
     * @return firewall protection level of guac cannon
     */
    public int getFirewallProtection() {
        return firewallProtection;
    }

    /**
     * @return alert level of guac cannon
     */
    public int getAlertLevel() {
        return alertLevel;
    }

    /**
     * @return max alert level of guac cannon at which the computer
     * self destructs
     */
    public int getMaxAlert() {
        return maxAlert;
    }

    /**
     * Lowers firewall protection by 2, increases alert level by 1
     */
    public void lowerFirewall() {
        firewallProtection -= 2;
        alertLevel++;
    }

    @Override
    public boolean shouldSwapCannonTarget() {
        return firewallProtection <= 0;
    }

    @Override
    public boolean shouldSelfDestruct() {
        return alertLevel >= maxAlert;
    }

    /** Overrides AI's toString method, prints out String representation of
     * RogueAI's fields
     * @return String representation of RogueAI's fields
     */
    @Override
    public String toString() {
        String superclass = super.toString().substring(0,
                            super.toString().length() - 1);
        return String.format("%s, and is at alert level %d with firewall "
                + "protection %d.", superclass, getAlertLevel(),
                getFirewallProtection());

    }
}