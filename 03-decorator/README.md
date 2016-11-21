# 03-decorator
> adding dynamic behaviors to cope with variability

## Projects

### 001-coffeeshop-v0
We need to design the domain model for an ordering system in a coffee shop. Initially, the menu of the coffee shop is very limited with only four types of coffee, but they might want to increase their range of available offerings in the future, so extensibility is a must.

### 002-coffeeshop-v1
The coffee shop has added condiments to their beverages, and we need to adapt the original domain classes to support this new requirements. In this second approach, the base class is enhanced with additional boolean properties to support the condiments.

### 003-coffeeshop-v2
Another take for the domain model design using the *Decorator* pattern.

### 004-coffeeshop-v3
The coffee shop raises another request to include different sizes. The *component* in the *Decorator* is modified to embrace this new requirement.

### 005-coffeeshop-v4
The previous design is enhanced to remove code duplication.

### 006-file-input-decorator
Illustrates how to create a *concrete decorator* for the `FilterInputStream` abstract decorator of the `java.io` package. In the implementation, of the bytes read are transformed to lowercase.