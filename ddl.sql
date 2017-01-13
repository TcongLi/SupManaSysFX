CREATE TABLE comp_repo
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    comp_id CHAR(36),
    repo_id CHAR(36),
    storage INT NOT NULL,
    CONSTRAINT FK_comp_repo_component FOREIGN KEY (comp_id) REFERENCES component (id),
    CONSTRAINT FK_comp_repo_repo FOREIGN KEY (repo_id) REFERENCES repo (id)
);
CREATE TABLE comp_supplier
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    comp_id CHAR(36),
    supplier_id CHAR(36),
    CONSTRAINT FK_comp_supplier_component FOREIGN KEY (comp_id) REFERENCES component (id),
    CONSTRAINT FK_comp_supplier_supplier FOREIGN KEY (supplier_id) REFERENCES supplier (id)
);
CREATE TABLE comp_type
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    type_name NCHAR(10) NOT NULL
);
CREATE TABLE component
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    type_id CHAR(36),
    name NCHAR(10),
    price FLOAT NOT NULL,
    info TEXT,
    prod_id CHAR(36),
    CONSTRAINT FK_component_comp_type FOREIGN KEY (type_id) REFERENCES comp_type (id),
    CONSTRAINT FK_component_product FOREIGN KEY (prod_id) REFERENCES product (id)
);
CREATE TABLE customer
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    phone CHAR(20) NOT NULL,
    name NVARCHAR(10) NOT NULL,
    gender NCHAR(4) NOT NULL,
    address NVARCHAR(30),
    mail VARCHAR(20)
);
CREATE TABLE order_comp
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    order_id CHAR(36),
    comp_id CHAR(36),
    amount INT NOT NULL,
    CONSTRAINT FK_order_supplier_perchase_order FOREIGN KEY (order_id) REFERENCES purchase_order (id),
    CONSTRAINT FK_order_supplier_component FOREIGN KEY (comp_id) REFERENCES component (id)
);
CREATE TABLE order_prod
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    order_id CHAR(36),
    prod_id CHAR(36),
    amount INT NOT NULL,
    CONSTRAINT FK_order_prod_sale_order FOREIGN KEY (order_id) REFERENCES sale_order (id),
    CONSTRAINT FK_order_prod_product FOREIGN KEY (prod_id) REFERENCES product (id)
);
CREATE TABLE prod_repo
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    prod_id CHAR(36),
    repo_id CHAR(36),
    storage INT NOT NULL,
    CONSTRAINT FK_prod_repo_product FOREIGN KEY (prod_id) REFERENCES product (id),
    CONSTRAINT FK_prod_repo_repo1 FOREIGN KEY (repo_id) REFERENCES repo (id)
);
CREATE TABLE product
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    name NVARCHAR(20) NOT NULL,
    sales INT NOT NULL,
    price FLOAT NOT NULL,
    info TEXT
);
CREATE TABLE purchase_order
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    date SMALLDATETIME NOT NULL,
    supplier_id CHAR(36),
    CONSTRAINT FK_perchase_order_supplier FOREIGN KEY (supplier_id) REFERENCES supplier (id)
);
CREATE TABLE repo
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    name NCHAR(10),
    address NVARCHAR(20) NOT NULL,
    type NCHAR(10)
);
CREATE TABLE sale_order
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    date SMALLDATETIME NOT NULL,
    customer_id CHAR(36),
    CONSTRAINT FK_sale_order_customer FOREIGN KEY (customer_id) REFERENCES customer (id)
);
CREATE TABLE staff
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    name NVARCHAR(20) NOT NULL,
    gender NCHAR(4) NOT NULL,
    address NVARCHAR(30),
    dept NCHAR(10)
);
CREATE TABLE staff_prod
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    staff_id CHAR(36),
    prod_id CHAR(36),
    CONSTRAINT FK_staff_prod_staff FOREIGN KEY (staff_id) REFERENCES staff (id),
    CONSTRAINT FK_staff_prod_product FOREIGN KEY (prod_id) REFERENCES product (id)
);
CREATE TABLE supplier
(
    id CHAR(36) PRIMARY KEY NOT NULL,
    name NCHAR(10) NOT NULL,
    phone CHAR(20),
    address NVARCHAR(30),
    mail VARCHAR(20)
);
CREATE TABLE sysdiagrams
(
    name SYSNAME NOT NULL,
    principal_id INT NOT NULL,
    diagram_id INT PRIMARY KEY NOT NULL IDENTITY,
    version INT,
    definition VARBINARY
);
CREATE UNIQUE INDEX UK_principal_name ON sysdiagrams (principal_id, name);
CREATE FUNCTION fn_diagramobjects();
CREATE PROCEDURE sp_alterdiagram(@diagramname SYSNAME, @owner_id INT, @version INT, @definition VARBINARY);
CREATE PROCEDURE sp_creatediagram(@diagramname SYSNAME, @owner_id INT, @version INT, @definition VARBINARY);
CREATE PROCEDURE sp_dropdiagram(@diagramname SYSNAME, @owner_id INT);
CREATE PROCEDURE sp_helpdiagramdefinition(@diagramname SYSNAME, @owner_id INT);
CREATE PROCEDURE sp_helpdiagrams(@diagramname SYSNAME, @owner_id INT);
CREATE PROCEDURE sp_renamediagram(@diagramname SYSNAME, @owner_id INT, @new_diagramname SYSNAME);
CREATE PROCEDURE sp_upgraddiagrams();