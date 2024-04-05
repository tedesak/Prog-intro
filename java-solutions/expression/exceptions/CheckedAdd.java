package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedAdd extends AbstractCheckedBinOperation {
    public CheckedAdd(CheckedExpressionEl exp1, CheckedExpressionEl exp2) {
        super(exp1, exp2, 1, true, true, false);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return exp1.evaluate(x, y, z) + exp2.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        return super.toString("+");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("+");
    }
}
