# 003-remote-ctrl-api-v2
> using the Command Pattern

## Application Requirements

### New Requirement
The new version of the remote control, apart from the 14 buttons for the slots, feature a single *undo* button that reverts the last action.

### Pre-existing Requirements
Create an API for programming a remote control that provides several (one to seven) slots each slot featuring only two buttons (one for ON, one for OFF), and each slot is supposed to control a particular device (lights, garage door, audio equipment, ...)

The API for programming the remote must support an existing set of specialized vendor classes that control each of the devices, and must be open to support future devices.

## Proposed Design
The previous design is slightly modified to handle the *undo* functionality. 

The `Command` interface is modified to include the `undo` method. Then, the *concrete commands* implementation have to be revised to be able to handle the state and be able to undo the last action.

In the `RemoteControl` a new command slot is introduced, and whenever a command is executed, the programmable action associated to the undo button is changed.

## Design Review
The design satisfies all of the requirements. No major changes are needed because the *Command Pattern* encapsulates the action.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 