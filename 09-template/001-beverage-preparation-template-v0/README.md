# 001-beverage-preparation-template-v0
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
Implement as separate algorithms.


## Design Review
The implementation satisfies the requirements, but there are some obvious duplications that could be addressed by subclassing.

## Principles and Patterns

n/a