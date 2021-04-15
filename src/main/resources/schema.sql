use jdbc1;

drop table orders;
drop table customers;

create table if not exists customers
(
    ID           int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name         varchar(255),
    surname      varchar(255),
    age          int,
    phone_number int
);

insert into customers (ID, name, surname, age, phone_number)
VALUES (1, 'Alexey', 'Alexeyev', 20, 22222222);
insert into customers (ID, name, surname, age, phone_number)
VALUES (2, 'Petr', 'Petrov', 21, 22222223);
insert into customers (ID, name, surname, age, phone_number)
VALUES (3, 'Ivan', 'Ivanov', 29, 22222224);
insert into customers (ID, name, surname, age, phone_number)
VALUES (4, 'Alexey', 'Smit', 20, 22222226);
insert into customers (ID, name, surname, age, phone_number)
VALUES (5, 'Andrei', 'Alexeyev', 31, 22222226);
insert into customers (ID, name, surname, age, phone_number)
VALUES (6, 'Jon', 'Jonov', 45, 22222221);

create index index_id on customers(ID);

create table if not exists orders
(
    ID           int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date         varchar(255),
    customer_id  int,
    product_name varchar(255),
    amount       double,
    foreign key (customer_id) references customers (ID)

);

insert into orders (ID, date, customer_id, product_name, amount)
VALUES (1, '22.22', 1, 'тостер', 20.0);
insert into orders (ID, date, customer_id, product_name, amount)
VALUES (2, '22.22', 2, 'нож', 30.0);
insert into orders (ID, date, customer_id, product_name, amount)
VALUES (3, '22.22', 3, 'чайник', 40.0);
insert into orders (ID, date, customer_id, product_name, amount)
VALUES (4, '22.22', 4, 'плита', 50.0);
insert into orders (ID, date, customer_id, product_name, amount)
VALUES (5, '22.22', 5, 'холодильник', 60.0);
insert into orders (ID, date, customer_id, product_name, amount)
VALUES (6, '22.22', 6, 'духовка', 70.0);