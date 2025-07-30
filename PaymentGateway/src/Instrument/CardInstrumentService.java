package Instrument;

import java.util.*;

public class CardInstrumentService extends  InstrumentService {
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
            if (instrument.getInstrumentType() == InstrumentType.CARD) {
                instrumentDOs.add(convertInstrumentToInstrumentDO((CardInstrument) instrument));
            }
        }
        return instrumentDOs;
    }

    private Instrument convertInstrumentDOToInstrument(InstrumentDO instrumentDO) {
        // Conversion logic here
            CardInstrument cardInstrument = new CardInstrument();
            cardInstrument.setCardNumber(instrumentDO.getCardNumber());
            cardInstrument.setUserId(instrumentDO.getUserId());
            cardInstrument.setCvv(instrumentDO.getCvv());
            cardInstrument.setInstrumentId(new Random().nextInt(100-10)+10);
        cardInstrument.setInstrumentType(InstrumentType.CARD);
        return cardInstrument;
    }

    private InstrumentDO convertInstrumentToInstrumentDO(CardInstrument instrument) {
        // Conversion logic here
        InstrumentDO cardInstrument = new InstrumentDO();
        cardInstrument.setCardNumber(instrument.getCardNumber());
        cardInstrument.setCvv(instrument.getCvv());
        cardInstrument.setUserId(instrument.getUserId());
        cardInstrument.setInstrumentType(instrument.getInstrumentType());
        cardInstrument.setInstrumentId(instrument.getInstrumentId());
        return cardInstrument;
    }
}
