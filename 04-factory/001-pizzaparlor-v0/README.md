# 001-pizzaparlor-v0
> ordering system for a pizza parlor

## Application Requirements
A Pizza parlor needs to streamline its ordering and preparation system:

They are offering three types of pizza pies:
+ Cheese pizza
+ Greek pizza
+ Pepperoni pizza

The stages involved in the preparation of the pies are exactly the same: prepare, bake, cut and box.

## Proposed Design
Create an abstract base class `Pizza` which encapsulates the different preparation stages associated to the pizza. Concrete classes are created for the concrete pizza types available. 

For the ordering and preparation, a `PizzaParlorService` is defined exposing an `orderPizza` method that takes a string that identifies the type of pizza to create. 
The method signature is:
```java
Pizza orderPizza(String type)
```

which ensures that we're coding to interfaces rather than to actual classes.

## Design Review
The design is OK for the requirements given, but we're failing to encapsulate what varies from what stays the same on the `orderPizza` method: if new types of pizzas are added, we will have to change the method when that should not be necessary if we take away the creation logic from that method. 


## Principles and Patterns
+ none