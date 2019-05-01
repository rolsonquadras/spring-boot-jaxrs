# spring-boot-jaxrs

Demo project to show the use of JAX-RS Specification with Spring Boot framework. Spring Boot uses Embedded Tomcat server by default.

The Spring runtime would not detect the JAX-RS Runtime annotation. This is achieved by a wrapper class annotated by Spring Bean (@Component) which implement Jersey specific ResourceConfig class, where the JAX-RS Runtime annotations are registered.

Jersey is used as the JAX-RS implementation in this demo project.

#References
1. JAX-RS Spec - https://jax-rs-spec.java.net/
2. Jersey - https://jersey.java.net/
3. Spring Boot - http://projects.spring.io/spring-boot/
