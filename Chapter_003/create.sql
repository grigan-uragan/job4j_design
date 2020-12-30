CREATE TABLE role(
role_id int PRIMARY KEY,
role_name varchar(255)
);
create table users(
users_id int primary key,
user_name varchar(255),
role_id int references role(role_id)
);
CREATE TABLE rules(
rules_id int PRIMARY KEY,
rules_name varchar(255)
);
CREATE TABLE role_rule(
role_rule_id int PRIMARY KEY,
role_id int references role(role_id),
rules_id int references rules(rules_id)
);
CREATE TABLE category(
category_id int PRIMARY KEY,
category_name varchar(255)
);
CREATE TABLE state(
state_id int PRIMARY KEY,
state_name varchar(255)
);
CREATE TABLE item(
item_id int PRIMARY KEY,
description text,
users_id_fk int references users(users_id),
category_id_fk int references category(category_id),
state_id_fk int references state(state_id)
);
CREATE TABLE comments(
comments_id int PRIMARY KEY,
comments text,
users_id_fk int references users(users_id),
item_id_fk int references item(item_id)
);