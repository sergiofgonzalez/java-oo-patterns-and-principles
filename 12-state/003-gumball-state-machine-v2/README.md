# 003-gumball-state-machine-v2
> implementing a state machine with the State design pattern

## Application Requirements

Include a new requirement: 10% of all sales will provide two gumballs instead of one

### Previous Requirements
Implement a state machine controlling a classic gumball machine with 4 states:
+ No quarter: initial state
+ has quarter: user has inserted coin
+ sold: user has turned the crank after inserted a coin
+ sold out: machine is out of gumballs

## Proposed Design

With the *State pattern* in place, the requirement will be implemented by introducing a new state `winnerState`.

## Design Review
The implementation satisfies the requirements and this approach looks cleaner and more maintainable:
+ The behavior of each state is kept into its own class
+ No more conditional statements in `GumballMachine` (or anywhere else for that matters)
+ Each state is closed for modification, while `GumballMachine` is open for extension.


## Principles and Patterns

### The State Pattern
The *State* Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

