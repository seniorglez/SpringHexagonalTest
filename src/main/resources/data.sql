CREATE TABLE IF NOT EXISTS price (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    amount DECIMAL,
    currency VARCHAR(3),
    last_update TIMESTAMP,
    last_update_by VARCHAR(255),
    CONSTRAINT price_brand_fk FOREIGN KEY (brand_id) REFERENCES brand (id),
    CONSTRAINT price_product_fk FOREIGN KEY (product_id) REFERENCES product (id)
);

INSERT INTO price (brand_id, start_date, end_date, price_list, product_id, priority, amount, currency, last_update, last_update_by) VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.5, 'EUR', '2020-03-26 14:49:07', 'user1');
INSERT INTO price (brand_id, start_date, end_date, price_list, product_id, priority, amount, currency, last_update, last_update_by) VALUES (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR', '2020-05-26 15:38:22', 'user1');
INSERT INTO price (brand_id, start_date, end_date, price_list, product_id, priority, amount, currency, last_update, last_update_by) VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.5, 'EUR', '2020-05-26 15:39:22', 'user2');
INSERT INTO price (brand_id, start_date, end_date, price_list, product_id, priority, amount, currency, last_update, last_update_by) VALUES (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR', '2020-06-02 10:14:00', 'user1');
