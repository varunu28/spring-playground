# Form Encoded Data Handling in Spring MVC

 - Spring boot registers a `FormContentFilter` by default to handle `application/x-www-form-urlencoded` data.
 - The `FormContentFilter` internally uses a `FormHttpMessageConverter`.
 - This converter is responsible for converting form data into a `MultiValueMap<String, String>`, which can be easily processed in controller methods.
 - The converted data is transformed to a `FormContentRequestWrapper` which contains both the request & the mapped form data.
 - The `FormContentRequestWrapper` is then passed to the controller method, allowing access to form data via `@RequestParam`, `@ModelAttribute`, or other relevant annotations.
 - The `FormContentRequestWrapper` is then processed by `ModelAttributeMethodProcessor` to bind the form data to model attributes.
 - This mechanism simplifies the handling of form-encoded data in Spring MVC applications, making it easier to work with form submissions and process user input.
