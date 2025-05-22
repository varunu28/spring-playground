CREATE TABLE users (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    birthdate DATE
);

INSERT INTO users (name, birthdate) VALUES ('Alice', '1990-01-01');
INSERT INTO users (name, birthdate) VALUES ('Bob', '1985-05-15');