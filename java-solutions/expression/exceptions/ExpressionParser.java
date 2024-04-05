package expression.exceptions;

import expression.*;

public class ExpressionParser implements TripleParser {
    @Override
    public TripleExpression parse(final String expression) {
        return parse(new StringSource(expression));
    }

    public TripleExpression parse(final CharSource expression) {
        return new Parser(expression).parse();
    }

    private static class Parser extends BaseParser {
        protected Parser(final CharSource source) {
            super(source);
        }

        public CheckedExpressionEl parse() {
            return parsePriority0();
        }

        private CheckedExpressionEl parsePriority0() {
            CheckedExpressionEl actual = parsePriority1();
            while (true) {
                skipWhitespace();
                if (take('g')) {
                    expect("cd");
                    actual = new CheckedGcd(actual, parsePriority1());
                } else if (take('l')) {
                    expect("cm");
                    actual = new CheckedLcm(actual, parsePriority1());
                } else {
                    return actual;
                }
            }
        }

        private CheckedExpressionEl parsePriority1() {
            CheckedExpressionEl actual = parsePriority2();
            skipWhitespace();
            while (!eof()) {
                if (take('+')) {
                    actual = new CheckedAdd(actual, parsePriority2());
                } else if (take('-')) {
                    actual = new CheckedSubtract(actual, parsePriority2());
                } else {
                    break;
                }
                skipWhitespace();
            }
            return actual;
        }

        private CheckedExpressionEl parsePriority2() {
            CheckedExpressionEl actual = parseUnary();
            skipWhitespace();
            while (!eof()) {
                if (take('*')) {
                    actual = new CheckedMultiply(actual, parseUnary());
                } else if (take('/')) {
                    actual = new CheckedDivide(actual, parseUnary());
                } else {
                    break;
                }
                skipWhitespace();
            }
            return actual;
        }

        private CheckedExpressionEl parseUnary() {
            CheckedExpressionEl actual;
            skipWhitespace();
            actual = reparseUnary();
            skipWhitespace();
            return actual;
        }

        private CheckedExpressionEl reparseUnary() {
            if (take('-')) {
                if (between('0', '9')) {
                    return parseConst(true);
                } else {
                    return new CheckedNegate(parseUnary());
                }
            } else if (take('r')) {
                expect("everse");
                return new CheckedReverse(parseUnary());
            } else if (take('(')) {
                CheckedExpressionEl actual = parse();
                skipWhitespace();
                take(')');
                return actual;
            } else if (take('l')) {
                expect("og10");
                return new CheckedLog(parseUnary());
            } else if (take('p')) {
                expect("ow10");
                return new CheckedPow(parseUnary());
            }
            else {
                return parseNumber();
            }
        }

        private CheckedExpressionEl parseNumber() {
            CheckedExpressionEl actual;
            skipWhitespace();
            if (between('0', '9') || test() == '-') {
                actual = parseConst(false);
            } else {
                actual = parseVariable();
            }
            return actual;
        }

        private CheckedExpressionEl parseVariable() {
            CheckedExpressionEl actual;
            skipWhitespace();
            if (take('x')) {
                actual = new Variable("x");
            } else if (take('y')) {
                actual = new Variable("y");
            } else if (take('z')) {
                actual = new Variable("z");
            } else {
                throw new IllegalArgumentException("Illegal variable name");
            }
            return actual;
        }

        private CheckedExpressionEl parseConst(boolean wasMinus) {
            final StringBuilder sb = new StringBuilder();
            if (wasMinus) {
                sb.append('-');
            }
            takeInteger(sb);
            try {
                final int val = Integer.parseInt(sb.toString());
                return new Const(val);
            } catch (final NumberFormatException e) {
                throw error("Invalid number " + sb);
            }
        }

        private void takeInteger(final StringBuilder sb) {
            if (take('-')) {
                sb.append('-');
            }
            if (take('0')) {
                sb.append(0);
                return;
            }
            while (between('0', '9')) {
                sb.append(take());
            }
        }

        private boolean skipWhitespace() {
            boolean wasSkip = false;
            while (Character.isWhitespace(test())) {
                take();
                wasSkip = true;
            }
            return wasSkip;
        }
    }

    public static void main(final String... args) {
        System.out.println(new ExpressionParser().parse("x gcdx"));
    }
}
