-- src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS data_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data VARCHAR(255) NOT NULL
);
