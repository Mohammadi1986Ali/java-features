# Java Features

A multi-module Maven project with small, focused examples of core Java language and runtime features. Each module keeps the source code intentionally compact and uses JUnit tests to show the expected behavior.


## Modules

| Module | What it demonstrates |
| --- | --- |
| `pojo-bean` | Differences between a simple POJO with public fields and a JavaBean-style class with constructors, private fields, getters, setters, and `Serializable`. |
| `runnable-callable` | `Runnable`, `Callable`, `ExecutorService`, `Future`, task return values, and exception propagation from asynchronous work. |
| `downcast-upcast` | Upcasting, downcasting, overridden methods, and runtime dispatch through a parent reference. |
| `exception-handling` | Basic exception wrapping, suppressed exceptions, `AutoCloseable`, try-with-resources behavior, and an uncaught exception handler. |
| `record` | Java records, compact constructors, custom constructors, static factory methods, and interface implementation. |
| `void-type` | The difference between primitive `void` (`Void.TYPE`) and the `java.lang.Void` reference type, including reflection-based return type checks. |
| `generic` | Generic classes, generic methods, raw types, unchecked assignment, `ClassCastException`, and type erasure. |
| `functional-interfaces` | `Function`, `UnaryOperator`, `BinaryOperator`, method references, lambdas, and function composition. |

## Project Layout

```text
java-features/
|-- pom.xml
|-- downcast-upcast/
|-- exception-handling/
|-- functional-interfaces/
|-- generic/
|-- pojo-bean/
|-- record/
|-- runnable-callable/
`-- void-type/
```

The root `pom.xml` is an aggregator POM. Shared versions for Java, JUnit Jupiter, Logback, Surefire, and Failsafe are managed there and inherited by the modules.

## Build And Test

## Notes

- Test classes are the best entry point for learning how each feature behaves.
- The examples use Logback through SLF4J, so running tests or application classes prints feature-specific log messages.
- The project is designed as a Java feature playground rather than a production application.
