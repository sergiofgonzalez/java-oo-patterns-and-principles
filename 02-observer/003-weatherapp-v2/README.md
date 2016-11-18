# 003-weatherapp-v2
> Using JDKs Observable and Observer artifacts

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
We use the same design approach as v1, but instead of creating our own take on the *Observer* pattern, we use JDK's `Observable` and `Observer` artifacts.

This imposes some code refactoring because of the protocol that established by the JDK's implementation of the *Observer* pattern:
+ The `WeatherData` class will extend from `Observable`. The most relevant change is that it is necessary to call the `setChanged` method to signify that the state has changed. Additionally, now the *measurements* (temperature, humidity, pressure...) become private fields and we provide *getters* for the measurements so that *observers* will be able to pull as they see fit.

+ The `Display` class will implement the `Observer` interface. Because of that, we will need to accommodate the `update` method to the required signature:
```java
void update(Observable observable, Object data);
``` 
As we receive a reference to the observable object, we will be able to pull the data from the observable using the provided *getters*. 

The rest of the modifications consist in accommodating the rest of `Display` subclasses and *app runner* to the new methods.

## Design Review
The design is even more solid that v1:
+ We're reusing JDK established classes instead of reinventing the wheel &mdash; this will make the solution easier to understand to Java experts.
+ We're using a *pull* approach to receive data from the `WeatherData` object &mdash; this is the preferred approach as the observer can opt-out if needed.
+ We're no longer in risk of having to modify the entire application if a sensor provides more data &mdash; the update interface will no change (therefore the existing displays will not be affected), so only the WeatherData internal implementation will be affected.


### Principles ###
**Loose Coupling**
When two objects are loosely coupled, they can interact, but have very little knowledge of each other.

### Patterns ###
**The Observer Pattern**
The Observer Pattern defines a one-to-many dependency between objects so that when one object changes its state, all of its dependents are notified and updated automatically.

The object that holds the relevant state is called the *subject* object, and the dependent objects are called the *observers*.
The *Observer Pattern* provides an object design where *subject* and *observers* are loosely coupled.

The JDK provides an implementation of the *observer* pattern through its `Observable` class and `Observer` interface:
+ **Observable** &mdash; models the *Subject* part of the *observer* pattern.
You must call the `setChanged` to signal that the state has changed in your object.
Then you must call `notifyObservers()` or `notifyObservers(data)` to trigger the call to `update` on the registered `Observers`. The former method is used in *pull* approach, while the latter is used in *push* approach.

+ **Observer** &mdash; must implement the `update(Observable, Object)` with `Observable` being the *subject* that sent the notification. Note that the `Object` will be null in the *pull* approach. 