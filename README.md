🛒 ShopSphere Backend

ShopSphere is a scalable, microservices-based e-commerce backend inspired by real-world platforms like Amazon.
This project focuses on clean architecture, industry best practices, and production-ready Spring Boot concepts.

The system is built step-by-step to deeply understand Spring Boot, microservices, security, and database design.

🎯 Project Goals
	•	Build a realistic e-commerce backend
	•	Apply clean architecture & SOLID principles
	•	Learn Spring Boot from fundamentals to advanced
	•	Implement microservices architecture incrementally
	•	Practice real-world database relationships
	•	Implement secure APIs using JWT
	•	Understand service-to-service communication

🏗️ Architecture Overview
	•	Backend Only (REST APIs)
	•	Microservices Architecture
	•	Each service has its own responsibility and database schema
	•	JWT-based authentication
	•	Inter-service communication using Feign Client & WebClient

🧩 Microservices (Planned)
	1.	Auth / User Service
	•	User registration & authentication
	•	JWT token generation & validation
	•	Role-based authorization
	•	Address management
	2.	Product Service
	•	Product & category management
	•	Inventory handling
	•	Product pricing (source of truth)
	3.	Order Service
	•	Order creation & tracking
	•	Order items management
	•	Stores product price snapshot at purchase time
	4.	Payment Service
	•	Payment processing simulation
	•	Payment history & status tracking

🛠️ Tech Stack
	•	Java 17+
	•	Spring Boot
	•	Spring Data JPA (Hibernate)
	•	Spring Security
	•	JWT (JSON Web Token)
	•	MySQL
	•	Maven
	•	Feign Client
	•	WebClient

📐 Design Principles Followed
	•	Layered Architecture
(Controller → Service → Repository)
	•	DTO-based API contracts
	•	Entity encapsulation (Entities are never exposed)
	•	Global exception handling
	•	Centralized validation
	•	Clean separation of concerns
	•	Single responsibility per microservice

🗄️ Database Design
	•	Proper use of:
	•	One-to-One
	•	One-to-Many
	•	Many-to-Many relationships
	•	Transaction-safe order and payment modeling
	•	Immutable order history design

🔐 Security Strategy
	•	Stateless authentication using JWT
	•	Role-based access control
	•	Password encryption
	•	Secure API endpoints
	•	Token refresh mechanism (planned)

🚀 Development Approach

This project is built in stages:
	1.	Architecture & domain modeling
	2.	Single service Spring Boot foundation
	3.	Security implementation
	4.	Database relationships
	5.	Microservices split
	6.	Inter-service communication
	7.	Production-ready enhancements

Each stage focuses on learning + correctness, not shortcuts.

📌 Status

🚧 In active development
Currently working on User/Auth Service foundation

👨‍💻 Author

Built as a learning-focused, production-style backend system to master Spring Boot & Microservices.
