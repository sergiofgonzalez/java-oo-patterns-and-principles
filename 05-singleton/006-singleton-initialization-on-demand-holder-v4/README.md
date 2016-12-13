# 006-singleton-initialization-on-demand-holder-v4
> implementing a thread safe, efficient, lazy-loading singleton object using the initialization on-demand holder idiom

## Application Requirements
Create a class that holds an object for which only one instance must exist at any given time &mdash; a singleton. The implementation must be thread safe, efficient and the singleton must be lazily loaded.

## Proposed Design
Based on v1 implementation, we change the implementation of the Singleton using the *Initialization on-demand* holder idiom. In this implementation, a private static class `LazyHolder` is defined within the singleton class to benefit from JVM initialization phase capabilities. 

## Design Review
The implementation is really efficient and clean. The `volatile` or `synchronized` keyword is used anymore, and just the JVM capabilities are used (it's as simple as the eagerly loaded, but actually performs in lazily loading mode).

## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.