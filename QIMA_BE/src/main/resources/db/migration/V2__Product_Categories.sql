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
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category_id INT,
    price DECIMAL(10, 2) NOT NULL,
    available BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Categories(id)
);

INSERT INTO Products (name, category_id, price, available) VALUES
('iPhone 12', 6, 999.99, TRUE),
('Samsung Galaxy S21', 6, 799.99, TRUE),
('MacBook Pro', 4, 1299.99, TRUE),
('Dell XPS', 4, 1199.99, TRUE),
('iPad Pro', 7, 799.99, TRUE),
('Samsung Galaxy Tab', 7, 499.99, TRUE),
('AirPods Pro', 9, 199.99, TRUE),
('Sony WH-1000XM4', 9, 349.99, TRUE),
('Apple 20W USB-C Power Adapter', 10, 19.99, TRUE),
('Anker USB-C Charger', 10, 29.99, TRUE),
('Product 11', 1, 100.99, TRUE),
('Product 12', 2, 200.99, TRUE),
('Product 13', 3, 300.99, TRUE),
('Product 14', 4, 400.99, TRUE),
('Product 15', 5, 500.99, TRUE);