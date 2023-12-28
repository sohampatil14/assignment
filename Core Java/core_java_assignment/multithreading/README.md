### Multithreading

### 1. Thread Basics

Program - [./ThreadBasics.java](./ThreadBasics.java)

Output - 

```
From multithreading.ExtendingThread: 0
From multithreading.ExtendingThread: 1
From multithreading.ExtendingThread: 2
From multithreading.ExtendingThread: 3
From multithreading.ExtendingThread: 4
From multithreading.ThreadByRunnable: 0
From multithreading.ExtendingThread: 5
From multithreading.ThreadByRunnable: 1
From multithreading.ExtendingThread: 6
From multithreading.ThreadByRunnable: 2
From multithreading.ThreadByRunnable: 3
From multithreading.ExtendingThread: 7
From multithreading.ThreadByRunnable: 4
From multithreading.ExtendingThread: 8
From multithreading.ThreadByRunnable: 5
From multithreading.ExtendingThread: 9
From multithreading.ThreadByRunnable: 6
From multithreading.ThreadByRunnable: 7
From multithreading.ThreadByRunnable: 8
From multithreading.ThreadByRunnable: 9
```

### 2. Thread Pool Executor

Program - [./ThreadPools.java](./ThreadPools.java)

Output - 

```
multithreading.OutputMultiples8 is not admitted to pool.
multithreading.OutputMultiples9 is not admitted to pool.
From multithreading.OutputMultiples3: 3x1 = 3
From multithreading.OutputMultiples7: 7x1 = 7
From multithreading.OutputMultiples2: 2x1 = 2
From multithreading.OutputMultiples6: 6x1 = 6
From multithreading.OutputMultiples2: 2x1 = 2
[MonitorThread] [1/2] Active: 1, Completed: 0, Task: 1, isShutdown: false, isTerminated: false
From multithreading.OutputMultiples6: 6x2 = 12
From multithreading.OutputMultiples7: 7x2 = 14
From multithreading.OutputMultiples3: 3x2 = 6
From multithreading.OutputMultiples2: 2x2 = 4
From multithreading.OutputMultiples2: 2x2 = 4
From multithreading.OutputMultiples2: 2x3 = 6
From multithreading.OutputMultiples3: 3x3 = 9
From multithreading.OutputMultiples2: 2x3 = 6
From multithreading.OutputMultiples7: 7x3 = 21
From multithreading.OutputMultiples6: 6x3 = 18
From multithreading.OutputMultiples2: 2x4 = 8
[MonitorThread] [4/2] Active: 4, Completed: 0, Task: 6, isShutdown: true, isTerminated: false
From multithreading.OutputMultiples3: 3x4 = 12
From multithreading.OutputMultiples2: 2x4 = 8
From multithreading.OutputMultiples6: 6x4 = 24
From multithreading.OutputMultiples7: 7x4 = 28
From multithreading.OutputMultiples2: 2x5 = 10
From multithreading.OutputMultiples7: 7x5 = 35
From multithreading.OutputMultiples6: 6x5 = 30
From multithreading.OutputMultiples2: 2x5 = 10
From multithreading.OutputMultiples3: 3x5 = 15
From multithreading.OutputMultiples4: 4x1 = 4
From multithreading.OutputMultiples5: 5x1 = 5
[MonitorThread] [4/2] Active: 2, Completed: 4, Task: 6, isShutdown: true, isTerminated: false
From multithreading.OutputMultiples5: 5x2 = 10
From multithreading.OutputMultiples4: 4x2 = 8
From multithreading.OutputMultiples4: 4x3 = 12
From multithreading.OutputMultiples5: 5x3 = 15
From multithreading.OutputMultiples5: 5x4 = 20
From multithreading.OutputMultiples4: 4x4 = 16
From multithreading.OutputMultiples4: 4x5 = 20
From multithreading.OutputMultiples5: 5x5 = 25
```

### 3. Volatile Keyword

Program - [./VolatileKeyword.java](./VolatileKeyword.java)

Output - 

```
From multithreading.ValueChanger value incremented : 1
From multithreading.ValueChanger value incremented : 2
From multithreading.ValueChangeDetector value change detected : 2
From multithreading.ValueChanger value incremented : 3
From multithreading.ValueChangeDetector value change detected : 3
From multithreading.ValueChangeDetector value change detected : 4
From multithreading.ValueChanger value incremented : 4
From multithreading.ValueChangeDetector value change detected : 5
From multithreading.ValueChanger value incremented : 5
```

### 4. Thread Safety

Program - [./ThreadSafety.java](./ThreadSafety.java)

Output - 

```
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 4
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 5
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 6
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 7
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 8
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 9
From multithreading.ValueIncrementInitiator.Thread-0 value incremented : 10
From multithreading.ValueIncrementInitiator.Thread-1 value incremented : 4
From multithreading.ValueIncrementInitiator.Thread-3 value incremented : 4
From multithreading.ValueIncrementInitiator.Thread-2 value incremented : 4

Final value of AtomicValue.intAtomic: 10
```

### 5. Block Synchronized

Program - [./BlockSynchronization.java](./BlockSynchronization.java)

Output - 

```
[Thread-1-0-1]
[Thread-1-0-1, Thread-1-1-2]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5, Thread-0-0-1]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5, Thread-0-0-1, Thread-0-1-7]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5, Thread-0-0-1, Thread-0-1-7, Thread-0-2-8]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5, Thread-0-0-1, Thread-0-1-7, Thread-0-2-8, Thread-0-3-9]
[Thread-1-0-1, Thread-1-1-2, Thread-1-2-3, Thread-1-3-4, Thread-1-4-5, Thread-0-0-1, Thread-0-1-7, Thread-0-2-8, Thread-0-3-9, Thread-0-4-10]
```

### 6. Method Synchronized

Program - [./MethodSynchronization.java](./MethodSynchronization.java)

Output - 

```
multithreading.Output.Thread-0: 1
multithreading.Output.Thread-0: 2
multithreading.Output.Thread-0: 3
multithreading.Output.Thread-0: 4
multithreading.Output.Thread-0: 5
multithreading.Output.Thread-1: 1
multithreading.Output.Thread-1: 2
multithreading.Output.Thread-1: 3
multithreading.Output.Thread-1: 4
multithreading.Output.Thread-1: 5
```
