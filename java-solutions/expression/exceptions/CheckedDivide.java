package expression.exceptions;

import expression.CheckedExpressionEl;

public class CheckedDivide extends AbstractCheckedBinOperation {
    public CheckedDivide(CheckedExpressionEl exp1, CheckedExpressionEl exp2) {
        super(exp1, exp2, 2, false, false, false);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int res2 = exp2.evaluate(x ,y ,z);
        if (res2 == 0) {
            //throw new DivisionByZeroException(" ");
        }
        return exp1.evaluate(x, y, z) / exp2.evaluate(x, y, z);
    }

    @Override
    public String toString() {
        return super.toString("/");
    }

    @Override
    public String toMiniString() {
        return super.toMiniString("/");
    }
}
