create table if not exists products (id bigSerial primary key, title varchar(255), price int, secret_key varchar(255));

insert into products (title, price,secret_key)
values
('Apple', 19)
('Apple1', 29)
('Apple2', 39)
('Apple3', 49)
('Apple4', 59)
('Apple5', 69)
('Apple6', 79)
('Apple7', 89)
('Apple8', 99)
('Apple9', 9)
