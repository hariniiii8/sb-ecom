# Spring Boot E-Commerce Project

A full-stack e-commerce application built with **Spring Boot** (backend) and **React + Vite** (frontend).

## 📚 Course Attribution

This project is based on the **Java Spring Boot Professional eCommerce Project Masterclass** course.
- **Course Repository**: [EmbarkXOfficial/spring-boot-course](https://github.com/EmbarkXOfficial/spring-boot-course)
- **Course Provider**: EmbarkX Official

## 🏗️ Project Architecture

### Backend (Spring Boot)
- **Framework**: Spring Boot 4.0.1
- **Database**: PostgreSQL
- **Security**: JWT Authentication & Authorization
- **Payment Integration**: Stripe API
- **API Documentation**: Swagger/OpenAPI

### Frontend (React + Vite)
- **Framework**: React with Vite
- **State Management**: Redux
- **UI Components**: Modern React components
- **Styling**: CSS/Tailwind

## 🗂️ Project Structure

```
sb-ecom/
├── src/main/java/com/ecommerce/project/
│   ├── config/          # Configuration classes (WebMvc, Swagger, App constants)
│   ├── security/        # JWT & Authentication configuration
│   ├── controller/      # REST API endpoints
│   ├── service/         # Business logic layer
│   ├── repositories/    # Data access layer (JPA)
│   ├── model/           # Domain entities
│   ├── payload/         # DTOs for API requests/responses
│   ├── exceptions/      # Custom exception handling
│   └── util/            # Utility classes
├── ecom-frontend/       # React frontend application
├── images/              # Product images and assets
└── pom.xml             # Maven dependencies
```

## 🚀 Getting Started

### Backend Setup
1. Install Java 24 and Maven
2. Configure PostgreSQL database
3. Update `application.properties` with database credentials and Stripe key
4. Run: `mvn spring-boot:run`

### Frontend Setup
1. Navigate to `ecom-frontend/`
2. Install dependencies: `npm install`
3. Run development server: `npm run dev`

## 📚 Learning Journey

This project implements:
- **RESTful API Design** with proper status codes and error handling
- **Database Design** with relationships (One-to-Many, Many-to-One)
- **Authentication & Authorization** using JWT tokens
- **Payment Processing** integration with Stripe
- **CRUD Operations** across multiple entities
- **Pagination & Filtering** for product listings
- **Global Exception Handling** for consistent error responses
- **Frontend-Backend Integration** with proper API calls

## 🛠️ Key Features

✅ User Authentication & Authorization  
✅ Product Catalog with Categories  
✅ Shopping Cart Management  
✅ Order Management  
✅ Payment Processing  
✅ User Profile Management  
✅ Admin Dashboard  
✅ Image Upload Support  

## 📦 Dependencies

### Backend
- Spring Boot Web MVC
- Spring Data JPA
- Spring Security
- JWT (jjwt)
- Lombok
- ModelMapper
- Stripe Java SDK
- PostgreSQL Driver

### Frontend
- React
- Vite
- Redux
- Axios

## 🤝 Development Notes

This is a learning-focused implementation following professional Spring Boot and React best practices. The code emphasizes:
- Clean code principles
- Proper separation of concerns
- RESTful API design
- Security best practices
- Error handling and validation

## 📝 License

This project is a learning implementation based on course material. 

---

**Last Updated**: May 25, 2026
