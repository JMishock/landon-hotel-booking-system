# Landon Hotel Booking System

A Dockerized hotel reservation application built with Java, Spring Boot, Angular, multithreading, internationalization, currency display, and time-zone conversion.

This project was completed as part of Western Governors University's Advanced Java (D387) course. The original Landon Hotel starter application was extended to support multilingual welcome messages, multi-currency reservation pricing, time-zone conversion, and Docker containerization.

---

## Application Preview

![Landon Hotel Booking System](screenshots/landon-hotel-home.jpg)

---

## Project Overview

The application provides a hotel reservation interface with a Java Spring Boot back end and an Angular front end.

The project demonstrates:

- Full-stack application development
- Java multithreading
- Internationalization (i18n) and localization
- Angular front-end development
- RESTful API integration
- Time-zone conversion
- Multi-currency price display
- Docker containerization

---

## Features

- English and French welcome messages displayed using Java ResourceBundles
- Live presentation times converted into multiple time zones
- Hotel room reservation interface
- Multi-currency room pricing (USD, CAD, EUR)
- Spring Boot REST API
- Angular front-end
- Docker support for containerized deployment

---

## Technologies Used

### Backend

- Java 17
- Spring Boot
- Maven

### Frontend

- Angular
- TypeScript
- HTML5
- CSS

### Additional Technologies

- Docker
- REST APIs
- Java ResourceBundles
- Java Multithreading

---

## Running the Project

Clone the repository:

```bash
git clone https://github.com/JMishock/landon-hotel-booking-system.git
```

Navigate into the project:

```bash
cd landon-hotel-booking-system
```

Build the project:

```bash
./mvnw clean package
```

Build the Docker image:

```bash
docker build -t landon-hotel .
```

Run the container:

```bash
docker run -p 8080:8080 landon-hotel
```

Then open:

```
http://localhost:8080
```

---

## Learning Objectives

This project demonstrates practical experience with:

- Java concurrency using multithreading
- Internationalization and localization
- Spring Boot REST services
- Angular client integration
- Docker containerization
- Maven project management
- Enterprise Java application development

---

## Project Status

This project has been completed and is maintained as part of my software engineering portfolio.

While originally developed as part of Western Governors University's Advanced Java course, the repository has been updated and documented to showcase full-stack Java development, containerization, and enterprise application architecture.

---

## License

This project is intended for educational and portfolio purposes.
