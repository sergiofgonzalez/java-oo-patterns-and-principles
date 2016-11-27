# 002-pizzaparlor-v1
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

Additionally, to encapsulate what might vary from what stays the same, the creation of concrete pizzas has been encapsulated in a factory `SimplePizzaFactory`. A reference to this class is passed to the `PizzaParlorService` upon creation, so that the service does no longer rely on concrete pizza classes, not event in the imports.

## Design Review
The design fits perfectly the given requirements and its prepared to handle further extensibility requirements (such as new pizza types) without requiring additional design effort.


## Principles and Patterns
### Principle
+ Encapsulate what varies

**Note:**
The factory used in this project is not a pattern, but rather an idiom. It consists in creating a class that encapsulates object instantiation so that dependent services do not have to know the details about the creation of such objects. 