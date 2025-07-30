package Transaction;

import User.UserEntity;

import java.util.List;
import java.util.Map;

public class TransactionController {
    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    TransactionService transactionService;


    public void makePayment(TransactionDO transactionDO) {
        transactionService.makePayment(transactionDO);
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return transactionService.getTransactionHistory(userId);
    }
}
