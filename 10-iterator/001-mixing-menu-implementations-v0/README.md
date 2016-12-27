# 001-mixing-menu-implementations-v0
> mixing implementations of a restaurant menu

## Application Requirements
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
We create a `MenuServices` class with the implementation of the different requested methods.


## Design Review
The implementation satisfies the requirements, but there's some code duplication and the implementation is somewhat ugly (the isItemVegetarian specifically).

In particular, the problem seems to lie in the `getMenuItems` for the `BreakfastMenu` and `LunchMenu`, because they return different implementations. We must find a way to encapsulate the iteration so that we don't care anymore about the implementation details.

## Principles and Patterns

n/a