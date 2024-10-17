# spring-boot-bean-validation-message-interpolation-issue
Spring Boot project used to test Bean Validation message interpolation issues

## Instructions

I am trying to follow the instructions: https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#chapter-message-interpolation.

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

- The name field must not be blank
- The size of the name field must be between 1 and 50

But I got the following error and exception from Spring:

```json
{
    "timestamp": "2024-10-17T15:19:08.775+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/people"
}
```

```
java.lang.IllegalArgumentException: can't parse argument number: min
	at java.base/java.text.MessageFormat.makeFormat(MessageFormat.java:1479) ~[na:na]
	at java.base/java.text.MessageFormat.applyPattern(MessageFormat.java:511) ~[na:na]
	at java.base/java.text.MessageFormat.<init>(MessageFormat.java:410) ~[na:na]
	at org.springframework.context.support.MessageSourceSupport.createMessageFormat(MessageSourceSupport.java:150) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.context.support.ResourceBundleMessageSource.getMessageFormat(ResourceBundleMessageSource.java:338) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.context.support.ResourceBundleMessageSource.resolveCode(ResourceBundleMessageSource.java:174) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.context.support.AbstractMessageSource.getMessageInternal(AbstractMessageSource.java:225) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.context.support.AbstractMessageSource.getMessage(AbstractMessageSource.java:170) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.context.support.AbstractApplicationContext.getMessage(AbstractApplicationContext.java:1487) ~[spring-context-6.1.13.jar:6.1.13]
	at org.springframework.web.util.BindErrorUtils.lambda$resolveAndJoin$0(BindErrorUtils.java:78) ~[spring-web-6.1.13.jar:6.1.13]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1708) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682) ~[na:na]
	at org.springframework.web.util.BindErrorUtils.resolveAndJoin(BindErrorUtils.java:80) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.util.BindErrorUtils.resolveAndJoin(BindErrorUtils.java:60) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.bind.MethodArgumentNotValidException.getDetailMessageArguments(MethodArgumentNotValidException.java:85) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.ErrorResponse.updateAndGetBody(ErrorResponse.java:145) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler.handleExceptionInternal(ResponseEntityExceptionHandler.java:662) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler.handleMethodArgumentNotValid(ResponseEntityExceptionHandler.java:350) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler.handleException(ResponseEntityExceptionHandler.java:164) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:255) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:188) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver.doResolveHandlerMethodException(ExceptionHandlerExceptionResolver.java:432) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver.doResolveException(AbstractHandlerMethodExceptionResolver.java:74) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver.resolveException(AbstractHandlerExceptionResolver.java:175) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.handler.HandlerExceptionResolverComposite.resolveException(HandlerExceptionResolverComposite.java:80) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.DispatcherServlet.processHandlerException(DispatcherServlet.java:1358) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1161) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1106) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590) ~[tomcat-embed-core-10.1.30.jar:6.0]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885) ~[spring-webmvc-6.1.13.jar:6.1.13]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658) ~[tomcat-embed-core-10.1.30.jar:6.0]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[tomcat-embed-websocket-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:384) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]
Caused by: java.lang.NumberFormatException: For input string: "min"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67) ~[na:na]
	at java.base/java.lang.Integer.parseInt(Integer.java:662) ~[na:na]
	at java.base/java.lang.Integer.parseInt(Integer.java:778) ~[na:na]
	at java.base/java.text.MessageFormat.makeFormat(MessageFormat.java:1477) ~[na:na]
	... 74 common frames omitted
```