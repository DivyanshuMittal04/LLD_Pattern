public class Address {
    String pinCode;
    String City;
    String State;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public Address(String pinCode, String city, String state) {
        this.pinCode = pinCode;
        City = city;
        State = state;
    }
}
