CREATE TABLE Categories (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO Categories (id, name) VALUES
(1, 'Electronics'),
(2, 'Computers'),
(3, 'Mobiles'),
(4, 'Laptops'),
(5, 'Desktops'),
(6, 'Smartphones'),
(7, 'Tablets'),
(8, 'Accessories'),
(9, 'Headphones'),
(10, 'Chargers');

CREATE TABLE Products (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    available BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Categories(id)
);

INSERT INTO Products (id, name, category_id, price, available) VALUES
(1, 'iPhone 12', 6, 999.99, TRUE),
(2, 'Samsung Galaxy S21', 6, 799.99, TRUE),
(3, 'MacBook Pro', 4, 1299.99, TRUE),
(4, 'Dell XPS', 4, 1199.99, TRUE),
(5, 'iPad Pro', 7, 799.99, TRUE),
(6, 'Samsung Galaxy Tab', 7, 499.99, TRUE),
(7, 'AirPods Pro', 9, 199.99, TRUE),
(8, 'Sony WH-1000XM4', 9, 349.99, TRUE),
(9, 'Apple 20W USB-C Power Adapter', 10, 19.99, TRUE),
(10, 'Anker USB-C Charger', 10, 29.99, TRUE);