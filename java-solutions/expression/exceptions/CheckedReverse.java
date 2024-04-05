package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedReverse extends AbstractCheckedUnaryOperation {
    public CheckedReverse(CheckedExpressionEl exp) {
        super(exp);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculateReverse(exp.evaluate(x, y, z));
    }

    int calculateReverse(int x) {
        int y = 0;
        for (; x != 0; x /= 10) {
            y = y * 10 + x % 10;
        }
        return y;
    }

    @Override
    public String toString() {
        return super.toString("reverse");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("reverse");
    }
}
