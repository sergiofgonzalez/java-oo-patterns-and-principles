# 001-remote-ctrl-api-v0
> getting the feel of the Command Pattern

## Application Requirements
Create an API for programming a remote control that provides several (one to seven) slots each slot featuring only two buttons (one for ON, one for OFF), and each slot is supposed to control a particular device (lights, garage door, audio equipment, ...)

The API for programming the remote must support an existing set of specialized vendor classes that control each of the devices, and must be open to support future devices.

## Proposed Design
The vendor classes provide very different APIs one from the other, and the remote control only provides two buttons, so we must use some kind of encapsulation to be able to invoke the vendor actions from the remote control.

To get the feel of the solution, we will base our solution on the *Command* pattern but implement a very simple remote control which only features one slot and a single button that triggers an action for v0.

We define a `Command` interface that will expose a single method `execute`. Then, we create a set of *Concrete Command classes* implementing simple actions satisfying the `Command` interface.

Then, we build the remote like a class `SimpleRemoteControl` featuring a `Command` object and a `buttonWasPressed` method that will trigger the execution of the command. 


## Design Review
The `Command` object encapsulates the action that should be taken and the `SimpleRemoteControl` becomes the *invoker* of the vendor class that becomes the *receiver*. 

However, this `SimpleRemoteControl` only provides a single slot and a single button, so it must be enhanced to comply with the requirements.


## Principles and Patterns

### The Command Pattern
The *Command Pattern* encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue them or log them, and supports undoable operations.