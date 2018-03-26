# Microservicio Store

Microservicio para store.

1. Dependencias:
	* Cloud Config: Config Client.
	* Cloud Discovery: Eureka Discovery.
	* Cloud Tracing: Sleuth, Zipking Client.
	* Cloud Routing: Ribbon, Feign.
	* Web: Web.
	* SQL: JPA, H2.
	* Swagger.

2. Anotar con *@EnableDiscoveryClient* y *@EnableFeignClients("com.company.app")* la clase de configuración.

3. Crear Bean defaultSampler para trazabilidad:
	* Spring Boot 1:
		```[java]
		@Bean
		public AlwaysSampler defaultSampler() {
			return new AlwaysSampler();
		}
		```
	* Spring Boot 2:
		```[java]
		@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}
		```
4.  Renombrar *application.yml* por *bootstrap.yml* y agregar:
```[yml]
server:
  port: 8080
spring:
  application:
    name: microservice-store
  cloud:
    config:
      uri: http://localhost:8989
eureka:
  client:
    service-url:
      default-zone: ${EUREKA_URI:http://localhost:8761/eureka}
management:
  security:
    enabled: false
```