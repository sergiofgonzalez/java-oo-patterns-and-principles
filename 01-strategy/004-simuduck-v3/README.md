# 004-simuduck-v2
> Applying Strategy design pattern and moving common code to base class

## Application Requirements
SimUDuck is an application that models Ducks for a simulator. This application is expected to feature different types of Ducks, so some features should be added to foster **reusability** and prevent **code duplication**.
The application should be extensible, so new types of Ducks can be added with minimal effort.

### New Requirements
Several types of Ducks must be supported:
+ Rubber Ducks &mdash; do not fly, instead of quack they squeak
+ Decoy Ducks &mdash; do not fly, do not quack

It might be possible the behavior of ducks at runtime (i.e. change the quack implementation)

## Proposed Design
Create a `Duck` base class with the common functionality and apply the Strategy design pattern to be able to set the behavior for flying and quacking.


## Design Review
Good use of the Strategy pattern, coding to interfaces and even inheritance.


## Principles and Patterns
### Desing Principles
**Code to an interface, not to an implementation.**

This is used in the declaration of the fly and quack behaviors: instead of using concrete classes the interface is defined. 

**Favor composition over inheritance**
Again, used in the declaration of the fly and quack behaviors.

### Patterns
**The Strategy pattern**
The Strategy design pattern defines a family of algorithms, encapsulates each one and makes them interchangeable.
Strategy lets the algorithm vary independently from the clients that use it.

In our example, we created a family of algorithms that implemented some behaviors and defined the interfaces that encapsulated them. After that, we declared fields for the interfaces and let the clients of the class selected the actual implementation for those interfaces, so that the behavior can change (even in runtime) if desired.