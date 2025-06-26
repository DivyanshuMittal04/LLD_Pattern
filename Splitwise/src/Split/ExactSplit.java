package Split;

import java.util.List;

public class ExactSplit implements ExpenseSplitType{
    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double amountShouldBePresent = 0;
        for (Split split : splitList) {
            amountShouldBePresent += split.getAmount();
        }
        if(amountShouldBePresent != amount){
            System.out.println("Exact Split validation failed: Total split amount does not match the expense amount.");
            return false;
        }
        return true;
    }
}
