package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedPow extends AbstractCheckedUnaryOperation {
    public CheckedPow(CheckedExpressionEl exp) {
        super(exp);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return countPow10(exp.evaluate(x, y, z));
    }

    private int countPow10(int x) {
        int ans = 1;
        for (;x > 0; x--)
            ans *= 10;
        return ans;
    }

    @Override
    public String toString() {
        return super.toString("pow10");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("pow10");
    }
}
