# 005-singleton-double-checked-locking-v3
> implementing a thread safe, efficient, lazy-loading singleton object

## Application Requirements
Create a class that holds an object for which only one instance must exist at any given time &mdash; a singleton. The implementation must be thread safe, efficient and the singleton must be lazily loaded.

## Proposed Design
Based on v1 implementation, we change the `getInstance` implementation to include the double-checked locking:
```java
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
```

We also need to tag the singleton reference as `volatile`.

## Design Review
The implementation is now efficient and access to the singleton is serialized, but only during the initial construction of the object.

## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.