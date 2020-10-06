import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
/**
 * @author ccomeau7
 * @version 1.0
*/
public class Account {


    private List<Transaction> pastTransactions;

    /**
     * @param pastTransactions List
     */
    public Account(List<Transaction> pastTransactions) {
        this.pastTransactions = pastTransactions;
    }

    /**
     * @return List of past Transactions
     */
    public List<Transaction> getPastTransactions() {
        return pastTransactions;
    }

    /**
     * @param n index
     * @return Transaction within past transaction list
     */
    public Transaction getTransaction(int n) {
        return pastTransactions.get(n);
    }

    /**
     * @param predicate object for implementing custom testing
     * @return List of filtered transaction after testing
     */
    public List<Transaction> findTransactionsByPredicate(Predicate<Transaction>
        predicate) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction i: pastTransactions) {
            if (predicate.test(i)) {
                filtered.add(i);
            }
        }
        return filtered;
    }

    /** private inner class
     * @author ccomeau7
     * @version 1.0
     */
    private class AmountPredicate implements Predicate<Transaction> {
        private double amount;
        private AmountPredicate(double amount) {
            this.amount = amount;
        }

        @Override
        public boolean test(Transaction t) {
            return t.getAmount() == amount;
        }
    }

    /**
     * @param amount of $$ to be compared
     * @return List of filtered transactions with same $$ amount
     */
    public List<Transaction> getTransactionsByAmount(double amount) {
        return findTransactionsByPredicate(new AmountPredicate(amount));
    }

    /**
     * @return List of filtered transactions that are withdrawals
     */
    public List<Transaction> getWithdrawals() {
        return findTransactionsByPredicate(new Predicate<Transaction>() {
            public boolean test(Transaction t) {
                return t.getType() == TransactionType.WITHDRAWAL;
            }
        });
    }

    /**
     * @return List of filtered transactions that are deposits
     */
    public List<Transaction> getDeposits() {
        return findTransactionsByPredicate(t ->
            t.getType() == TransactionType.DEPOSIT);
    }

    /**
     * @param length of comment
     * @return list of filtered transactions that have comments
     * longer than length
     */
    public List<Transaction> getTransactionsWithCommentLongerThan(int length) {
        return findTransactionsByPredicate(t ->
            (t.hasComment()) && t.getComment().get().length() > length);
    }

    /**
     * @return list of filtered transactions that actually have comments
     */
    public List<Transaction> getTransactionsWithComment() {
        return findTransactionsByPredicate(t -> t.hasComment());
    }
}
