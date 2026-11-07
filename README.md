# Blue-Market

E-commerce project developed in Java, evolving from a terminal-based OOP application (V1) to a REST API with Spring Boot and MySQL (V2).

## Versions
- **V1 — Java + OOP:** original terminal application, preserved on the `master` branch.
- **V2 — Spring Boot + MySQL:** REST API, JPA entities, repositories, services, DTOs, validation and transactional order checkout. See [backend README](backend/README.md).

## Current V2 scope
- Product CRUD endpoints.
- Customer registration with BCrypt password hashing.
- Order checkout with item snapshots and stock reduction in a database transaction.
- Customer order history.
- MySQL development environment with Docker Compose.

> V2 is under development. Authentication/JWT and role-based authorization are not yet implemented. Do not deploy publicly as-is.
