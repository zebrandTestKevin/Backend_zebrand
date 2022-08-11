package kevin.zebrand.zebrand_backend.model;

import java.util.Date;

public class Transaction {
    private Integer txId;
    private String txHost;
    private Integer txUserId;
    private Date txDate;

    public Transaction() {
    }

    public Transaction(Integer txId, String txHost, Integer txUserId, Date txDate) {
        this.txId = txId;
        this.txHost = txHost;
        this.txUserId = txUserId;
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txUserId=" + txUserId +
                ", txDate=" + txDate +
                '}';
    }

    public void setTransaction(Transaction transaction){
        setTxId(transaction.getTxId());
        setTxHost(transaction.getTxHost());
        setTxUserId(transaction.getTxUserId() != null? transaction.getTxUserId(): 0);
        setTxDate(transaction.getTxDate());
    }


    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Integer getTxUserId() {
        return txUserId;
    }

    public void setTxUserId(Integer txUserId) {
        this.txUserId = txUserId;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}
