# 002-chocoboiler-v0
> applying the singleton pattern v0 to a use case

## Application Requirements
Create the controller class for the boiler of a chocolate factory. This piece of equipment is in charge of taking chocolate and milk, bring them to a boild and them pass them on to the next phase.

The controller class `ChocolateBoiler` must ensure:
+ its initial state consists of an empty boiler
+ must provide operations for filling, draining and boil
+ must provide operations to verify the state of the boiler (empty?, boiled?)
+ it cannot accept certain operations:
  + boiling is not acceptable when the boiler is empty
  + boiler can be filled only when empty
  + contents can be drained only when filled and boiled

## Proposed Design
Using the same implementation approach from 001-singleton-v0 create a Singleton class implementing the requirements.

## Design Review
The design and implementation looks good. However, problems may arise if we plan to use this class in a multithreaded program &mdash; the implementation of this Singleton is not thread safe.


## Principles and Patterns

### The Singleton Pattern
The *Singleton Pattern* ensures a class has only one instance, and provides a global point of access to it.