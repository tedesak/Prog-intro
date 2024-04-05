```shell
Tests: running
WARNING: A command line option has enabled the Security Manager
WARNING: The Security Manager is deprecated and will be removed in a future release
Testing Base
    Running test 01: java Wspp "test1.in" "test1.out"
    Running test 02: java Wspp "test2.in" "test2.out"
    Running test 03: java Wspp "test3.in" "test3.out"
    Running test 04: java Wspp "test4.in" "test4.out"
    Running test 05: java Wspp "test5.in" "test5.out"
    Running test 06: java Wspp "test6.in" "test6.out"
    Running test 07: java Wspp "test7.in" "test7.out"
    Running test 08: java Wspp "test8.in" "test8.out"
    Running test 09: java Wspp "test9.in" "test9.out"
    Running test 10: java Wspp "test10.in" "test10.out"
    Running test 11: java Wspp "test11.in" "test11.out"
    Running test 12: java Wspp "test12.in" "test12.out"
Testing CountLastL
    Running test 13: java WsppCountLastL "test13.in" "test13.out"
    Running test 14: java WsppCountLastL "test14.in" "test14.out"
    Running test 15: java WsppCountLastL "test15.in" "test15.out"
Exception in thread "main" java.lang.AssertionError: Line 1:
     expected `сидел 1 1`,
       actual `сидел 1 2`
        at base.Asserts.error(Asserts.java:75)
        at base.Asserts.assertTrue(Asserts.java:41)
        at base.Asserts.assertEquals(Asserts.java:20)
        at base.Runner.lambda$testEquals$0(Runner.java:36)
        at base.TestCounter.lambda$test$0(TestCounter.java:58)
        at base.TestCounter.lambda$testV$2(TestCounter.java:71)
        at base.Log.silentScope(Log.java:40)
        at base.TestCounter.testV(TestCounter.java:70)
        at base.TestCounter.test(TestCounter.java:57)
        at base.Runner.testEquals(Runner.java:30)
        at base.MainChecker.testEquals(MainChecker.java:25)
        at wordStat.WordStatChecker.test(WordStatChecker.java:66)
        at wordStat.WordStatChecker.test(WordStatChecker.java:49)
        at wspp.WsppTester.lambda$variant$9(WsppTester.java:80)
        at wordStat.WordStatChecker.test(WordStatChecker.java:44)
        at wspp.WsppTester.lambda$variant$10(WsppTester.java:23)
        at base.Selector.lambda$test$2(Selector.java:79)
        at base.Log.lambda$action$0(Log.java:18)
        at base.Log.silentScope(Log.java:40)
        at base.Log.scope(Log.java:31)
        at base.Log.scope(Log.java:24)
        at base.Selector.lambda$test$3(Selector.java:79)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        at base.Selector.test(Selector.java:79)
        at base.Selector.main(Selector.java:51)
        at wspp.FullWsppTest.main(FullWsppTest.java:57)
ERROR: Tests: failed
```