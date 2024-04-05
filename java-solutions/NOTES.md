WARNING: A command line option has enabled the Security Manager
WARNING: The Security Manager is deprecated and will be removed in a future release
Testing Base
    Running test 01: java Reverse [1 input lines]
    Running test 02: java Reverse [2 input lines]
Exception in thread "main" java.lang.AssertionError: Line 1:
     expected `3`,
       actual `3 2 1`
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
        at reverse.ReverseTester$Checker.test(ReverseTester.java:102)
        at reverse.ReverseTester$Checker.test(ReverseTester.java:96)
        at reverse.ReverseTester$Checker.test(ReverseTester.java:140)
        at reverse.ReverseTester.run(ReverseTester.java:67)
        at reverse.ReverseTester.lambda$variant$2(ReverseTester.java:44)
        at base.Selector.lambda$test$2(Selector.java:79)
        at base.Log.lambda$action$0(Log.java:18)
        at base.Log.silentScope(Log.java:40)
        at base.Log.scope(Log.java:31)
        at base.Log.scope(Log.java:24)
        at base.Selector.lambda$test$3(Selector.java:79)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        at base.Selector.test(Selector.java:79)
        at base.Selector.main(Selector.java:51)
        at reverse.FullFastReverseTest.main(FullFastReverseTest.java:15)

