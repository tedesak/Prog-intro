import java.io.Closeable;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.lang.StringBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MyScanner implements Closeable {
    private int bufferSize ;
    private int posLast;
    private int endOfFile;
    private Reader reader;
    private char[] buffer;
    
    public MyScanner(InputStream input) throws IOException {
        bufferSize = 1024;
        posLast = bufferSize;
        endOfFile = bufferSize + 2;
        reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        buffer = new char[bufferSize];
    }

    private void updateBuffer() throws IOException {
        posLast = 0;
        endOfFile = reader.read(buffer, 0, bufferSize);
        if (endOfFile == -1) {
            endOfFile = 0;
        }
    }

    public int read() throws IOException {
        if (posLast == bufferSize) {
            this.updateBuffer();
        }
        if (posLast != endOfFile) {
            posLast++;
            return buffer[posLast - 1];
        } else {
            return -1;
        }
    }

    public int readWithoutChange() throws IOException {
        if (posLast == bufferSize) {
            this.updateBuffer();
        }
        if (posLast != endOfFile) {
            return buffer[posLast];
        } else {
            return -1;
        }
    }

    public String nextString() throws IOException { // NOTE модификаторы дсоутпа
        StringBuilder newString = new StringBuilder();
        int a = this.read();
        while (Character.isWhitespace(a)) {
            a = this.read();
        }
        while (!Character.isWhitespace(a) && a >= 0) {
            newString.append((char) a);
            a = this.read();
            if (a < 0) {
                break;
            }
        }
        if (a >= 0) {
            posLast--;
        }
        return newString.toString();
    }

    public boolean hasNext() throws IOException {
        if (posLast == bufferSize) {
            this.updateBuffer();
        }
        return posLast != endOfFile;
    }

    private int parseInt(String num) { // NOTE Парсинг ручками
        int sys;
        num = num.toLowerCase();
        StringBuilder newString = new StringBuilder();
        if (num.charAt(num.length() - 1) == 'o') {
            sys = 8;
        } else {
            sys = 10;
        }
        for (int i = 0; i != num.length(); i++) {
            if (i + 1 == num.length() && sys == 8) {
                break;
            }
            if (i == 0 && (num.charAt(i) == '-' || num.charAt(i) == '+')) {
                newString.append(num.charAt(i));
                continue;
            }
            if (!Character.isDigit(num.charAt(i))) {
                newString.append(num.charAt(i) - 'a');
            } else {
                newString.append(num.charAt(i));
            }
        }
        return (int) Long.parseLong(newString.toString(), sys);
    }

    public int nextInt() throws IOException {
        String newString = this.nextString();
        if (newString.length() == 1 && !Character.isDigit(newString.charAt(0)) && !Character.isLetter(newString.charAt(0))) {
            return 0;
        }
        return this.parseInt(newString);
    }

    public void close() throws IOException {
        reader.close();
    }
}

/**
 * Exception in thread "main" java.lang.AssertionError: Line 1:
 *      expected `3`,
 *        actual `3 2 1`
 *         at base.Asserts.error(Asserts.java:75)
 *         at base.Asserts.assertTrue(Asserts.java:41)
 *         at base.Asserts.assertEquals(Asserts.java:20)
 *         at base.Runner.lambda$testEquals$0(Runner.java:36)
 *         at base.TestCounter.lambda$test$0(TestCounter.java:58)
 *         at base.TestCounter.lambda$testV$2(TestCounter.java:71)
 *         at base.Log.silentScope(Log.java:40)
 *         at base.TestCounter.testV(TestCounter.java:70)
 *         at base.TestCounter.test(TestCounter.java:57)
 *         at base.Runner.testEquals(Runner.java:30)
 *         at reverse.ReverseTester$Checker.test(ReverseTester.java:102)
 *         at reverse.ReverseTester$Checker.test(ReverseTester.java:96)
 *         at reverse.ReverseTester$Checker.test(ReverseTester.java:140)
 *         at reverse.ReverseTester.run(ReverseTester.java:67)
 *         at reverse.ReverseTester.lambda$variant$2(ReverseTester.java:44)
 *         at base.Selector.lambda$test$2(Selector.java:79)
 *         at base.Log.lambda$action$0(Log.java:18)
 *         at base.Log.silentScope(Log.java:40)
 *         at base.Log.scope(Log.java:31)
 *         at base.Log.scope(Log.java:24)
 *         at base.Selector.lambda$test$3(Selector.java:79)
 *         at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
 *         at base.Selector.test(Selector.java:79)
 *         at base.Selector.main(Selector.java:51)
 *         at reverse.FullFastReverseTest.main(FullFastReverseTest.java:15)
 */