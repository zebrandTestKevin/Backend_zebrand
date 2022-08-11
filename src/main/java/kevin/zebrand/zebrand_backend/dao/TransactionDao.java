package kevin.zebrand.zebrand_backend.dao;

import kevin.zebrand.zebrand_backend.model.Transaction;

public interface TransactionDao {
    //
    public Integer create(Transaction transaction);
    //
    public Integer getLastInsertId();

}
