# 004-mixing-menu-implementations-v3
> mixing implementations of a restaurant menu using an Iterator

## Application Requirements

### New Requirements
Integrate another menu, the `CafeMenu`, in the application. This new menu uses a `HashMap` aggregate.


### Previous Requirements
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
The easiest way is to include a method `createIterator` using the `Map.values().iterator()` in the `CafeMenu` class and make `MenuServices` aware of this new class.

## Design Review
The previous use of `Iterator` make the integration of a new menu extremely easy. However, there are some points that can be improved, like making the `isItemVegetarian` more efficient when a Map is used. Also the implementation of this method does not scale well if more menus are added.

## Principles and Patterns

### The Iterator Pattern
The *Iterator* pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

### The Single Responsibility Design Principle
A class should have only one reason to change. Designs should be highly-cohesive, loosely coupled.