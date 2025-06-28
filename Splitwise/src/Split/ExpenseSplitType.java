package Split;

import java.util.List;

public interface ExpenseSplitType {
    public boolean validateSplit(List<Split> splitList, double amount);

    public default List<Split> computeAmount(List<Split> splitList, double amount){
        return splitList;
    };
}
