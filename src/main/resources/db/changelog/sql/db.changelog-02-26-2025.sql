CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    customer_mobile VARCHAR(20) NOT NULL,
    customer_email VARCHAR(50) NOT NULL,
    address1 VARCHAR(100) NOT NULL,
    address2 VARCHAR(100),
    account_type ENUM('S', 'C') NOT NULL
)