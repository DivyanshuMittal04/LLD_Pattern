import Instrument.InstrumentController;
import Instrument.InstrumentDO;
import Instrument.InstrumentType;
import Transaction.Transaction;
import Transaction.TransactionController;
import Transaction.TransactionDO;
import User.UserController;
import User.UserDO;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PaymentGateway {


    public static void main(String[] args) {
        UserController userController = new UserController();
        InstrumentController instrumentController = new InstrumentController();
        TransactionController transactionController = new TransactionController();

        UserDO user = new UserDO(1,"ABC","1234");
        userController.addUser(user);

        UserDO user2 = new UserDO(2,"DEF","1234");
        userController.addUser(user2);

        InstrumentDO bankInstrument = new InstrumentDO();
        bankInstrument.setBankAccountNumber("1234567890");
        bankInstrument.setInstrumentType(InstrumentType.BANK);
        bankInstrument.setIfsc("1234");
        bankInstrument.setUserId(user.getId());
        InstrumentDO bankInstrumentDO = instrumentController.addInstrument(bankInstrument);
        System.out.println("Bank Instrument Added: " + bankInstrumentDO.getInstrumentId());

        InstrumentDO cardInstrument = new InstrumentDO();
        cardInstrument.setCardNumber("1234567890");
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        cardInstrument.setCvv("1234");
        cardInstrument.setUserId(user2.getId());
        InstrumentDO cardInstrumentDO = instrumentController.addInstrument(cardInstrument);
        System.out.println("Bank Instrument Added: " + cardInstrumentDO.getInstrumentId());


        TransactionDO transactionDO = new TransactionDO();
        transactionDO.setAmount(10);
        transactionDO.setSenderId(user.getId());
        transactionDO.setReceiverId(user2.getId());
        transactionDO.setDebitInstrumentId(bankInstrument.getInstrumentId());
        transactionDO.setCreditInstrumentId(cardInstrument.getInstrumentId());
        transactionController.makePayment(transactionDO);


        List<InstrumentDO> user1Instruments = instrumentController.getAllInstruments(user.getId());

        for(InstrumentDO instrument : user1Instruments) {
            System.out.println("User 1 Instrument: " + instrument.getInstrumentId() + ", Type: " + instrument.getInstrumentType());
        }

        List<InstrumentDO> user2Instruments = instrumentController.getAllInstruments(user2.getId());

        for(InstrumentDO instrument : user2Instruments) {
            System.out.println("User 2 Instrument: " + instrument.getInstrumentId() + ", Type: " + instrument.getInstrumentType());
        }

        List<Transaction> user1History = transactionController.getTransactionHistory(user.getId());
        for(Transaction transaction : user1History) {
            System.out.println("User 1 Transaction: " + transaction.getTxnId() + ", Amount: " + transaction.getAmount() +
                    ", Sender: " + transaction.getSenderId() + ", Receiver: " + transaction.getReceiverId());
        }



    }


}