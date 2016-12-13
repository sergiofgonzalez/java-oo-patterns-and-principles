# 003-singleton-v1
> implementing a thread safe singleton object

## Application Requirements
Create a class that holds an object for which only one instance must exist at any given time &mdash; a singleton. The implementation must be thread safe.

## Proposed Design
Same approach as v0, but we make the `getInstance` method thread safe by declaring the method as `synchronized`.

## Design Review
The design and implementation looks good even for multi-threaded scenarios. However, performance problems may arise if we get lots of threads calling `getInstance` as now the access to this method is serialized.

Moreover, the only point in which we need synchronization of threads is during the initial construction of the object.

## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.