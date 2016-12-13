# 05-singleton
> one instance of an object at any given time

## Projects

### 001-singleton-v0
The first *naive* take on creating a singleton object &mdash; a one-of-a-kind object for which there is only one instance at any given time. 
The implementation is not thread safe.

### 002-chocoboiler-v0
Using the previous approach to a use case involving a simple state machine for a chocolate boiler.
The implementation is not thread safe.

### 003-singleton-v1
A thread-safe implementation of the Singleton pattern. The global point of access to the single instance of the class is serialized using the `synchronized` method, which might severely affect performance.

### 004-singleton-eagerly-loading-v2
A thread-safe implementation of the Singleton pattern in which the instance is eagerly loaded. The implementation is really efficient if the singleton is always used.

### 005-singleton-double-checked-locking-v3
A thread-safe implementation of the Singleton pattern in which the instance is lazily loaded, and performance is fostered by using a double checked locking.

### 006-singleton-initialization-on-demand-holder-v4
A thread-safe implementation of the Singleton pattern in which the instance is lazily loaded, and performance is fostered by using initialization-on-demand holder idiom.