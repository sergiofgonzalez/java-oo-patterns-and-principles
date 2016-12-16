# 002-remote-ctrl-api-v1
> using the Command Pattern

## Application Requirements
Create an API for programming a remote control that provides several (one to seven) slots each slot featuring only two buttons (one for ON, one for OFF), and each slot is supposed to control a particular device (lights, garage door, audio equipment, ...)

The API for programming the remote must support an existing set of specialized vendor classes that control each of the devices, and must be open to support future devices.

## Proposed Design
The idea from v0 is brought to life to satisfy the real requirements: programmable remote control with 7 slots, and 2 buttons per slot.

The *Command Pattern* is used to encapsulate the operation of the home device. The `RemoteControlRunner` is the *Client* then, we create concrete *Command* objects to encapsulate the actions to perform. Each of the concrete *Command* maintain a reference to the *Receiver* (the actual automation device that must perform an action).
The *Invoker* is the `RemoteControl` object, which will feature two arrays of `Command` objects that model the different actions that can be associated to each of the slots, and a couple of methods `onButtonWasPressed(slot)` and `offButtonWasPressed(slot)` that will call the `execute` method on the configured command.

As it is difficult to work with arrays and Java's `Optional` type. We define a *Null Object* `NoConfiguredCommand` to handle the slots that has not been configured yet.
 

## Design Review
The design satisfies all of the requirements. Additionally, the use of the *Null Object* removes the responsibility from the client to handle null objects.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.

### The Null Object Idiom
A *null object* is an idiom that provides an object that acts as a surrogate and does nothing (but doesn't fail) when its associated responsibilities are invoked. 