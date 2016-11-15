# 01-strategy
> Dynamic behaviors and the Strategy pattern

## Patterns and Principles


## Projects

### 001-simuduck-v0
Illustrates why class inheritance is lacks some basic extensibility features, and its side effects on derived classes might not always be desired.

### 002-simuduck-v1
A new requirement to implement some ducks that fly and some that don't is received. A new design based on using interfaces and making the subclasses implement those interfaces is used. This solves part of the problem but creates a maintenance nightmare.

### 003-simuduck-v2
A new design based on declaring behaviors and implementation classes that are not directly bound to concrete implementation classes are used. The design is good enough although it could be argued that code can be moved up to the base class to reduce code duplication by increasing the coupling. 

### 004-simuduck-v3
A minor change consisting in moving common code to the base class to reduce code duplication. IMHO this is better than v2. 