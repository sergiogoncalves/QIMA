CREATE TABLE login (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO login (name, email, password) VALUES ('qima', 'qima@qima.com', '$2a$10$m3NEwooR8x.aGtCqoOCZduyQl1qKOIFz9AUHO0owKEW3k3Wqw4An6');