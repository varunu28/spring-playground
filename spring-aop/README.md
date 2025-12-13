# Spring AOP

 - Aspect: The cross-cutting concern that is applied across multiple classes in the application.
 - Joint Point: A point in the execution of the program, such as method execution or exception handling, where an 
   aspect can be applied.
 - Advice: Action taken by an aspect at a joint point. Types of advice include `before`, `after`, `after returning`, 
   `after throwing`, and `around`.
 - Pointcut: A predicate that matches join points. It defines where an advice should be applied.

## Example
 - Example of a simple Aspect that logs both before and after the execution of methods in a service class is 
   `BankTransferAspect` which advises the `transfer` method from `BankTransferService`.