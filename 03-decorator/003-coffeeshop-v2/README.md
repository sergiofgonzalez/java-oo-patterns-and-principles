# 002-coffeeshop-v3
> ordering system for a coffee shop

## Application Requirements
A coffee shop needs to develop a domain model for their ordering system.

They are initially offering four types of coffee:
+ HouseBlend &mdash; $.89
+ DarkRoast &mdash; $.99
+ Decaf &mdash; $1.05
+ Espresso &mdash; $1.99

including a series of condiments that can be added to the coffee:
+ milk &mdash; $.10
+ soy &mdash; $.20
+ mocha &mdash; $.15
+ whip &mdash; $.10


The solution must return the description of the type of coffee and its price, so that it can be used in the ordering system to calculate the price of each order.


## Proposed Design
Over the inheritance structure of v0, apply the **Decorator** design pattern to model the coffees and condiments.

The `Beverage` class will play the *Component* role of the *Decorator* pattern, so that the different types of coffees will be the *concrete components*. The `CondimentDecorator` is used as the *Decorator*, with all the different condiments inheriting from this class.

## Design Review
The **Decorator** pattern fits perfectly in this scenario and covers all the existing requirements and is open to new changes.

## Principles and Patterns

### Principles

**Classes should be open for extension but closed for modification**
Allow classes to be easily extended to incorporate new behavior without modifying the existing code.

### Patterns
**The Decorator Design Pattern**
The *Decorator* design pattern attaches additional responsibilities to an object dynamically (at runtime). 
Decorators provide a flexible alternative to subclasses for extending functionality.