Spring Boot Microservices Project

Overview

	This project is a microservices-based architecture using Spring Boot, designed to handle various student-related functionalities such as managing students, courses, schools, and homes. Each microservice is independently deployed and registered with Eureka Server, 	while an API Gateway manages and routes requests efficiently.



Microservices Architecture

	Independent microservices: StudentAndCourses, SchoolDetails, HomeService, CredentialAndRoles, etc.

	Each microservice is registered with Eureka Server for service discovery.

	Spring Cloud API Gateway for routing requests.

Spring Boot Core Features

	Spring Security & JWT for authentication and authorization.

	Spring Data JPA & Hibernate for database interactions.

	RESTful APIs for CRUD operations on entities like students, courses, schools, and homes.
	
	Feign Client & RestTemplate for inter-service communication.

Service Registry & Load Balancing

	Eureka Server is used to register and discover microservices.

	Load Balancing is handled using Spring Cloud LoadBalancer.

Database & Persistence

	Spring Data JPA with Hibernate for ORM mapping.
	
	Uses an SQL database to persist student, course, school, and home details.

Security & Authentication

	JWT-based Authentication for securing APIs.

	Role-based access control is implemented in the CredentialAndRoles service.

API Gateway

	Manages and routes requests to the respective microservices.

	Provides centralized security and authentication enforcement.


Project Structure
CredentialAndRoles → Manages authentication and roles using Spring Security & JWT.

StudentAndCourses → Handles student and course-related operations.

SchoolDetails → Manages school-related data.

HomeService → Handles student home-related data.

ServiceRegistry → Eureka Server for service discovery.

StudentGateway → API Gateway for managing requests.
