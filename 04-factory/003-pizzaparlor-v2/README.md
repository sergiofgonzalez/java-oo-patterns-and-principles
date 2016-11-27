# 003-pizzaparlor-v2
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
Create an abstract base class `Pizza` which encapsulates the different preparation stages associated to the pizza. Concrete classes are created for the concrete pizza types available. 

For the ordering and preparation, a `PizzaParlorService` is defined exposing an `orderPizza` method that takes a string that identifies the type of pizza to create. 
The method signature is:
```java
Pizza orderPizza(String type)
```

which ensures that we're coding to interfaces rather than to actual classes.

Additionally, to encapsulate what might vary from what stays the same, the creation of concrete pizzas has been encapsulated in factories `NYPizzaFactory`, `SimplePizzaFactory`. Those classes implement the same interface `PizzaFactory` which allows the `PizzaParlorService` to use only the interface and not the actual implementation.
A reference to this class is passed to the `PizzaParlorService` upon creation, so that the service neither relies on concrete pizza classes, not event in the imports.

```java
PizzaParlorService pizzaParlorService = new PizzaParlorService(new NYPizzaFactory());        

Pizza pizza = pizzaParlorService.orderPizza("cheese");
```

Note that the `*PizzaFactory` classes have control over the types of pizzas they offer (i.e. NYPizzaFactory does not provide the Greek pizza, but offers a Veggie pizza).

## Design Review
The design fits perfectly the given requirements, and the only problem may arise if we want the franchises to have control not only on the menu they provide, but also on the way in which they prepare the Pizza (which is encapsulated on the `PizzaParlorService`. 


## Principles and Patterns
### Principle
+ Encapsulate what varies

**Note:**
The factory used in this project is not a pattern, but rather an idiom. It consists in creating a class that encapsulates object instantiation so that dependent services do not have to know the details about the creation of such objects. 