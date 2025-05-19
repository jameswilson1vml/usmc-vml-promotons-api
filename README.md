# USMC VML Promotions API

A Spring Boot application that manages promotions and events for the United States Marine Corps (USMC) VML platform.

## Overview

This API provides endpoints for managing promotions, events, and fulfillment items within the USMC VML ecosystem.

## Technology Stack

- Java 17
- Spring Boot 3.4.5
- Spring Cloud 2024.0.1
- Spring Data JPA
- HSQLDB (Runtime Database)
- OpenAPI Documentation (Springdoc 2.1.0)
- Lombok
- Maven

## Features

- Promotion Management
- Event Handling
- Fulfillment Item Processing
- OpenAPI Documentation
- REST API Endpoints
- Data Persistence with JPA

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Building the Application

```bash
mvn clean install
```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080 by default.

### API Documentation

Once the application is running, you can access the OpenAPI documentation at:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI Spec: http://localhost:8080/v3/api-docs

## Project Structure

```
src/main/java/com/vml/usmc/
├── events/
│   └── model/
│       └── Event.java
├── promotions/
│   ├── model/
│   │   ├── Promotion.java
│   │   └── FulfillmentItem.java
│   └── service/
│       └── PromotionService.java
```

## Contributing

Please follow standard Java coding conventions and ensure all tests pass before submitting pull requests.

## License

This project is proprietary and confidential. All rights reserved.
