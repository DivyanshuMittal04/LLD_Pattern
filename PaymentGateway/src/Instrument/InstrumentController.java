package Instrument;

import java.util.List;

public class InstrumentController {
    public InstrumentController() {
        instrumentServiceFactory = new InstrumentServiceFactory();
    }

    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDO.getInstrumentType());
        return instrumentService.addInstrument(instrumentDO);
    }

    public List<InstrumentDO> getAllInstruments(int userId){
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);
        List<InstrumentDO> allInstruments = bankInstrumentService.getInstrumentsByUserId((userId));
        allInstruments.addAll(cardInstrumentService.getInstrumentsByUserId(userId));
        return allInstruments;

    }

    public InstrumentDO getInstrumentByUserIdAndInstrumentId(int userId, int instrumentId) {
        List<InstrumentDO> allInstruments = getAllInstruments(userId);
        for(InstrumentDO instrument : allInstruments) {
            if (instrument.getInstrumentId() == instrumentId) {
                return instrument;
            }
        }
        return null;
    }
}
