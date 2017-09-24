# 001-telescoping-constructor-problem
> illustrating how implementing a Person constructor leads to this issue 

## Application Requirements

Create a `Person` domain class which allows to create a Person with the following attributes:
+ First Name
+ Last Name
+ Middle Name (optional)
+ Salutation (optional)

## Proposed Design

Create a `Person` domain class with several constructor addressing the different options that we have to support.

## Design Review

The design satisfies the requirements but it leads to a messy implementation with so many constructor types. Also, specific initialization such as having a Person with no Middle Name but with Salutation is not possible.


## Principles and Patterns

n/a

