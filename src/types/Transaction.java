package types;

import java.util.Date;

public class Transaction {
    private String uuid;
    private State state;
    private Long sum;
    private Date created;

    public String getUuid() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public Long getSum() {
        return sum;
    }

    public Date getCreated() {
        return created;
    }
}
