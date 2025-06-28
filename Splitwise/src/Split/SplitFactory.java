package Split;

import Expense.SplitType;
import User.User;

public class SplitFactory {
    public static ExpenseSplitType getExpenseSplitType(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualSplit();
            case EXACT:
                return new ExactSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                throw new IllegalArgumentException("Invalid split type: " + splitType);
        }
    }
}
