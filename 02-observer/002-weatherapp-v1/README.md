# 002-weatherapp-v1
> Solving the problems from v1 using the Observer pattern

## Application Requirements (same as v0)
A company has hired us to build a weather application using some of the infrastructure they already have.

Their ask is to create a Weather Monitoring Station using a partially implemented class they already own `WeatherData` which is capable of pulling weather related measurements from their internet service.
They want us to create an app with three screens:
+ current conditions
+ weather statistics
+ weather forecast

The three screens must be updates as soon as a new set of data is pulled from the weather service.

They also want the capabilities of the Weather Station to be extensible by 3rd party developers, so that an API should be provided for them to plug their own screens.

### Scope
We will be responsible for:
+ Implementation of `WeatherData` object &mdash; we will receive an initial version for this object, but we might need to reimplement some parts as require, but we must conform to the given interfaces.
+ Creation of the services supporting the three screens for current conditions, basic statistics and weather forecast
+ Extensibility API so 3rd party developers can provide their own screens

### Received Software Package
The received software package from the company contains:
+ The `WeatherData` class featuring:
    + The `getTemperature`, `getPressure` and `getHumidity` methods that retrieve the latest measurements from the company's internet service fully implemented.
    + The method `measurementsChanged` defined but not implemented, with the following signature:
    ```java
    public void measurementsChanged();
    ``` 

## Proposed Design

### WeatherData and Screens
Previous solution needed an enhancement as it does not comply with the extensibility requirements for 3rd parties. It would also create a bit of a maintenance nightmare, as new functionalities on the screens or new screens will require modifications across the board (as the implementation is really tangled).

We decide to use **the observer pattern** to improve the solution design and comply with the extensibility requirements.
We define a couple of interfaces:
+ *Subject* &mdash; the part of the observer pattern that holds the state that should be shared
+ *Observer* &mdash; the part of the observer pattern that represents the objects interested in the shared state

We make the `WeatherData` class implement the `Subject` interface and the `Display` class to implement the `Observer`.


### Main Application
The main application instantiates an instance of `WeatherData` to bootstrap the application and then register the *observers*.

## Design Review
The design with the *observer* pattern in place is solid. The `WeatherData` and the `Displays` are loosely coupled and the `WeatherApp` source code is succint and elegant.

The application supports the extensibility requirement, as seen on the `FeelsLikeDisplay`.

### Possible Optimizations
The application uses inheritance for the `Display` classes, and it does not seem to cause many problems in the current implementation, but maybe, interfaces should be used instead.

Also, the `Observer` interface defines the update method as:
```java
void update(double temperature, double humidity, double pressure);
```  

Although this satisfies the requirements, it's a weak point of the design if additional measurements are provided by the sensors, as they will require modification in the interface and in all the observers.
## Principles and Patterns

A third point to consider is that Java supports the *observer* pattern through the `Observable` &mdash; for the `Subject` &mdash; and the `Observer` interface. By using those available class and methods we will not be reinventing the wheel (DRY).

### Principles ###
**Loose Coupling**
When two objects are loosely coupled, they can interact, but have very little knowledge of each other.

### Patterns ###
**The Observer Pattern**
The Observer Pattern defines a one-to-many dependency between objects so that when one object changes its state, all of its dependents are notified and updated automatically.

The object that holds the relevant state is called the *subject* object, and the dependent objects are called the *observers*.
The *Observer Pattern* provides an object design where *subject* and *observers* are loosely coupled.