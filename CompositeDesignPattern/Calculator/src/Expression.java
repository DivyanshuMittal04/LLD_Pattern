public class Expression implements ArithmeticExpression {
    ArithmeticExpression left;
    ArithmeticExpression right;
    Operation operation;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, Operation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        int result = 0;
        switch (operation) {
            case ADD ->  result = left.evaluate() + right.evaluate();
            case SUBTRACT -> result = left.evaluate() - right.evaluate();
            case  MULTIPLY -> result = left.evaluate() * right.evaluate();
            case DIVIDE -> result = left.evaluate() / right.evaluate();
        }
        return result;
    }
}
