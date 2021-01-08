create table car_body(
	body_id serial primary key,
	body_name varchar(100)
);
create table car_engine (
	engine_id serial primary key,
	engine_name varchar(100)
);
create table car_transmission (
	transmission_id serial primary key,
	transmission_name varchar(100)
);
create table car_project (
	car_project_id serial primary key,
	car_project_name varchar(200),
	body_id int references car_body(body_id),
	engine_id int references car_engine(engine_id),
	transmission_id int references car_transmission(transmission_id)
);
insert into car_body (body_name)
values ('sedan'), ('pickup'), ('coupe'), ('hatchback'), ('crossover');
insert into car_engine (engine_name)
values ('disel'), ('gasoline'), ('hybride');
insert into car_transmission(transmission_name)
values ('AT'), ('MT'), ('robot'), ('variator');
insert into car_project (car_project_name, body_id, engine_id, transmission_id)
values ('WV Tiguan', 5, 1, 1), ('LADA Priora', 1, 2, 2), ('KIA RIO', 1, 2, 1);

select c.car_project_name as model, b.body_name as version, e.engine_name as engine, t.transmission_name as KPP
from car_project c left join car_body b on c.body_id = b.body_id
left join car_engine e on c.engine_id = e.engine_id
left join car_transmission t on c.transmission_id = t.transmission_id;

select b.body_name as version, e.engine_name as engine, t.transmission_name as KPP
from car_project c full join car_body b on c.body_id = b.body_id
full join car_engine e on c.engine_id = e.engine_id
full join car_transmission t on c.transmission_id = t.transmission_id where c.car_project_name is null;