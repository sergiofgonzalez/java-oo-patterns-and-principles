# 007-remote-ctrl-api-v6
> using the Command Pattern

## Application Requirements

### New Requirement
Reduce the number of classes using Lambdas. There is no need for *undo* functionality.

## Proposed Design
The design from v5 used utility classes that defined Functions for the commands. In this alternative version, we also use utility classes but keep the reference to the *Receiver* in the utility classes themselves to reduce the verbosity in the *Invoker*. 

## Design Review
An alternative version. Now the utility classes are more verbose and the *Invoker* is cleaner.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 