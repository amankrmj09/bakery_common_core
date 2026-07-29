# 🧁 Bakery Common Core

![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)

Welcome to **Bakery Common Core**, the foundational utility package of the Shah's Bakery Microservice Platform.

## 🎯 Purpose
The Common Core repository provides shared Data Transfer Objects (DTOs), standard exceptions, and generic utilities used across all bakery microservices. By moving standard `api` dependencies here, it ensures that all business microservices inherit the exact same versions of the Spring Boot Web and Validation starters.

## 🛠️ Features
- **Centralized DTOs**: Consistent data models for inter-service REST communication.
- **Global Error Handling**: Standardized exception structures like `ServiceUnavailableException`.
- **Standardized Logging**: Pre-configured SLF4J/Logback configurations (`logback-base.xml`).
- **Dependency DRYing**: Exposes core Spring Boot Web starters to reduce boilerplate in leaf microservices.

## 📁 Folder Structure
```text
src/
└── main/
    ├── java/org/blubakery/common/core/
    │   ├── dto/        # Shared Data Transfer Objects for consistent inter-service communication.
    │   └── exception/  # Standardized error structures and Base Exception Handlers.
    └── resources/
        └── logback-base.xml # Standard JSON/Console logging layout.
```

## 🚀 Getting Started

### Local Setup
1. Include this library in your service's `build.gradle.kts`:
   ```kotlin
   implementation("org.blubakery.libs:bakery_common_core:1.0.0")
   ```
2. For logging, add to your microservice's `logback-spring.xml`:
   ```xml
   <include resource="logback-base.xml"/>
   ```

## 🔗 Related Links
- [Main Platform README](../README.md)
