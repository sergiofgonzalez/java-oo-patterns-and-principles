# 001-weatherapp-v0
> First take at the weather app project

## Application Requirements
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

### Modeling Screens
A `Display` base class is defined to model base behavior for screens. This features:
+ an `update` method which must be called once we get new data from the weather service and whose responsibility is to update the display state
+ an abstract `show` method that must be called to output the display stat

Then three separate subclasses are created to support the three required displays for Current, Statistics and Forecast weather data.

### WeatherData
We decide to create three `Display` instance variables on the `WeatherData` object to support the current, statistics and forecast conditions. Then, in the `measurementsChanged` function, that we know it will be automatically invoked whenever the measurements has been updated, we read the latest temperature, humidity and pressure and call the `Display.update` method on the three screens.  

As the main application does not know anything about the displays (those are kept in the `WeatherData` instance) we need to provide getters on the `WeatherData`.

### Main Application
The main application instantiates an instance of `WeatherData` and displays a menu with options to the user. When the user selects an option, the appropriate `Display.show` method is invoked to display the data.

## Design Review
Although the application works, there are several flaws that limit the extensibility of the solution:
+ If we need to include additional displays, we'll need to change the `WeatherData` implementation
+ There is no support for the 3rd party API we've been requested

It would be better if we could register the displays as subscribers that get notified of changes in the measurements, so that they can react.

## Principles and Patterns
+ none