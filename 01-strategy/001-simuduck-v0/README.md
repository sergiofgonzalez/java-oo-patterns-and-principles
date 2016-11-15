# 001-simuduck-v0
> First take at SimUDuck Domain Model using plain inheritance

## Application Requirements
SimUDuck is an application that models Ducks for a simulator. This application is expected to feature different types of Ducks, so some features should be added to foster **reusability** and prevent **code duplication**.
The application should be extensible, so new types of Ducks can be added with minimal effort.

## Proposed Design
+ Use inheritance to provide common behaviors to derived classes:
  + Create a `Duck` base class with the common behaviors: `quack` and `swim`
  + The `Duck` class also contains an abstract method `display` (that is used to identify the concrete class) 
  + Subclasses must forcefully implement its own `display` method, and can override `quack` and `swim` as needed.

## Design Review
Class inheritance is not good for extensibility:
If we want our Ducks to fly we should either create a `fly` method on Duck, which may provide the fly behaviors to Ducks that should not fly, or declare and implement `fly` on each and every subclass.

The design is flawed.

## Principles and Patterns
+ none