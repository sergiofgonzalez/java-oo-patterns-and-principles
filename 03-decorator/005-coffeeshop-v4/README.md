# 005-coffeeshop-v4
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

To remove code duplication from previous version, the `Beverage` base class and the `CondimentDecorator` now includes the price computation algorithm. 

## Design Review
The **Decorator** pattern fits perfectly in this scenario and covers all the existing requirements and is open to new changes. With this example we've proved that new additions and extensions are possible.

The new design removes the code duplication seen in previous versions, but it would be less flexible if we the algorithm to change the prices has to be updated from beverage to beverage and from condiment to condiment.

## Principles and Patterns

### Principles

**Classes should be open for extension but closed for modification**
Allow classes to be easily extended to incorporate new behavior without modifying the existing code.

### Patterns
**The Decorator Design Pattern**
The *Decorator* design pattern attaches additional responsibilities to an object dynamically (at runtime). 
Decorators provide a flexible alternative to subclasses for extending functionality.