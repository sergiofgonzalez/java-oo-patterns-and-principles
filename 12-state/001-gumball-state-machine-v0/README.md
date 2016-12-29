# 001-gumball-state-machine-v0
> implementing a state machine

## Application Requirements
Implement a state machine controlling a classic gumball machine with 4 states:
+ No quarter: initial state
+ has quarter: user has inserted coin
+ sold: user has turned the crank after inserted a coin
+ sold out: machine is out of gumballs

## Proposed Design
We define the 4 states as an enum and the following state transitions as methods in the `GumballMachine` class:
+ insertQuarter() &mdash; user has inserted a coin
+ turnCrank() &mdash; user has turned the crank
+ ejectQuarter() &mdash; user has push the button to get the money back
+ dispense() &mdash; machine dispenses a gumball


## Design Review
The implementation satisfies the requirements and follows the classic approach for building state machines using an OO approach.

However, the design is far from elegant:
+ everything is happening inside of the `GumballMachine` class
+ all the methods corresponding to state transitions contains a lot of conditional code
+ any minor change in the requirements will affect the machine class 

## Principles and Patterns

n/a
