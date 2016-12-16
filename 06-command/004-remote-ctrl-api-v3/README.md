# 004-remote-ctrl-api-v3
> using the Command Pattern

## Application Requirements

### New Requirement
It must be possible to assign to a slot a set of commands, instead of just one.

### Pre-existing Requirements
The new version of the remote control, apart from the 14 buttons for the slots, feature a single *undo* button that reverts the last action.

Create an API for programming a remote control that provides several (one to seven) slots each slot featuring only two buttons (one for ON, one for OFF), and each slot is supposed to control a particular device (lights, garage door, audio equipment, ...)

The API for programming the remote must support an existing set of specialized vendor classes that control each of the devices, and must be open to support future devices.

## Proposed Design
We just need to define a new class `MacroCommand` that implements the `Command` interface but accepts an array of `Command` objects. The `execute` method will consist in calling all the different commands in sequence.

## Design Review
The design satisfies all of the requirements. Besides, the `MacroCommand` allows for flexible programming of the actions, as it will not be needed to hardcode the actual action in a particular command. 


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 