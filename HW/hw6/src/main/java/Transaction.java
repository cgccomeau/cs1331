import java.util.Optional;
/**
 * @author ccomeau7
 * @version 1.0
 */
public class Transaction {

    private TransactionType type;
    private double amount;
    private Optional<String> comment;

    /**
     * @param type TransactionType
     * @param amount double amount of $$
     */
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        comment = Optional.empty();
    }

    /**
     * @param type TransactionType
     * @param amount double amount of $$
     * @param value String
     */
    public Transaction(TransactionType type, double amount, String value) {
        this.type = type;
        this.amount = amount;
        comment = (value == null) ? Optional.empty() : Optional.of(value);
    }

    /**
     * @return type of Transaction
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * @return double amount of $$
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return String in Optional object
     */
    public Optional<String> getComment() {
        return comment;
    }

    /**
     * @return whether transaction contains a String comment
     */
    public boolean hasComment() {
        return comment.isPresent();
    }
}
