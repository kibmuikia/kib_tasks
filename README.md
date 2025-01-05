# KTasks - A RESTful Task Management API

KTasks is a lightweight yet robust task management API built with Ktor, demonstrating modern Kotlin backend development practices. The application follows a clean architectural pattern, organizing code into distinct layers for maintainability and scalability.

## Architecture

The project follows a clean architecture pattern with the following structure:
```
src/main/kotlin/kib/dev/tasks/
├── handlers/       # Request handlers for processing HTTP requests
├── models/         # Data models and utility classes
├── repositories/   # Data access layer
├── routes/         # Route definitions
├── services/       # Business logic layer
└── utils/          # Utility functions and helpers
```

## Features

| Feature                                                                                            | Description                                           |
|----------------------------------------------------------------------------------------------------|-------------------------------------------------------|
| [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) | Organized in layers for separation of concerns        |
| [RESTful API](https://ktor.io/docs/routing-in-ktor.html)                                           | Complete CRUD operations for task management          |
| [Default Headers](https://ktor.io/docs/default-headers.html)                                       | Adds a default set of headers to HTTP responses       |
| [Content Negotiation](https://ktor.io/docs/serialization.html)                                     | JSON serialization using kotlinx.serialization        |
| [Status Pages](https://ktor.io/docs/status-pages.html)                                             | Proper error handling with appropriate HTTP responses |

## API Endpoints

| Method | Endpoint     | Description         |
|--------|--------------|---------------------|
| GET    | /tasks       | Get all tasks       |
| GET    | /tasks/{id}  | Get task by ID      |
| POST   | /tasks       | Create a new task   |
| PUT    | /tasks/{id}  | Update task by ID   |
| DELETE | /tasks/{id}  | Delete task by ID   |


## Building & Running

To build or run the project, use one of the following tasks:

| Task                          | Description                                                          |
|-------------------------------|----------------------------------------------------------------------|
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build everything                                                     |
| `buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `buildImage`                  | Build the docker image to use with the fat JAR                       |
| `publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `run`                         | Run the server                                                       |
| `runDocker`                   | Run using the local docker image                                     |

## Getting Started

1. Clone the repository: bash `git clone https://github.com/yourusername/ktasks.git`

2. Navigate to the project directory: `cd ktasks`

3. Run the application: `./gradlew run`


If the server starts successfully, you'll see the following output:

```
2024-12-04 14:32:45.584 [main] INFO  Application - Application started in 0.303 seconds.
2024-12-04 14:32:45.682 [main] INFO  Application - Responding at http://0.0.0.0:8080
```

