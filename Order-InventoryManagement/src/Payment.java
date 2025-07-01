public class Payment {
    public Payment(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    PaymentMode paymentMode;

    public boolean isPaymentSuccess(){
        return true;
    }
}
