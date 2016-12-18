# 005-remote-ctrl-api-v4
> using the Command Pattern

## Application Requirements

### New Requirement
Reduce the number of classes using Lambdas. There is no need for *undo* functionality;

## Proposed Design
We remove all the *concrete command* classes and use inline lambdas instead. The `undo` method from the `Command` interface has been removed as the lambdas required *functional interfaces* (that is, interfaces that define a single method).

## Design Review
The usage of lambdas reduce the number of classes required to implement the Command classes. However, all the lambdas are defined inline, it would be better if those were defined in separate classes.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 