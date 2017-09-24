# 001-telescoping-constructor-problem
> illustrating how implementing a Person constructor leads to this issue 

## Application Requirements

Create a `Person` domain class which allows to create a Person with the following attributes:
+ Salutation (optional)
+ First Name
+ Middle Name (optional)
+ Last Name
+ Address
  + street
  + city
  + country
  + zipCode
  


## Proposed Design

Create a `Person` domain class with several constructor addressing the different options that we have to support.

## Design Review

The design satisfies the requirements but it leads to a messy implementation with so many constructor types. Also, specific initialization such as having a Person with no Middle Name but with Salutation is not possible.


## Principles and Patterns

### The Builder Pattern

The *Builder Pattern* separates the construction of a complex object from its representation so that the same construction process can create different representations.


