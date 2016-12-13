# 004-singleton-eagerly-loading-v2
> implementing an eagerly loaded thread safe singleton object

## Application Requirements
Create a class that holds an object for which only one instance must exist at any given time &mdash; a singleton. The implementation must be thread safe and must be efficient.

## Proposed Design
The `synchronized` keyword used to serialize access to `getInstance` method seriously impacts performance. One simple, yet direct, option is to let the JVM do the synchronization by creating the instance statically.

## Design Review
The design and implementation looks good for multi-threaded scenarios under heavy load. The only "but" is that the singleton instance is always created no matter whether it will be used or not.

## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.