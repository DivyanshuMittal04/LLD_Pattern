package BalanceSheet;

import User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
    Map<User, Integer> userVsBalance;
    double totalYourExpense;

    double totalPayment;

    double totalYouOwe;
    double totalYouGetBack;

    public BalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

    public Map<User, Integer> getUserVsBalance() {
        return userVsBalance;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void updateBalance(User user, double amount){
        if(userVsBalance.containsKey(user)){
            userVsBalance.put(user, userVsBalance.get(user) + (int)amount);
        }else{
            userVsBalance.put(user, (int)amount);
        }

        if(amount > 0){
            totalYouGetBack += amount;
        }else{
            totalYouOwe += Math.abs(amount);
        }
    }

    public List<User> getAllUsers() {
        return userVsBalance.keySet().stream().toList();
    }

    public double getBalanceForUser(User user) {
        return userVsBalance.getOrDefault(user, 0);
    }
}
