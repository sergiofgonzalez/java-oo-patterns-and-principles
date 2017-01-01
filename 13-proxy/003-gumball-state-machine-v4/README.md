# 003-gumball-state-machine-v4
> implementing remote monitoring functionality using the Proxy pattern

## Application Requirements

### New Requirements
Convert the Gumball machine into a remote service so that it can be monitored remotely.

### Previous Requirements
Given the Gumball machine developed with the *State* design pattern, build a monitoring functionality that displays the location of the machine, the current number of gumballs and the state the machine is in.

E.g.:
Gumball Machine  : Odeon Theater
Current Inventory: 10 gumball(s)
Current State    : NoQuarterState

The monitor should work as an external class to the machine, so that it can be enhanced and evolved in the future.


## Proposed Design
The initial design is transformed to allow remote monitoring using Java RMI. A new interface `GumballMachineRemote` is defined. This interface declares the methods that will be available for remote invocation. Then, we change the `GumballMachine` to extend from `UnicastRemote` and implement `GumballMachineRemote`. Then minor modifications are made to make the *states* serializable, the GumballMachine reference transient, etc.

Then we create a couple of runners:
+ one to register the Gumball machines for remote monitoring on the Java RMI registry
+ another one to make the `GumballMonitor` grab a reference to the remote object and perform the invocation that allows to read the internal state of the remote gumball machine. 

## Design Review
The design satisfies the requirements.


## Principles and Patterns

### The Proxy Pattern
The **Proxy** pattern provides a surrogate or placeholder for another object to control access to it.

