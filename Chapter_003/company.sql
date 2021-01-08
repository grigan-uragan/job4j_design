create table department (
	id INT primary key,
	name VARCHAR(50)
);
insert into department (id, name) values (1, 'Oil & Gas Production');
insert into department (id, name) values (2, 'EDP Services');
insert into department (id, name) values (3, 'Metal Fabrications');
insert into department (id, name) values (4, 'Commercial Banks');
insert into department (id, name) values (5, 'Computer Software: Prepackaged Software');
insert into department (id, name) values (6, 'Steel/Iron Ore');
select * from department;
create table employee (
	id INT primary key,
	name VARCHAR(50),
	dept_id INT references department(id)
);
insert into employee (id, name, dept_id) values (1, 'Stormy Milius', 4);
insert into employee (id, name, dept_id) values (2, 'Ilse Cathie', 2);
insert into employee (id, name, dept_id) values (3, 'Suzanna Gimlet', 6);
insert into employee (id, name, dept_id) values (4, 'Gusti Freschini', 6);
insert into employee (id, name, dept_id) values (5, 'Jason Ahmed', 5);
insert into employee (id, name, dept_id) values (6, 'Jeth Alloway', 5);
insert into employee (id, name, dept_id) values (7, 'Dory Sievewright', 5);
insert into employee (id, name, dept_id) values (8, 'Dillie Daniells', 6);
insert into employee (id, name, dept_id) values (9, 'Hy Nail', 6);
insert into employee (id, name, dept_id) values (10, 'Brewster Tonn', 1);
insert into employee (id, name, dept_id) values (11, 'Donn Kinge', 2);
insert into employee (id, name, dept_id) values (12, 'Allsun Webb', 5);
insert into employee (id, name, dept_id) values (13, 'Neddy Crippell', 1);
insert into employee (id, name, dept_id) values (14, 'Jessa Hugle', 2);
insert into employee (id, name, dept_id) values (15, 'Chaunce Hamlin', 6);
insert into employee (id, name, dept_id) values (16, 'Zorine Fishley', 5);
insert into employee (id, name, dept_id) values (17, 'Rea Martini', 4);
insert into employee (id, name, dept_id) values (18, 'Spike Borley', 2);
insert into employee (id, name, dept_id) values (19, 'Lurleen Houdmont', 6);
insert into employee (id, name, dept_id) values (20, 'Teirtza Lafford', 5);
insert into employee (id, name, dept_id) values (21, 'Barnard Faughnan', 1);
insert into employee (id, name, dept_id) values (22, 'Dory Gillott', 3);
insert into employee (id, name, dept_id) values (23, 'Meris Verdey', 5);
insert into employee (id, name, dept_id) values (24, 'Clerkclaude Jude', 5);
insert into employee (id, name, dept_id) values (25, 'Desi Benini', 2);
insert into employee (id, name, dept_id) values (26, 'Laurie Moresby', 4);
insert into employee (id, name, dept_id) values (27, 'Kaleena Truelove', 4);
insert into employee (id, name, dept_id) values (28, 'Tiffani Le Surf', 3);
insert into employee (id, name, dept_id) values (29, 'Finn Grissett', null);
insert into employee (id, name, dept_id) values (30, 'Hedi Oldland', 1);
insert into employee (id, name, dept_id) values (31, 'Auberon Dengel', 4);
insert into employee (id, name, dept_id) values (32, 'Jerrilee McCrachen', 5);
insert into employee (id, name, dept_id) values (33, 'Worthington Pass', 2);
insert into employee (id, name, dept_id) values (34, 'Brandea Stillmann', 3);
insert into employee (id, name, dept_id) values (35, 'Win Skittrall', 5);
insert into employee (id, name, dept_id) values (36, 'Winfield Gloy', 4);
insert into employee (id, name, dept_id) values (37, 'Cacilia Wibrew', 4);
insert into employee (id, name, dept_id) values (38, 'Lancelot Kildale', 2);
insert into employee (id, name, dept_id) values (39, 'Pearl Crips', 3);
insert into employee (id, name, dept_id) values (40, 'Zelig Forton', 1);
insert into employee (id, name, dept_id) values (41, 'Anjela Adamov', 6);
insert into employee (id, name, dept_id) values (42, 'Inigo Leith-Harvey', null);
insert into employee (id, name, dept_id) values (43, 'Lotty Lackey', 3);
insert into employee (id, name, dept_id) values (44, 'Kelly Labitt', 6);
insert into employee (id, name, dept_id) values (45, 'Jobey Fayer', 1);
insert into employee (id, name, dept_id) values (46, 'Marylinda Michurin', 1);
insert into employee (id, name, dept_id) values (47, 'Robbert Cool', 2);
insert into employee (id, name, dept_id) values (48, 'Dalt Caldaro', 1);
insert into employee (id, name, dept_id) values (49, 'Phillida Weitzel', 4);
insert into employee (id, name, dept_id) values (50, 'Wilone Stayt', 1);
insert into employee (id, name, dept_id) values (51, 'Tabbatha Mills', 3);
insert into employee (id, name, dept_id) values (52, 'Aila Masters', 6);
insert into employee (id, name, dept_id) values (53, 'Jillene Hume', 5);
insert into employee (id, name, dept_id) values (54, 'Keriann Exon', null);
insert into employee (id, name, dept_id) values (55, 'Brander Tenpenny', 1);
insert into employee (id, name, dept_id) values (56, 'Cos Bartholomew', 1);
insert into employee (id, name, dept_id) values (57, 'Coriss Maxted', 4);
insert into employee (id, name, dept_id) values (58, 'Abdul Lorryman', 6);
insert into employee (id, name, dept_id) values (59, 'Jillayne Bigrigg', 6);
insert into employee (id, name, dept_id) values (60, 'Emmalee Barwick', 5);
insert into employee (id, name, dept_id) values (61, 'Gertrude Ilewicz', 3);
insert into employee (id, name, dept_id) values (62, 'Bob Pocklington', 2);
insert into employee (id, name, dept_id) values (63, 'Bianca Ortelt', 6);
insert into employee (id, name, dept_id) values (64, 'Pearle Brislane', 5);
insert into employee (id, name, dept_id) values (65, 'Lorianne Neat', 4);
insert into employee (id, name, dept_id) values (66, 'Haywood Kuhn', 6);
insert into employee (id, name, dept_id) values (67, 'Bron Maps', 2);
insert into employee (id, name, dept_id) values (68, 'Justin Lunn', 2);
insert into employee (id, name, dept_id) values (69, 'Celene Wyllis', 3);
insert into employee (id, name, dept_id) values (70, 'Josephina Blackbourn', 6);
insert into employee (id, name, dept_id) values (71, 'Quillan Badcock', 2);
insert into employee (id, name, dept_id) values (72, 'Dario Tilby', 6);
insert into employee (id, name, dept_id) values (73, 'Tammie Coakley', 3);
insert into employee (id, name, dept_id) values (74, 'Todd Connerly', 3);
insert into employee (id, name, dept_id) values (75, 'Corry Squier', 1);
insert into employee (id, name, dept_id) values (76, 'Cordy Illing', 3);
insert into employee (id, name, dept_id) values (77, 'Michel Motton', 1);
insert into employee (id, name, dept_id) values (78, 'Diena Laidlow', 6);
insert into employee (id, name, dept_id) values (79, 'Reinwald Henken', 2);
insert into employee (id, name, dept_id) values (80, 'Claudina Moscrop', 2);
insert into employee (id, name, dept_id) values (81, 'Steward Doram', 1);
insert into employee (id, name, dept_id) values (82, 'Val Gorthy', null);
insert into employee (id, name, dept_id) values (83, 'Reinaldo Hebson', 5);
insert into employee (id, name, dept_id) values (84, 'Caitrin Vamplers', null);
insert into employee (id, name, dept_id) values (85, 'Clemente Deane', 1);
insert into employee (id, name, dept_id) values (86, 'Kelsey Minards', 3);
insert into employee (id, name, dept_id) values (87, 'Kirstyn McCreath', 4);
insert into employee (id, name, dept_id) values (88, 'Papageno Poxon', 5);
insert into employee (id, name, dept_id) values (89, 'Cathyleen Leblanc', 2);
insert into employee (id, name, dept_id) values (90, 'Natassia Valenta', 4);
insert into employee (id, name, dept_id) values (91, 'Nicoli Pracy', 4);
insert into employee (id, name, dept_id) values (92, 'Keelby Tixier', 3);
insert into employee (id, name, dept_id) values (93, 'Rivalee McKenna', 4);
insert into employee (id, name, dept_id) values (94, 'Laureen Janes', 1);
insert into employee (id, name, dept_id) values (95, 'Evonne Whyatt', 1);
insert into employee (id, name, dept_id) values (96, 'Galen Rusbridge', 3);
insert into employee (id, name, dept_id) values (97, 'Mar Beeres', 1);
insert into employee (id, name, dept_id) values (98, 'Raffaello Biggen', 5);
insert into employee (id, name, dept_id) values (99, 'Karita McGillivrie', 1);
insert into employee (id, name, dept_id) values (100, 'Merrill McGirl', 2);
select * from employee;
select * from employee e join department d on e.dept_id = d.id;
select * from employee e left join department d on e.dept_id = d.id;
select * from employee e right join department d on e.dept_id = d.id;
select * from employee e full join department d on e.dept_id = d.id;
select * from employee e cross join department  d;
select e.name, d.name from employee e left join department d on e.dept_id = d.id;
select e.name, d.name from department d right join employee e on e.dept_id = d.id;
select e.name
from employee e left join department d on e.dept_id = d.id where e.dept_id is null;
create table teens (
	id INT primary key,
	name VARCHAR(50),
	gender VARCHAR(50)
);
insert into teens (id, name, gender) values (1, 'Alonso Barlee', 'Male');
insert into teens (id, name, gender) values (2, 'Randie Prewett', 'Female');
insert into teens (id, name, gender) values (3, 'Rhea Tremollet', 'Female');
insert into teens (id, name, gender) values (4, 'Sorcha Clift', 'Female');
insert into teens (id, name, gender) values (5, 'Jasmina Challice', 'Female');
insert into teens (id, name, gender) values (6, 'Merell Kilfeather', 'Male');
insert into teens (id, name, gender) values (7, 'Ralph Ida', 'Male');
insert into teens (id, name, gender) values (8, 'Ernst Novic', 'Male');
insert into teens (id, name, gender) values (9, 'Jackqueline Ortell', 'Female');
insert into teens (id, name, gender) values (10, 'Isaak Ambresin', 'Male');
select * from teens;
select t1.name as first_lover, t2.name as second_lover
from teens t1 cross join teens t2 where t1.gender != t2.gender group by t1.name, t2.name;





