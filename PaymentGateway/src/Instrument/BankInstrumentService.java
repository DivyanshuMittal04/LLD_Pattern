package Instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankInstrumentService extends InstrumentService{
    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        Instrument instrument = convertInstrumentDOToInstrument(instrumentDO);
        if(userVsInstruments.containsKey(instrumentDO.getUserId())) {
            userVsInstruments.get(instrumentDO.getUserId()).add(instrument);
        }else {
            userVsInstruments.put(instrumentDO.getUserId(), List.of(instrument));
        }
        instrumentDO.setInstrumentId(instrument.getInstrumentId());
        return instrumentDO;
    }

    @Override
    public List<InstrumentDO> getInstrumentsByUserId(int userId) {
        List<Instrument> instruments = userVsInstruments.get(userId);
        if (instruments == null || instruments.isEmpty()) {
            return List.of();
        }
        List<InstrumentDO> instrumentDOs = new ArrayList<>();
        for(Instrument instrument : instruments) {
            if (instrument.getInstrumentType() == InstrumentType.BANK) {
                instrumentDOs.add(convertInstrumentToInstrumentDO((BankInstrument) instrument));
            }
        }
        return instrumentDOs;
    }

    private InstrumentDO convertInstrumentToInstrumentDO(BankInstrument instrument) {
        InstrumentDO cardInstrument = new InstrumentDO();
        cardInstrument.setBankAccountNumber(instrument.getBankAccountNumber());
        cardInstrument.setIfsc(instrument.getIfsc());
        cardInstrument.setUserId(instrument.getUserId());
        cardInstrument.setInstrumentType(instrument.getInstrumentType());
        cardInstrument.setInstrumentId(instrument.getInstrumentId());
        return cardInstrument;
    }

    private Instrument convertInstrumentDOToInstrument(InstrumentDO instrumentDO) {
            BankInstrument bankInstrument = new BankInstrument();
            bankInstrument.setInstrumentId(new Random().nextInt(100-10)+10);
            bankInstrument.setIfsc(instrumentDO.getIfsc());
            bankInstrument.setBankAccountNumber(instrumentDO.getBankAccountNumber());
            bankInstrument.setUserId(instrumentDO.getUserId());
            bankInstrument.setInstrumentType(InstrumentType.BANK);
            return bankInstrument;
    }
}
