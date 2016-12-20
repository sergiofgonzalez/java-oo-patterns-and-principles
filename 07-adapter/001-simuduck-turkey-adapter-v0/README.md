# 001-simuduck-turkey-adapter-v0
> adjusting a class to meet a completely different target interface

## Application Requirements
We have a `Duck` *target* interface and we want to use an instance of the `Turkey` class instead of a `Duck` instance.


## Proposed Design
Use the *Adapter* design pattern to be able to put an object implementing the `Turkey` interface in the place where a `Duck` instance should be used.

In this case, the *Client* is the `SimuduckRunner` class which calls the `fly` and `quack` method on a `Duck`. The *Adaptee* is the `WildTurkey` class which features `fly` and `gobble` methods. The *Adapter* adjusts `Turkey.fly` to `Duck.fly` and `Turkey.gobble` to `Turkey.quack`.


## Design Review
The *Adapter* satisfies the requirements.


## Principles and Patterns

### The Adapter Pattern
The *Adapter Pattern* converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.