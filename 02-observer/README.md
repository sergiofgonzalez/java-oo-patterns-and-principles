# 02-observer
> Dynamic behaviors and the Strategy pattern

## Projects

### 001-weatherapp-v0
We're given a project consisting in building a Weather application that is based on some partially implemented class given by our client. We're allowed to modify some parts of the class we're given but we have to comply with certain requirements of extensibility (3rd party developers must be able to plug-in new functionality without requiring code modifications).
This is the first approach to a solution: it's a working application but fails to comply with the extensibility requirements.

### 002-weatherapp-v1
In the second approach, we introduce the *Observer* design pattern to enable loose coupling and extensibility.

### 003-weatherapp-v2
In this 3rd approach we change the custom *Observer* pattern implementation with the one provided by the JDK.