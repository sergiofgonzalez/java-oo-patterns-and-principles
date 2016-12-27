# 003-mixing-menu-implementations-v2
> mixing implementations of a restaurant menu using an Iterator

## Application Requirements

**No new requirements**

We have an application that manages restaurant menus. There is an agreement over the class representing the menu item, but not collection of menu items is different for different parts of the application:

+ **diner type dishes use an array**:
  + Vegetarian BLT ((Fakin') Bacon with lettuce & tomato on whole wheat), veg, $2.99
  + BLT (Bacon with lettuce & tomato on whole wheat), false, $2.99
  + Soup of the day (Soup of the day, with a side of potato salad), non-veg, $3.29
  + Hotdog (A hot dog, with sauerkraut, relish, onions, topped with cheese), false, $3.05

+ **breakfast dishes use an `ArrayList`**:
  + K&B's Pancake Breakfast (Pancakes with scrambled eggs, and toast), veg, $2.99
  + Regular Pancake Breakfast (Pancakes with fried egg, sausage, non-veg, $2.99
  + Blueberry Pancakes (Pancakes made with fresh blueberries), veg, $3.49
  + Waffles (Waffles, with your choice of blueberries or strawberries), veg, $3.59
  
We have to build a portion of the application in charge of
+ `printMenu` &mdash; prints every item on the menu
+ `printBreakfastMenu` &mdash; prints breakfast dishes
+ `printLunchMenu` &mdash; prints just lunch items
+ `printVegetarianMenu` &mdash; prints all vegetarian menu items
+ `isItemVegetarian` &mdash; given the name of an item, returns true if the item is veg, otherwise false 


## Proposed Design
The only difference with the previous version is that now we use the `java.util.Iterator` instead of a custom iterator.

## Design Review
Note that the implementation is even cleaner now, as `ArrayList` already provides a method that returns a `java.util.Iterator` so we do not longer need `BreakfastMenuIterator`.

## Principles and Patterns

### The Iterator Pattern
The *Iterator* pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

### The Single Responsibility Design Principle
A class should have only one reason to change. Designs should be highly-cohesive, loosely coupled.