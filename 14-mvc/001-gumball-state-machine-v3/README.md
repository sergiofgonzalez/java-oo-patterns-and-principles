# 001-gumball-state-machine-v3
> implementing monitoring functionality

## Application Requirements

Given the Gumball machine developed with the *State* design pattern, build a monitoring functionality that displays the location of the machine, the current number of gumballs and the state the machine is in.

E.g.:
Gumball Machine  : Odeon Theater
Current Inventory: 10 gumball(s)
Current State    : NoQuarterState

The monitor should work as an external class to the machine, so that it can be enhanced and evolved in the future.


## Proposed Design

Create a `GumballMonitor` class that exposes a `report` method that displays the required info from the gumball machine.

## Design Review
The design satisfies the requirements and there are no major improvements that can be done.


## Principles and Patterns

n/a

