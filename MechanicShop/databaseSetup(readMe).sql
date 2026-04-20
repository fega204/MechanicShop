-- little template for u guys to build the database in case needed

CREATE DATABASE IF NOT EXISTS mechanic_shop;
USE mechanic_shop;

CREATE TABLE IF NOT EXISTS vehicle (
    id INT PRIMARY KEY,
    make VARCHAR(100),
    model VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS servicerecord (
    id INT PRIMARY KEY,
    vehicle_id INT,
    service VARCHAR(255),
    cost DOUBLE
);

CREATE TABLE IF NOT EXISTS part (
    part_id INT PRIMARY KEY,
    part_name VARCHAR(100),
    quantity INT,
    unit_price DOUBLE
);

CREATE TABLE IF NOT EXISTS invoice (
    invoice_id INT PRIMARY KEY,
    part_id INT,
    quantity_used INT,
    service_description VARCHAR(255),
    labor_cost DOUBLE,
    total_cost DOUBLE
);