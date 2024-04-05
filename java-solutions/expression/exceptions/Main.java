package expression.exceptions;

import expression.CheckedExpressionEl;
import expression.TripleExpression;

public class Main {
    public static void main(String[] args) {
        String s = """
                abacaba
                   bacaba
                  saasd
                """;
        System.out.println(s);
        ExpressionParser parser = new ExpressionParser();
        TripleExpression exp = parser.parse(new StringSource("1000000*x*x*x*x*x/(x-1)"));
        System.out.println(exp.evaluate(0,0,0));
    }
}
