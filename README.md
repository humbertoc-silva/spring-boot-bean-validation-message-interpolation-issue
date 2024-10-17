# spring-boot-bean-validation-message-interpolation-issue
Spring Boot project used to test Bean Validation message interpolation issues

## Instructions

I am trying to follow the instructions: https://docs.spring.io/spring-framework/reference/core/validation/beanvalidation.html#validation-beanvalidation-spring-method-i18n.

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

- não deve estar em branco
- tamanho deve ser entre 1 e 50

*default Bean Validation message in my language pt-BR