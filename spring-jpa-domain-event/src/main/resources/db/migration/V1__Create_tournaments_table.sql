CREATE TABLE tournaments
(
    id          BIGSERIAL PRIMARY KEY,
    description VARCHAR(255),
    start_date  TIMESTAMP WITHOUT TIME ZONE,
    end_date    TIMESTAMP WITHOUT TIME ZONE
);