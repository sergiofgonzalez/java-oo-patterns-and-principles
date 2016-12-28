# 002-mixing-menu-implementations-v5
> refactoring existing code to make it scale with the Composite and Iterator pattern

## Application Requirements

### Previous Requirements
We have an application that manages restaurant menus. The menus are subdivided into breakfast, lunch, dessert for lunch and dinner.

We need to implement support for the following methods:
+ `printMenu` &mdash; prints every item on the menu
+ `printBreakfastMenu` &mdash; prints breakfast dishes
+ `printLunchMenu` &mdash; prints just lunch items
+ `printDinnerMenu` &mdash; prints just dinner items
+ `printVegetarianMenu` &mdash; prints all vegetarian menu items


## Proposed Design
We have added a `createIterator` method to the `MenuComponent`, so that external classes (like `MenuServices`) can iterate over the elements of the *Composite*.
The implementation is quite convoluted, as we need to iterate over the elements of a tree, keeping track of where we are in each of the steps. For the iteration on the `MenuItem` we have defined a *no-op Iterator* and we've called it `NullIterator`.

Now the `MenuServices` can iterate over the elements of the *Composite* in the easiest way. 

## Design Review
Now the design will scale well with new additions of items and menus, and all the required methods can be easily implemented.
The only ugly part is having to catch the `UnsupportedOperationException` while printing the vegetarian dishes.

## Principles and Patterns

### The Composite Pattern
The *Composite* pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and composition of objects uniformly.
