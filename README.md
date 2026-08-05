# Bakery Common Core

Welcome to the **Bakery Common Core** module! This project serves as the foundational shared library for all microservices in the Blu's Bakery ecosystem. 

> [!IMPORTANT]  
> This is a shared library module, **not** a standalone microservice. It is designed to be imported as a dependency by other microservices to promote code reuse, consistency, and standard practices across the platform.

## 🎯 Purpose

The primary goal of this module is to centralize shared logic and common patterns that are used across multiple microservices. This prevents code duplication and ensures a unified architecture. It includes:

*   **Shared Utilities:** Common helper functions for formatting, validation, string manipulation, date-time processing, etc.
*   **Base Classes:** Abstract classes and interfaces (e.g., base entity classes, repository interfaces) that provide standard boilerplate for domain models.
*   **Generic DTOs (Data Transfer Objects):** Standardized request and response payloads, such as paginated responses or common metadata wrappers.
*   **Custom Exception Classes:** Domain-specific exceptions (e.g., `ResourceNotFoundException`, `ValidationException`, `UnauthorizedAccessException`) to maintain consistent error states.
*   **Global Error Handling Constants:** Standardized error codes and messages to ensure API clients receive consistent error structures.

## 📂 Folder Structure

The project follows standard Java source structuring conventions.

```text
bakery_common_core/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── blubakery/
│       │           └── common/
│       │               └── core/
│       │                   ├── constants/
│       │                   │   ├── GlobalAppConstants.java
│       │                   │   ├── HttpHeaderConstants.java
│       │                   │   └── RoleConstants.java
│       │                   └── exception/
│       │                       ├── common/
│       │                       │   ├── DuplicateResourceException.java
│       │                       │   ├── ResourceNotFoundException.java
│       │                       │   └── ServiceUnavailableException.java
│       │                       └── handler/
│       │                           ├── BaseExceptionHandler.java
│       │                           ├── ErrorResponse.java
│       │                           └── ValidationErrorDetail.java
│       └── resources/
│           └── logback-base.xml
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
├── API_REFERENCE.md
└── README.md
```

## 🚀 How to Include in Other Microservices

Other microservices within the bakery ecosystem can include this library as a dependency. Depending on your project setup, it can be included as a composite build dependency (if part of a multi-module project) or as a published artifact.

To include it in a standard Gradle microservice using Kotlin DSL (`build.gradle.kts`):

```kotlin
dependencies {
    // If published to Maven Local or GitHub Packages:
    implementation("org.blubakery:bakery_common_core:1.0.0-SNAPSHOT")
    
    // OR if configured as a multi-module project dependency:
    // implementation(project(":bakery_common_core"))
}
```

## 🛠️ Building and Publishing Locally

If you make changes to this core module and need to test them in another microservice running locally, you must build and publish the changes to your local Maven repository (`~/.m2`).

To build and publish locally, navigate to the root of this module and run:

```bash
# Unix/macOS
./gradlew publishToMavenLocal

# Windows
gradlew.bat publishToMavenLocal
```

Once published, other microservices that include `mavenLocal()` in their `repositories` block will automatically pick up your latest local build.

```kotlin
// In the consumer microservice's build.gradle.kts
repositories {
    mavenLocal() // Ensure this is present
    mavenCentral()
}
```

## 🔗 Related Links

*For overall architecture, contribution guidelines, and security policies, please refer to the main [Blu's Bakery](https://github.com/amankrmj09/Blu_s_Bakery) repository.*

