INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (2, 'Wireless Mouse', 1299.50, 'Ergonomic wireless mouse', 'Accessories',
     '2025-02-10', 'Logitech', true, 100,
     'mouse.jpg', 'image/jpeg', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (3, 'Mechanical Keyboard', 3499.00, 'RGB mechanical gaming keyboard', 'Accessories',
     '2024-11-20', 'Redragon', true, 50,
     'keyboard.jpg', 'image/jpeg', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (4, 'Smartphone X1', 45999.00, '5G smartphone with AMOLED display', 'Mobile',
     '2025-03-05', 'Samsung', true, 30,
     'smartphone.jpg', 'image/jpeg', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (5, 'Bluetooth Headphones', 5999.00, 'Noise cancelling headphones', 'Audio',
     '2024-12-12', 'Sony', false, 0,
     'headphones.jpg', 'image/jpeg', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (6, 'Gaming Laptop', 74999.00, 'High-performance gaming laptop', 'Laptop',
     '2025-01-15', 'ASUS', true, 25,
     'gaming-laptop.jpg', 'image/jpeg', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (7, 'Smart Watch', 8999.00, 'Fitness smartwatch with heart rate monitoring', 'Wearable',
     '2024-10-05', 'Apple', true, 40,
     'smart-watch.png', 'image/png', NULL);

INSERT INTO PRODUCT
(id, name, price, description, category, release_date, brand, available, quantity,
 image_name, image_type, image_data)
VALUES
    (8, 'Portable Speaker', 4499.00, 'Waterproof Bluetooth portable speaker', 'Audio',
     '2024-08-12', 'JBL', true, 60,

     'speaker.jpg', 'image/jpeg', NULL);
INSERT INTO users (id, username, password) VALUES
                                              (1, 'john_doe', 'pass123'),
                                              (2, 'alice_smith', 'alice456'),
                                              (3, 'bob_wilson', 'bob789'),
                                              (4, 'emma_jones', 'emma123'),
                                              (5, 'david_brown', 'david456'),
                                              (6, 'sophia_miller', 'sophia789'),
                                              (7, 'michael_davis', 'mike123'),
                                              (8, 'olivia_taylor', 'olivia456'),
                                              (9, 'james_anderson', 'james789'),
                                              (10, 'ava_thomas', 'ava123');