# 005-pizzaparlor-v4
> ordering system for a pizza parlor

## Application Requirements

A new requirement is received based on the previous ones:

**Previous**
A Pizza parlor needs to streamline its ordering and preparation system:

They are offering three types of pizza pies:
+ Cheese pizza
+ Pepperoni pizza
+ Clam pizza

The stages involved in the preparation of the pies are exactly the same: prepare, bake, cut and box.

Include support for franchises. The franchises should use the pre-existing code, but must be able to adapt their menu for different geographic tastes.

*Example*
+ NYPizzaFactory
+ ChicaggoPizzaFactory
+ CaliforniaPizzaFactory

**New**
The client wants to be able to provide the same types of pizzas (Cheese, Pepperoni, Clam...) but allow each of their franchises to customize the variety of the ingredients they use.
For example:
+ Dough: thin, thick, ...
+ Cheese: Mozzarella, Reggiano, ...
+ Clams: Fresh, Frozen, ...
...


## Proposed Design
We should use create a `PizzaIngredientFactory` interface which will delegate the creation of the actual ingredient to an actual implementation that will be bound to the franchise (`NYPizzaIngredientFactory`, `ChicagoPizzaIngredientFactory`, ...). 
Then, the `Pizza` classes will receive an instance of this factory on its constructor and will appropriately select the actual ingredients.   


## Design Review
The design fits perfectly the given requirements. The design provides a means of creating a family of ingredients for pizzas by using the *Abstract Factory Pattern*.

This pattern offers an interface for creating a family of products, and we decouple our code from the actual factory that creates them.

Now, all the franchises can deliver its own variations of the same Pizza while satisfying the same interface.


## Principles and Patterns
### Principles
+ Encapsulate what varies
+ Depend upon abstractions. Do not depend upon concrete classes. (Dependency Inversion Principle)

### The Factory Method Pattern
The *Factory Method Pattern* defines an interface for creating an object, but lets subclasses decide which class to instantiate.
Factory Method lets a class defer instantiation to subclasses.

### The Abstract Factory Pattern
The *Abstract Factory Pattern* provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 