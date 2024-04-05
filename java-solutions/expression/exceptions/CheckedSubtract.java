package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedSubtract extends AbstractCheckedBinOperation {
    public CheckedSubtract(CheckedExpressionEl exp1, CheckedExpressionEl exp2) {
        super(exp1, exp2, 1, true, false, false);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return exp1.evaluate(x, y, z) - exp2.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        return super.toString("-");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("-");
    }
}
