# 06-command
> encapsulating invocation

## Projects

### 001-remote-ctrl-api-v0
Illustrates how to implement the *Command* pattern to implement a very simple programmable remote control with a single programmable slot and a single button.

### 002-remote-ctrl-api-v1
Illustrates how to implement the *Command* pattern to implement a programmable remote control with 7 slots and two buttons (on and off) per slot.

### 003-remote-ctrl-api-v2
Introduces the *undo* functionality as an additional button in the remote control.

### 004-remote-ctrl-api-v3
Introduces the *macro* functionality, which allows a button to act upon several devices as if it was one.

### 005-remote-ctrl-api-v4
Removes the amount of classes needed for the command by using lambdas.

### 006-remote-ctrl-api-v5
Removes the amount of classes needed for the command by using lambdas, and the lambdas are organized into holder classes instead of defining them inline in the *Invoker*. This increases the verbosity of obtaining the *Command* in the *Invoker*.

### 007-remote-ctrl-api-v6
Removes the amount of classes needed for the command by using lambdas, and the lambdas are organized into holder classes instead of defining them inline in the *Invoker*. In this version, the *Invoker* keeps a reference to the *Receiver* so that utility classes become a little bit more verbose but the *Invoker* gets cleaner.