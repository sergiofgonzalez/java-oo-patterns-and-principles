# 001-home-theater-facade-v0
> hiding complexity behind a simple interface

## Application Requirements
We are given a large set of vendor classes that implement the interaction with home theater devices. We need to provide an action *watchMovie* that must perform the following actions:
1. Turn on the popcorn popper
2. Start the popper
3. Dim the lights
4. Put the screen down
5. Turn the projector on
6. Set the projector input to DVD
7. Put the projector on wide-screen mode
8. Turn on the sound amplifier
9. Set the amplifier to DVD input
10. Set the amplifier to surround sound
11. Set the amplifier volume to 11
12. Turn the DVD Player on
13. Start the DVD player

In the same way, an *endMovie* action should be implemented, turning off all the devices.

## Proposed Design
Use the *Façade* Pattern and expose a `HomeTheaterFacade.watchMovie` and `HomeTheaterFacade.endMovie` that perform the actions described in the requirements.


## Design Review
The *Façade* pattern satisfies the requirements and not only the interface is simplified but also the client (`HomeTheaterRunner`) becomes decoupled from the actual classes managing the device, and therefore, if those change, it will only impact the *Façade* and not the client.


## Principles and Patterns

### The Adapter Pattern
The *Façade* Pattern provides a unified interface to a set of interfaces in a subsystem. Façade defines a higher-level interface that makes the subsystem easier to use.