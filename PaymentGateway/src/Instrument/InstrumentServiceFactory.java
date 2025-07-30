package Instrument;

public class InstrumentServiceFactory {
    public InstrumentService getInstrumentService(InstrumentType instrumentType) {
        if(instrumentType == InstrumentType.BANK )
            return new BankInstrumentService();
        else if(instrumentType == InstrumentType.CARD)
            return new CardInstrumentService();
        return null;
    }
}
