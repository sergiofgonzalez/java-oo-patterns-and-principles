# 005-pizzaparlor-v4
> ordering system for a pizza parlor

## Application Requirements

A new requirement is received based on the previous ones:

**Previous**
A Pizza parlor needs to streamline its ordering and preparation system:

They are offering three types of pizza pies:
+ Cheese pizza
+ Greek pizza
+ Pepperoni pizza

The stages involved in the preparation of the pies are exactly the same: prepare, bake, cut and box.

**New**
Include support for franchises. The franchises should use the pre-existing code, but must be able to adapt their menu for different geographic tastes.

*Example*
+ NYPizzaFactory
+ ChicaggoPizzaFactory
+ CaliforniaPizzaFactory


## Proposed Design
The design from v2 has been refactored to give the franchises total control on how they handle object instantiation.

An abstract class `PizzaParlor` has been created with two methods:

```java
    public Pizza orderPizza(String type);
    public abstract Pizza createPizza(String type);
```

The `orderPizza` is completely implemented and perform the well-known sequence of steps needed to order the pizza (prepare, bake, etc.) and delegates the object creation to the `createPizza` abstract method.

All the franchises *must* subclass `PizzaParlor` and therefore, will get the `orderPizza` default implementation and will also be forced to implement the `createPizza`, so they will be able to provide bespoke implementations according to the local geo tastes for their Pizzas (`NYStyleCheesePizza`, `ChicagoStylePizza`...). 


## Design Review
The design fits perfectly the given requirements, and although the previous design was also correct, this one is more aligned with the known design patterns.

Now the subclasses of `PizzaParlor` handle object instantiation in the `createPizza` method, which is a **factory method**.


## Principles and Patterns
### Principles
+ Encapsulate what varies
+ Depend upon abstractions. Do not depend upon concrete classes. (Dependency Inversion Principle)

### The Factory Method Pattern
The *Factory Method Pattern* defines an interface for creating an object, but lets subclasses decide which class to instantiate.
Factory Method lets a class defer instantiation to subclasses.

 