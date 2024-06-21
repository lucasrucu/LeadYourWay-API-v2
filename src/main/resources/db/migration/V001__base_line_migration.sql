CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id VARCHAR(255) NOT NULL,
    created_date DATETIME(6) NOT NULL,
    deleted BIT,
    email VARCHAR(255),
    google_name VARCHAR(255),
    google_photo_url VARCHAR(255),
    role_id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE cards (
    id BIGINT NOT NULL AUTO_INCREMENT,
    created_date DATETIME(6) NOT NULL,
    deleted BIT,
    updated_date DATETIME(6),
    card_amount FLOAT NOT NULL,
    card_cvv VARCHAR(255) NOT NULL,
    card_expiration_date DATETIME(6) NOT NULL,
    card_holder VARCHAR(255) NOT NULL,
    card_main BIT NOT NULL,
    card_number VARCHAR(255) NOT NULL,
    card_type VARCHAR(255) NOT NULL,
    user_id VARCHAR(255),
    PRIMARY KEY (id)
);
    
ALTER TABLE users
    ADD CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles(id);

ALTER TABLE cards
    ADD CONSTRAINT fk_cards_users FOREIGN KEY (user_id) REFERENCES users(id);