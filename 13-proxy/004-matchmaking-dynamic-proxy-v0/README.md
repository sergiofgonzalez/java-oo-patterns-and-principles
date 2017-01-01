# 004-matchmaking-dynamic-proxy-v0
> implementing a Dynamic Proxy for controlling access to a resource

## Application Requirements
Create the domain model for a Matchmaking service and provide Protection proxies to control:
+ That a user cannot change their own rating
+ That a user cannot change the personal data of another user


## Proposed Design
Use the *Dynamic Proxy* pattern that the JDK provides to implement the *Protection Proxy*. This involves creating a couple of *InvocationHandlers* implementing `java.lang.reflect.InvocationHandler`. Within those *invocation handlers* is where the protection is implemented. Those handlers maintain a reference to the real subject, so they can perform the actual call when being called.


## Design Review
The design satisfies the requirements and makes good use of the `java.lang.reflect` capabilities to create *dynamic proxies*.

## Principles and Patterns

### The Proxy Pattern
The **Proxy** pattern provides a surrogate or placeholder for another object to control access to it.

