import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        Transaction one = new Transaction(TransactionType.WITHDRAWAL, 100);
        Transaction two = new Transaction(TransactionType.WITHDRAWAL, 100, "cash");
        Transaction three = new Transaction(TransactionType.DEPOSIT, 200);
        Transaction four = new Transaction(TransactionType.DEPOSIT, 200, "cash");
        List<Transaction> money = Arrays.asList(one, two, three, four);
        Account straightcash = new Account(money);
        System.out.println("Pre: " + straightcash);
        System.out.println("Sort by $100 amount: " + straightcash.getTransactionsByAmount(100));
        System.out.println("Sort by $200 amount: " + straightcash.getTransactionsByAmount(200));
        System.out.println("Sort by with comment: " + straightcash.getTransactionsWithComment());
        System.out.println("Sort by comment length: " + straightcash.getTransactionsWithCommentLongerThan(1));
        System.out.println("Sort by Withdrawals: " + straightcash.getWithdrawals());
        System.out.println("Sort by Deposits: " + straightcash.getDeposits());
        System.out.println("Sort by amount > 150: " + straightcash.findTransactionsByPredicate(t -> t.getAmount() > 150));


        // TransactionType[] money = TransactionType.values();
        // System.out.println(money);
    }
}
