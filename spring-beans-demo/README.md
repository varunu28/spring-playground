# Spring Beans Demo

- Spring beans can be inferred from the parameter name. So `EmailService dummyEmailService` is equivalent to
  `@Qualifier("dummyEmailService") EmailService emailService`
- `ObjectProvider` is retrieval handle to get beans of a specific type.
- `ObjectProvider` can also be retrieved from the application context by invoking `BeanFactory#getBeanProvider`.
- `ObjectProvider` can also be used along with `@Qualifier` to get the bean lazily.
- You can also conditionally create a bean based upon some specific condition. To do that, you need to
  implement the `Condition` interface & then use `@Conditional` annotation on the bean definition.