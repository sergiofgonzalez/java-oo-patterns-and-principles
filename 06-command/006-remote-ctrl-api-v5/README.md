# 006-remote-ctrl-api-v5
> using the Command Pattern

## Application Requirements

### New Requirement
Reduce the number of classes using Lambdas. There is no need for *undo* functionality.

## Proposed Design
The design from v4 used inline lambdas. This reduced verbosity, but it is also true that the functionality was bound in the *Invoker* through hardwired inline lambdas.
In this take, we define instead utility classes to hold the lambdas, and inside the classes we define:
 ```java
    public static Function<Device,Command> deviceActionFn = device -> () -> device.action();
 ```

Then, in the *Invoker* we use the `apply` method to bind the functionality to an specific device and obtain the *command*.


## Design Review
Note that although the functions are more organized now, the verbosity in the *Invoker* has largely increased.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 