# 002-simuduck-v1
> Second take at SimUDuck Domain Model using interfaces

## Application Requirements
SimUDuck is an application that models Ducks for a simulator. This application is expected to feature different types of Ducks, so some features should be added to foster **reusability** and prevent **code duplication**.
The application should be extensible, so new types of Ducks can be added with minimal effort.

### New Requirements
Several types of Ducks must be supported:
+ Rubber Ducks &mdash; do not fly, instead of quack they squeak
+ Decoy Ducks &mdash; do not fly, do not quack

## Proposed Design
The initial design based on class inheritance was flawed and do not support the new requirements.

+ Remove `quack` from the `Duck` base class as it is no longer a common behavior &mdash; Now Duck only implements `swim` and declares `display` as an abstract method
+ Create `Quackable` and `Flyable` interfaces, make classes implement those interfaces when needed


## Design Review
Design is better, but is not well prepared for reuse.
For instance, Mallard ducks and Red Head ducks both fly in the exact same way, but are force to implement the `fly` method. It will create a *maintenance nightmare* if the `fly` method implementation has to be changed.


## Principles and Patterns
+ none