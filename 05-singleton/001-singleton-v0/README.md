# 001-singleton-v0
> implementing a singleton object

## Application Requirements
Create a class that holds an object for which only one instance must exist at any given time &mdash; a singleton.

## Proposed Design
Create a regular class `Singleton` that holds a reference to an instance of the same `Singleton` class and make that instance `static`. This will ensure that only one instance can exist.

Then, make the constructor for the `Singleton` class private, so that no one can instantiate objects of this class. 

Then, provide a method that will return a reference to the static singleton instance.

## Design Review
The design and implementation looks good. However, problems may arise if we plan to use this class in a multithreaded program &mdash; the implementation of this Singleton is not thread safe.


## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.