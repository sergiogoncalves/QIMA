# QIMA_BE Project

## Overview

This project is a backend service for a product management system. It is developed using Java and Spring Boot, and uses Maven for dependency management. The data is stored in a SQL database.

## Key Features

- Product Management: The system allows for the creation, retrieval, update, and deletion of products. Each product has an ID, name, category, price, and availability status.

- Category Management: Each product belongs to a category. Categories are also stored in the database.

## Technologies Used

- **Java**: The main programming language used for developing the backend service.

- **Spring Boot**: A framework used for building stand-alone, production-grade Spring-based applications.

- **Maven**: A build automation tool used primarily for Java projects.

- **SQL**: The language used for interacting with the database.

## Code Structure

- `com.qima.entities`: This package contains the entity classes for the project, including `Product` and `Category`.

- `com.qima.services`: This package contains the service classes, which contain the business logic of the application.

- `com.qima.controllers`: This package contains the controller classes, which handle HTTP requests and responses.

- `com.qima.services.mapper`: This package contains the mapper classes, which map the entity objects to DTOs and vice versa.

- `src/main/resources/db/migration`: This directory contains the SQL scripts for database migration.

## Setup

To run this project, you need to have Java and Maven installed on your machine. After cloning the project, you can run it using the command `mvn spring-boot:run`.

## Testing

The project contains unit tests for the mapper classes. These tests can be run using the command `mvn test`.

## Database

The database consists of two tables: `Products` and `Categories`. The `Products` table has a foreign key reference to the `Categories` table.

## Frontend

The frontend of this project is developed using TypeScript, JavaScript, and Angular. It uses npm for package management. The frontend code is not included in this repository.