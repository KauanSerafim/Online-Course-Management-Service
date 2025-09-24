-- Student table
CREATE TABLE student
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(100) NOT NULL,
    email             VARCHAR(150) NOT NULL UNIQUE,
    registration_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Course table
CREATE TABLE course
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL,
    create_date TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Enrollment table
CREATE TABLE enrollment
(
    id              BIGSERIAL PRIMARY KEY,
    student_id      BIGINT    NOT NULL,
    course_id       BIGINT    NOT NULL,
    enrollment_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE CASCADE,
    CONSTRAINT uq_student_course UNIQUE (student_id, course_id) -- avoids duplicate registration
);
