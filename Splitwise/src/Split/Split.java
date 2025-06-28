package Split;

import User.User;

public class Split {
    User user;
    double amount;
    int percentage;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public double getAmount() {
        return amount;
    }

    public int getPercentage() {
        return percentage;
    }

    public Split(User user, double amount) {
        this.user = user;
        this.amount = amount;
        this.percentage = 0;
    }
}
