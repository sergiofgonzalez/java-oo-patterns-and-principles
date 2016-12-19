# 005-remote-ctrl-api-v4
> using the Command Pattern

## Application Requirements

### New Requirement
Reduce the number of classes using Lambdas. There is no need for *undo* functionality.

## Proposed Design
Instead of defining the lambdas inline, holder classes are defined to group the commands.

## Design Review
The holder classes lead to a more organized implementation.

## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 