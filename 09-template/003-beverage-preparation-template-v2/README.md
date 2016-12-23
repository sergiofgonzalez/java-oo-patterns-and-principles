# 003-beverage-preparation-template-v2
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
Apart from using the *Template Method* pattern, this new design includes a hook for the Step 4.


## Design Review
The implementation satisfies the requirements and the duplication has been removed. Not only that, the design accounts for the similarities in steps 2 and 4 &mdash; we've basically implemented the *Template Method Pattern* without knowing it.

However, the design can be improved to address slight variations of the algorithm: what happens if the customer does not want condiments (sugar, milk or lemon) in their beverage?

## Principles and Patterns

### The Template Method Pattern
The *Template Method Pattern* defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
