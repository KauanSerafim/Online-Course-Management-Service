-- Ensure uniqueness of the "name" field in the course table
ALTER TABLE course
    ADD CONSTRAINT uq_course_name UNIQUE (name);
