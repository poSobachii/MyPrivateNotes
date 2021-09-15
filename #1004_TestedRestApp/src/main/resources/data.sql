INSERT INTO db_customers (name, surname, country, email, password)
VALUES  ('Steve', 'Stifler', 'USA', 'stifler@pie.com', 'ABC=@-/'),
        ('James', 'Levenstein', 'USA', 'levenstein@pie.com', 'ABC=@-/'),
        ('Michelle ', 'Flaherty', 'USA', 'flaherty@pie.com', 'ABC=@-/'),
        ('Paul', 'Finch', 'USA', 'finch@pie.com', 'ABC=@-/');

INSERT INTO db_cards (amount, currency, exp_date, customer_id)
VALUES  (100, 'EUR', '06/23', 1),
        (100, 'EUR', '06/23', 2),
        (100, 'EUR', '06/23', 3);