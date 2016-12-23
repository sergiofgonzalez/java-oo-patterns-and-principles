# 002-beverage-preparation-template-v1
> enabling classes to hook functionality right into an encapsulated algorithm

## Application Requirements
We have to automate the preparation of coffee and tea:

|step # | Coffee preparation           | Tea Preparation            |
|-------|------------------------------|----------------------------|
| 1     | Boil some water              | Boil some water            |
| 2     | Brew coffee in boiling water | Steep tea in boiling water |
| 3     | Pour coffee in cup           | Pour tea in cup            |
| 4     | Add sugar and milk           | Add lemon                  |

## Proposed Design
There was a lot of duplication in the previous design. In this one, we create a base class `BeveragePreparationAlgorithm` that handles the common pieces (boiling water and pouring beverage in cup) and also establishes the interface so that both preparations respond to the same interface.


## Design Review
The implementation satisfies the requirements and the duplication has been removed. Not only that, the design accounts for the similarities in steps 2 and 4 &mdash; we've basically implemented the *Template Method Pattern* without knowing it.

However, the design can be improved to address slight variations of the algorithm: what happens if the customer does not want condiments (sugar, milk or lemon) in their beverage?

## Principles and Patterns

### The Template Method Pattern
The *Template Method Pattern* defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
