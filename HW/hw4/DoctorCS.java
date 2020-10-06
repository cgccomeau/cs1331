/** Represents Doctor CS himself
 * @author ccomeau7
 * @version 1.0
 * 1) Using instanceof in this case violates both the Single Responsibility
 * principle and the Open Closed principle, because instanceof is implementing
 * code for a RogueAI object outside of the RogueAI class and hierarchy.
 * 2) one way to alternatively solve this is to make swapCannonTarget()
 * abstract in the superclass AI, thus making its subclasses RogueAI and
 * RandomAI implement that method separately, thus using polymorphism to avoid
 * the usage of instanceof, thus satisfying both the Single Responsibility
 * principle and the Open Closed principle once again.
 */
public class DoctorCS {
    private AI ai;
    private String secretIdentity;
    private int jlaid;
    private boolean safe;

    /** Creates a Doctor CS with all required parameters
     * @param ai AI object that saves the day
     * @param secretIdentity of Doctor CS
     * @param jlaid int representation of Doctor CS's Justice League of
     * America ID
     */
    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;
    }

    /**
     * @return AI object that saves the day
     */
    public AI getAI() {
        return ai;
    }

    /**
     * @return int representation of Doctor CS's Justice League of America ID
     */
    public int getjlaid() {
        return jlaid;
    }

    /**
     * Conditional setter for boolean safe variable
     */
    public void saveTheDay() {
        if (ai instanceof RogueAI) {
            RogueAI lost = (RogueAI) ai;
            while (lost.getFirewallProtection() > 0) {
                lost.lowerFirewall();
            }
        }
        safe = ai.swapCannonTarget(ai.getSecretHQ());
    }

    /**
     * @return String statement whether Doctor CS has been alleviated and his
     * guac cannon has self destructed or not
     */
    public String getStatus() {
        if (safe) {
            return "Doctor CS has saved the day!";
        } else if (ai.getDestructed()) {
            return "Dr. Chipotle has succeeded in his plan...";
        } else {
            return "Georgia Tech is still in danger!";
        }
    }

    /** Overrides Object's toString method, prints String representation of
     * Doctor CS's information
     * @return String representation of Doctor CS's information
     */
    @Override
    public String toString() {
        return this.secretIdentity + " aka Doctor CS with JLAI: " + getjlaid();
    }
}