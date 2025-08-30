CREATE TABLE student
(
    id      SERIAL PRIMARY KEY,
    version int,
    name    VARCHAR(100) NOT NULL
);

CREATE TABLE course
(
    id          SERIAL PRIMARY KEY,
    version     int,
    name        VARCHAR(100) NOT NULL,
    description TEXT         NOT NULL
);

CREATE TABLE student_course
(
    id         SERIAL PRIMARY KEY,
    student_id INTEGER NOT NULL,
    course_id  INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES course (id) ON DELETE CASCADE,
    UNIQUE (student_id, course_id)
);