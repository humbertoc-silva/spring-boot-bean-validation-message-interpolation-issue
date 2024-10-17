# spring-boot-bean-validation-message-interpolation-issue
Spring Boot project used to test Bean Validation message interpolation issues

## Instructions

I am trying to follow the instructions: https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html#validation-beanvalidation-spring-method-i18n.
But now I filled the annotations message field with a Spring code value.

## Test

Start the project in debug mode, open the class `org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler` and put a breakpoint at line 164 to analyse the exception.

```shell
curl --location 'http://localhost:8080/people' \
--header 'Content-Type: application/json' \
--data '{
    "name": ""
}'
```

## Result

- The field {0} must not be blank
- The size of the {0} name must be between {1} and {2}