-- Inserting initial data into the student table
INSERT INTO student (name, email)
VALUES ('Alice Johnson', 'alice.johnson@example.com'),
       ('Bruno Silva', 'bruno.silva@example.com'),
       ('Carla Mendes', 'carla.mendes@example.com');

-- Insert initial data into the course table
INSERT INTO course (name, description)
VALUES ('Java Fundamentals', 'Introduction to Java programming, covering syntax, OOP, and basic APIs.'),
       ('Database Design', 'Learn relational database concepts, normalization, and SQL queries.'),
       ('Spring Boot Basics', 'Build REST APIs and microservices using Spring Boot framework.');
