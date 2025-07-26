# Spring Profiles

 - Profiles can be changed by setting the active profile in the `application.properties` which act as the default 
 profile.
 - The ordering of the profiles in the `application.properties` file determines the precedence of the profiles.
 - Setting the active profile as below:
 - ```yml
   spring:
    profiles:
      active: test, qa # Ordering matters here as properties in `qa` will override those in `test`
    ```
   means that any property defined in `test` will override the properties defined in `default` profile & then any 
   property defined in `qa` will override any property defined in `test` & `default` profile.
 - Profiles can also be set using the `spring.profiles.active` property when you run the application, e.g.:
   ```bash
   java -jar target/spring-profiles-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
   ```
 - Setting profiles while running the application will override the profiles set in the `application.properties` file.
 - We can also use profiles to load different beans based upon the current active profile.
 - For example, if we have a bean that should only be loaded in the `test` profile, we can annotate it with:
   ```java
    @Profile("test")
    @Component
    public class TestBean {
         // Bean implementation
    }
    ```