create table meeting(
meeting_id serial primary key,
meeting_name text
);

insert into meeting(meeting_name) values
('BirthDay Svetky Sokolovoy'), ('Happy New Year Party'), ('Work Brifing');

create table users (
users_id serial primary key,
users_name text
);

insert into users (users_name) values
('Tom'), ('John'), ('Mark'), ('Bob');

create table meeting_status(
meeting_status_id serial primary key,
meeting_status_name text
);

insert into meeting_status (meeting_status_name) values
('confirmed'), ('rejected');

create table orders (
orders_id serial primary key,
meeting_status_id int references meeting_status(meeting_status_id),
meeting_id int references meeting(meeting_id),
users_id int references users(users_id)
);

insert into meeting_stats (meeting_status_id, meeting_id, users_id) values
(1, 1, 1), (1, 2, 2), (2, 3, 3), (2, 3, 4);

select m.meeting_name as meeting, count(*)
from orders o left join meeting m using(meeting_id)
left join meeting_status ms using(meeting_status_id)
where meeting_status_name = 'confirmed'
group by meeting;

select m.meeting_name as meeting
from orders o
left join meeting m using(meeting_id)
left join meeting_status ms using(meeting_status_id)
where meeting_status_name = 'rejected'
group by meeting;