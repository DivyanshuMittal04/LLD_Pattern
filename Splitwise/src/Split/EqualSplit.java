package Split;

import java.util.List;

public class EqualSplit implements ExpenseSplitType {
    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        double amountShouldBePresent = amount / splitList.size();
        for (Split split : splitList) {
            if (split.getAmount() != amountShouldBePresent) {
                System.out.println("Split amount " + split.getAmount() + " does not match expected amount " + amountShouldBePresent);
               return false;
            }
        }
        return true;
    }
}

