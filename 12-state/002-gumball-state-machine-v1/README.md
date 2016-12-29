# 002-gumball-state-machine-v1
> implementing a state machine with the State design pattern

## Application Requirements

No new requirements &mdash; only a redesign

### Previous Requirements
Implement a state machine controlling a classic gumball machine with 4 states:
+ No quarter: initial state
+ has quarter: user has inserted coin
+ sold: user has turned the crank after inserted a coin
+ sold out: machine is out of gumballs

## Proposed Design
We're going to encapsulate state objects in their own classes and then delegate to the current state when an action occurs.

1. We'll be defining a `State` interface that contains a method for every action in the Gumball machine.
2. Then, we're going to implement a State class for every state of the machine. These classes will be responsible for the behavior of the machine when it is in the corresponding state.
3. We'll delegate to the `State` class to perform the actions instead of using conditional code.

Then, in the `GumballMachine` we'll change the enumerated states for the actual *state classes* &mdash; the current state of the machine will be always one of the class instances we've defined, and the actual action is delegated to what's defined in those classes.

## Design Review
The implementation satisfies the requirements and this approach looks cleaner and more maintainable:
+ The behavior of each state is kept into its own class
+ No more conditional statements in `GumballMachine` (or anywhere else for that matters)
+ Each state is closed for modification, while `GumballMachine` is open for extension.


## Principles and Patterns

### The State Pattern
The *State* Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

