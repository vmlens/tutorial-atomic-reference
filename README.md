# tutorial-atomic-reference

This tutorial shows why we need the class `AtomicReference` and how to use it.

Run the test with maven using:
```
mvn install
```

The test uses a not thread safe implementation, the class `com.vmlens.tutorialAtomicReference.UpdateStateNotThreadSafe`. To change to a thread safe implementation change the object variable in the test
`com.vmlens.tutorialAtomicReference.ConcurrencyTestUpdateState` to `UpdateStateWithCompareAndSet`. 

The tutorial is described in greater detail in [this blog post](https://vmlens.com/articles/cp/atomic_reference/)
