package Split;

import java.util.List;

public class PercentageSplit implements ExpenseSplitType{
    @Override
    public boolean validateSplit(List<Split> splitList, double amount) {
        int totalPercentage = 0;
        for (Split split : splitList) {
            totalPercentage += split.getPercentage();
        }
        if(totalPercentage != 100){
            System.out.println("Exact Split validation failed: Total split amount does not match the expense amount.");
            return false;
        }
        return true;
    }

    @Override
    public List<Split> computeAmount(List<Split> splitList, double amount){
        for (Split split : splitList) {
            split.setAmount((split.getPercentage() / 100.0) * amount);
        }
        return splitList;
    }
}
