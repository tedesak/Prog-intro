package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedLcm extends AbstractCheckedBinOperation {
    public CheckedLcm(CheckedExpressionEl exp1, CheckedExpressionEl exp2) {
        super(exp1, exp2, 0, false, false, true);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculateLcm(exp1.evaluate(x, y, z), exp2.evaluate(x, y, z));
    }

    private int calculateLcm(int x, int y) {
        int oldX = x, oldY = y;
        while (y != 0) {
            x %= y ;
            int z = y;
            y = x;
            x = z;
        }
        x = x > 0 ? x : -x;
        if (x == 0) {
            return 0;
        }
        return (int) (oldX / x * oldY);
    }

    @Override
    public String toString() {
        return super.toString("lcm");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("lcm");
    }
}
