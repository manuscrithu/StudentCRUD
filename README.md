# StudentCRUDBackend

A simple **Spring Boot + MySQL** RESTful backend for managing students, featuring full CRUD operations, search functionality, and centralized exception handling.

This backend is Dockerized and provides easy API exploration using **Swagger UI**.

---

## 📁 Project Structure

```
StudentCRUDBackend/
├── src/
│   ├── main/
│   │   ├── java/com/example/StudentCRUDBackend/
│   │   │   ├── controller/         # REST Controllers
│   │   │   ├── model/              # JPA Entities
│   │   │   ├── repository/         # Spring Data JPA Repositories
│   │   │   ├── service/            # Business Logic Layer
│   │   │   └── exception/          # Global Exception Handling
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/...
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🚀 Features

* ✅ Create, Read, Update, and Delete students
* ✅ Search students by name or course
* ✅ Centralized exception handling
* ✅ Swagger UI API documentation
* ✅ MySQL integration
* ✅ Dockerized backend

---

## 🛠️ Requirements

Before running, ensure you have:

* **Java 21+**
* **Maven 3.9+**
* **Docker Desktop**
* **Git**

---

## ⚙️ Run Locally (Without Docker)

### 1️⃣ Clone the repository

```bash
git clone https://github.com/<your-username>/student-crud-backend.git
cd student-crud-backend
```

### 2️⃣ Configure MySQL

Make sure MySQL is running and create a database:

```sql
CREATE DATABASE studentdb;
```

Then edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3️⃣ Build and Run

```bash
mvn clean package
mvn spring-boot:run
```

### 4️⃣ Access the Application

* Backend API: [http://localhost:8080](http://localhost:8080)
* Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🚀 Run with Docker (Recommended)

### 1️⃣ Build Docker Images

```bash
docker compose build
```

### 2️⃣ Start the Services

```bash
docker compose up
```

This will start both containers:

* **student-crud-backend** (Spring Boot app)
* **mysql** (database)

### 3️⃣ Verify Containers

```bash
docker ps
```

### 4️⃣ Access Services

* Backend: [http://localhost:8080](http://localhost:8080)
* Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
* MySQL: running at `localhost:3306`

---

## 🔍 Example API Endpoints

| Method   | Endpoint                                     | Description                    |
| -------- | -------------------------------------------- | ------------------------------ |
| `POST`   | `/api/students`                              | Create a new student           |
| `GET`    | `/api/students`                              | Get all students               |
| `GET`    | `/api/students/{id}`                         | Get student by ID              |
| `PUT`    | `/api/students/{id}`                         | Update student details         |
| `DELETE` | `/api/students/{id}`                         | Delete a student               |
| `GET`    | `/api/students/search?name=John&course=Math` | Search students by name/course |

---

## 💡 Tips

* To rebuild only the backend:

  ```bash
  docker compose up --build student-crud-backend
  ```
* To stop all containers:

  ```bash
  docker compose down
  ```
* To reset MySQL data, remove the local volume folder (e.g., `mysql_data/`).

---

## 🔗 Swagger UI

Access Swagger UI after starting the app:

```
http://localhost:8080/swagger-ui/index.html
```

This lets you explore all endpoints interactively.

---

## 🔧 Technologies Used

* Spring Boot 3.x
* Spring Data JPA
* MySQL 8
* Docker & Docker Compose
* Swagger (Springdoc OpenAPI)
* Maven
* Java 21

---

## 🎉 Author

**Bhanuka Wickramasinghe**
[GitHub](https://github.com/manuscirthu)

---

## 🔒 License

This project is licensed under the MIT License.
