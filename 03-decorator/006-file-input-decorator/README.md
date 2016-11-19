# 006-file-input-decorator
> implementing a FilterInputStream decorator

## Application Requirements
The `java.io` uses the *Decorator* pattern intensively, with `InputStream` being the *abstract component* and `FilterInputStream` the *abstract decorator*.

This application creates a simple concrete implementation of `FilterInputStream` that can be used to decorate a `FileInputStream`.

In the implementation, of the characters read are transformed to lowercase.