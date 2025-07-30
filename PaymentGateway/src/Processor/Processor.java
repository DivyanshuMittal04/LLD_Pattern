package Processor;

import Instrument.InstrumentDO;

public class Processor {
    public void processPayment(InstrumentDO senderInstrument, InstrumentDO receiverInstrument) {
        // Implementation for processing payment
        System.out.println("Processing payment..." +
                "Sender Instrument: " + senderInstrument.getInstrumentId() +
                ", Receiver Instrument: " + receiverInstrument.getInstrumentId());
    }
}
