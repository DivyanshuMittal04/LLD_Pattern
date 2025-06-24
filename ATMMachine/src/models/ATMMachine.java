package models;

import ATMStates.ATMState;
import ATMStates.IdleState;

public class ATMMachine {
    public ATMState getAtmState() {
        return atmState;
    }

    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    ATMState atmState;
    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    public int getAtmBalance() {
        return atmBalance;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public ATMMachine(int noOfOneHundredNotes, int noOfFiveHundredNotes, int noOfTwoThousandNotes) {
        this.atmState = new IdleState();
        this.noOfOneHundredNotes = noOfOneHundredNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        updateBalance();
    }

    public void reduceTwoThousandNotes(int notesReduced){
        this.noOfTwoThousandNotes -= notesReduced;
    }

    public void reduceFiveHundredNotes(int notesReduced){
        this.noOfFiveHundredNotes -= notesReduced;
    }

    public void reduceOneHundredNotes(int notesReduced){
        this.noOfOneHundredNotes -= notesReduced;
    }

    public void updateBalance(){
        this.atmBalance = 100*noOfOneHundredNotes + 500*noOfFiveHundredNotes + 2000*noOfTwoThousandNotes;
    }
}
