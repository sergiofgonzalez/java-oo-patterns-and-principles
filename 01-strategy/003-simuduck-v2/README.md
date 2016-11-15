# 003-simuduck-v2
> Improving the design applying the Strategy interface

## Application Requirements
SimUDuck is an application that models Ducks for a simulator. This application is expected to feature different types of Ducks, so some features should be added to foster **reusability** and prevent **code duplication**.
The application should be extensible, so new types of Ducks can be added with minimal effort.

### New Requirements
Several types of Ducks must be supported:
+ Rubber Ducks &mdash; do not fly, instead of quack they squeak
+ Decoy Ducks &mdash; do not fly, do not quack

## Proposed Design
The initial design based on class inheritance was flawed and do not support the new requirements.
In the second attempt we introduced interfaces for behaviors which partially solved the problem, but created a *maintenance nightmare* as each of the concrete classes had to provide their own implementation &mdash; no reusability.

+ Create interfaces for the behaviors: `FlyBehavior` and `QuackBehavior`
+ Provide implementations that are not linked to individual `Duck` classes for those behaviors:
  + `BasicQuack`, `SqueakQuack`, `FlyWithWings`...
+ Duck classes will feature fields `flyBehavior` and `quackBehavior` along with its setters, so that the runtime behavior can be set
+ Duck classes will feature methods `fly` and `quack` that will delegate its implementation to the `flyBehavior` and `quackBehavior`.


## Design Review
Design is good, but can be improved to reduce code duplication:
+ All the concrete classes must feature the two fields, the setters and the methods that perform the `fly` and `quack`.

**Note**
This point is controversial, and it can be argued that moving the fields, setters and methods to the base class might create an unnecessary coupling with the base class, or even provide methods to Duck types that will not make sense such as `RubberDuck.fly`. However, in this particular case, i think that the v3 is better.


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
