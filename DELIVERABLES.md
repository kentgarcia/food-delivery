Online Food Delivery System with Real-Time Order Tracking
Objective:
Develop an application where customers can place food delivery orders, and restaurants and delivery personnel receive and process these orders in real-time using Spring Boot and RabbitMQ for communication. There is no need for a multi-module project. Just create a one springboot project.

---

## http://localhost:8080/swagger-ui/index.html

Project Requirements:

1. Services
   [/] Customer Service: Allows customers to browse restaurants, add items to a cart, and place orders.
   [/] Order Service: Manages incoming orders and interacts with RabbitMQ to distribute order details to the restaurant and delivery personnel services.
   [/] Restaurant Service: Receives orders for the restaurant, accepts or rejects them, and notifies the customer.
   [/] Delivery Service: Assigns a delivery person to accepted orders and tracks the delivery process.
   o Notification Service: Sends email/SMS notifications to customers about order status changes.
2. RabbitMQ Integration:
   [/] Publish-subscribe model to distribute order events (e.g., new order, order acceptance, delivery status).
   [/] Queue-based messaging to handle notifications.
3. Persistence Layer:
   [/] Use MySQL or PostgreSQL for data persistence in each service.
   [/] Store customer details, order details, restaurant menus, and delivery status.
4. APIs:
   [/] RESTful APIs for interacting with microservices.
5. Frontend (Optional):
   [/] If desired, create a basic web app or mobile interface to interact with the backend.

---

Key Features:

1. Customers can:
   [/] Register and log in.
   [/] Browse restaurants and menus.
   [o] Place orders and view order status in real-time.
2. Restaurants can:
   [o] Receive and accept/reject orders.
   [o] Notify customers of order preparation completion.
3. Delivery personnel can:
   [o] View assigned orders.
   [o] Update delivery status (e.g., picked up, delivered)
4. Notifications:
   [o] Customers get real-time notifications for order updates.

---

Evaluation Rubric:
Criteria Weight Details
Project Design 20% Quality of microservices design, use of RabbitMQ, and choice of architecture.
Functionality 30% Proper implementation of requirements: customer, restaurant, delivery flows.
RabbitMQ Integration 20% Efficient use of messaging queues, pub-sub patterns, and acknowledgment handling.
Code Quality & Best Practices 10% Use of clean, maintainable code, exception handling, logging, and comments.
Database Design 10% Proper database schema design and efficient queries.
Documentation 5% Clear project documentation, including README with setup instructions.
Innovation & User Experience 5% Optional: Extra features, intuitive UI (if frontend is implemented).

---
