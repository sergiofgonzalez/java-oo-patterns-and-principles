# 001-mixing-menu-implementations-v4
> refactoring existing code to make it scale the with the Composite pattern

## Application Requirements

### Previous Requirements
We have an application that manages restaurant menus. The menus are subdivided into breakfast, lunch, dessert for lunch and dinner.

We need to implement support for the following methods:
+ `printMenu` &mdash; prints every item on the menu
+ `printBreakfastMenu` &mdash; prints breakfast dishes
+ `printLunchMenu` &mdash; prints just lunch items
+ `printVegetarianMenu` &mdash; prints all vegetarian menu items


## Proposed Design
We clearly need to use the *Composite* pattern to make the structure scale as new menus and menu items are added. We create the `MenuComponent` abstract class which will be our *Component* element. Then, we define the `Menu` which will represent the *Nodes (Composite)* in the tree structure and the `MenuItem` which will represent the *Leaf*.

## Design Review
The new design will allow us to create a tree-like structure for managing the menus, which will make the design scale well with additions. However, given the current implementation, the `printBreakfastMenu`, `printLunchMenu` and `printVegetarianMenu` cannot be implemented.

## Principles and Patterns

### The Composite Pattern
The *Composite* pattern allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and composition of objects uniformly.
