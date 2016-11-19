# 001-coffeeshop-v0
> ordering system for a coffee shop

## Application Requirements
A coffee shop needs to develop a domain model for their ordering system.

They will initially offer four types of coffee:
+ HouseBlend
+ DarkRoast
+ Decaf
+ Espresso

The solution must return the description of the type of coffee and its price, so that it can be used in the ordering system to calculate the price of each order.

It might be possible that new types of coffees might be added in the future.

## Proposed Design

Create a simple inheritance structure, `Beverage` being an abstract class providing a `description` field and an abstract `cost` method that must be implemented by the four classes modeling the four types of coffees.

## Design Review
The design is OK for the four types of coffees that are currently offered, but we devised a problem if the variants and types of coffee grow.

For example, imagine that they start adding variants such as the capability of adding whipped cream, soy milk, mocha... you'd have to create classes for each of the individual variants, thus having to create classes such as `HouseBlendWithSteamedMilkAndMocha` and `DarkRoastWithWhippedCreamAndSoyMilk`.

## Principles and Patterns
+ none