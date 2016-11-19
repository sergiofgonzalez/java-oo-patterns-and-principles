# 002-coffeeshop-v1
> ordering system for a coffee shop

## Application Requirements
A coffee shop needs to develop a domain model for their ordering system.

They are initially offering four types of coffee:
+ HouseBlend
+ DarkRoast
+ Decaf
+ Espresso

but they're already including a series of variants with each of the coffee:
+ milk
+ soy
+ mocha
+ whip

The solution must return the description of the type of coffee and its price, so that it can be used in the ordering system to calculate the price of each order.


## Proposed Design
Over the inheritance structure of v0, enhance the base class `Beverage` to include boolean properties that model whether the coffee selected include any of the variants.

## Design Review
The design seems to comply with current requirements again, but there might be problems in the future if:
+ the base class is starting to feature a lot of fields, and will become unmanageable if more toppings and condiments are added
+ it's not possible to model an order containing a double mocha
+ there might be beverages in the future (such as iced tea or soft drinks) for which the condiments do not apply at all

The design is flawed.

## Principles and Patterns
+ none