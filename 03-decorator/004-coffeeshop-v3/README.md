# 004-coffeeshop-v3
> ordering system for a coffee shop

## Application Requirements
A coffee shop needs to develop a domain model for their ordering system.

They are initially offering four types of coffee in three different sizes:
| coffee     | tall  | grande | venti  |
| :--:       | :--   | :--    | :--    |
| HouseBlend | $0.89 | +$0.10 | +$0.15 |
| DarkRoast  | $0.99 | +$0.10 | +$0.15 |
| Decaf      | $1.05 | +$0.10 | +$0.15 |
| Espresso   | $1.99 | +$0.10 | +$0.15 |   

And the following condiments:
| coffee | tall  | grande | venti  |
| :--:   | :--   | :--    | :--    |
| Milk   | $0.10 | +$0.15 | +$0.20 |
| Soy    | $0.20 | +$0.25 | +$0.30 |
| Mocha  | $0.15 | +$0.20 | +$0.25 |
| Whip   | $0.10 | +$0.15 | +$0.20 |


The solution must return the description of the type of coffee and its price, so that it can be used in the ordering system to calculate the price of each order.

## Proposed Design
Over the inheritance structure of v0, apply the **Decorator** design pattern to model the coffees and condiments.

The `Beverage` class will play the *Component* role of the *Decorator* pattern, so that the different types of coffees will be the *concrete components*. The `CondimentDecorator` is used as the *Decorator*, with all the different condiments inheriting from this class.

For managing the size we introduce a small modification on the *component* base class so that now it requires the *size* to be specified to construct an object. The *decorator* is also slightly modified to read the size of the associated beverage and use it to se the size of the *condiment*.

## Design Review
The **Decorator** pattern fits perfectly in this scenario and covers all the existing requirements and is open to new changes. With this example we've proved that new additions and extensions are possible.

However, there's a lot of code duplication that should be either moved into the base class or encapsulated in an interface implementation. The second one seems more flexible, as you would be able to use different algorithms if needed, but might be a little bit of an overkill.

## Principles and Patterns

### Principles

**Classes should be open for extension but closed for modification**
Allow classes to be easily extended to incorporate new behavior without modifying the existing code.

### Patterns
**The Decorator Design Pattern**
The *Decorator* design pattern attaches additional responsibilities to an object dynamically (at runtime). 
Decorators provide a flexible alternative to subclasses for extending functionality.