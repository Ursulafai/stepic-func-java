package types;

import java.util.List;

public class Account {
    private String number;
    private Long balance;
    private List<Transaction> transactions;

    public String getNumber() {
        return number;
    }

    public Long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
