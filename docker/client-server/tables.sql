CREATE TABLE PRODUCT_CATEGORY
(
    ID_PRODUCT_CATEGORY INT AUTO_INCREMENT,
    NAME                VARCHAR(64) NOT NULL,
    PRIMARY KEY (ID_PRODUCT_CATEGORY),
    UNIQUE (NAME)
);

CREATE TABLE PRODUCT
(
    ID_PRODUCT          CHAR(6),
    NAME                VARCHAR(64) NOT NULL,
    PRICE               FLOAT       NOT NULL,
    QUANTITY            SMALLINT    NOT NULL,
    ID_PRODUCT_CATEGORY INT         NOT NULL,
    PRIMARY KEY (ID_PRODUCT),
    FOREIGN KEY (ID_PRODUCT_CATEGORY) REFERENCES PRODUCT_CATEGORY (ID_PRODUCT_CATEGORY)
);

CREATE TABLE INVOICE_PRODUCT
(
    ID_INVOICE_PRODUCT  CHAR(36)    NOT NULL,
    CHECKOUT_ID         CHAR(36)    NOT NULL,
    PRICE               FLOAT       NOT NULL,
    QUANTITY            TINYINT     NOT NULL,
    ID_PRODUCT          CHAR(6)     NOT NULL,
    PRIMARY KEY (ID_INVOICE_PRODUCT),
    INDEX (CHECKOUT_ID),
    FOREIGN KEY (ID_PRODUCT) REFERENCES PRODUCT (ID_PRODUCT)
);

CREATE TABLE INVOICE
(
    ID_INVOICE      CHAR(36)    NOT NULL,
    PUBLISHED_DATE  DATETIME    NOT NULL,
    PRICE           FLOAT       NOT NULL,
    PAYMENT_METHOD  VARCHAR(32) NOT NULL,
    PRIMARY KEY (ID_INVOICE),
    FOREIGN KEY (ID_INVOICE) REFERENCES INVOICE_PRODUCT (CHECKOUT_ID)
);
