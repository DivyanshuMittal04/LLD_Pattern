package Transaction;

import Instrument.InstrumentController;
import Instrument.InstrumentDO;
import Processor.Processor;

import java.util.*;

public class TransactionService {
    static Map<Integer, List<Transaction>> userVsTransactionList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        this.instrumentController = new InstrumentController();
        this.processor = new Processor();
    }

    public TransactionDO makePayment(TransactionDO transactionDO) {
        InstrumentDO senderInstrument = instrumentController.getInstrumentByUserIdAndInstrumentId(transactionDO.getSenderId(),transactionDO.getDebitInstrumentId());
        InstrumentDO receiverInstrument = instrumentController.getInstrumentByUserIdAndInstrumentId(transactionDO.getReceiverId(),transactionDO.getCreditInstrumentId());
        processor.processPayment(senderInstrument,receiverInstrument);
        Transaction transaction = new Transaction();
        transaction.setTxnId(new Random().nextInt(100-10)+10);
        transaction.setAmount(transactionDO.getAmount());
        transaction.setSenderId(transactionDO.getSenderId());
        transaction.setReceiverId(transactionDO.getReceiverId());
        transaction.setDebitInstrumentId(transactionDO.getDebitInstrumentId());
        transaction.setCreditInstrumentId(transactionDO.getCreditInstrumentId());
        transaction.setStatus(TransactionStatus.SUCCESS);
        List<Transaction> transactionList = userVsTransactionList.getOrDefault(transactionDO.getSenderId(), new ArrayList<>());
        transactionList.add(transaction);
        userVsTransactionList.put(transactionDO.getSenderId(), transactionList);

        List<Transaction> receiverTransactionList = userVsTransactionList.getOrDefault(transactionDO.getReceiverId(), new ArrayList<>());
        receiverTransactionList.add(transaction);
        userVsTransactionList.put(transactionDO.getReceiverId(), receiverTransactionList);
        transactionDO.setId(transaction.getTxnId());
        transactionDO.setTransactionStatus(transaction.getStatus());
        return transactionDO;
    }

    public List<Transaction> getTransactionHistory(int userId) {
       return userVsTransactionList.get(userId);
    }
}
