create table employees(
	id SERIAL primary key,
	empl_first_name VARCHAR(50) not null,
	empl_last_name VARCHAR(50) not null,
	--empl_role VARCHAR(20),
	--empl_salary NUMERIC(8,2),
	empl_email VARCHAR(75) unique,
	empl_pass VARCHAR(50) not null
);
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (1, 'Lulu', 'Pickup', 'lpickup0@cnet.com', 'AvA7VQ1b');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (2, 'Conway', 'Perri', 'cperri1@ask.com', 'mc4XVxnj');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (3, 'Hallie', 'Gillespey', 'hgillespey2@list-manage.com', 'u81s6RS1dcie');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (4, 'Alys', 'Mowsdill', 'amowsdill3@gmpg.org', 'zuJmYOV');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (5, 'Aileen', 'Folonin', 'afolonin4@cafepress.com', '2LSGkGm');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (6, 'Tiffy', 'Stainburn', 'tstainburn5@ucsd.edu', 'KNqMLmPkav2');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (7, 'Brooke', 'Reinert', 'breinert6@spotify.com', 'YVQvg0');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (8, 'Amelia', 'Corzor', 'acorzor7@yandex.ru', '6PWdTkqi1F');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (9, 'Dee dee', 'Gossling', 'dgossling8@live.com', '5UppAA5IcVL');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (10, 'Nerissa', 'Turnock', 'nturnock9@unicef.org', '6hoa3kaQM2tV');
insert into employees (id, empl_first_name, empl_last_name, empl_email, empl_pass) values (11, 'Boyd', 'Rupp', 'bruppa@hatena.ne.jp', 'Sve5GWg');

/*create table login(
	id SERIAL primary key,
	email VARCHAR(75),
	constraint  fk1 FOREIGN KEY (email) REFERENCES employees(empl_email) ||	constraint  fk2 FOREIGN KEY (email) REFERENCES users(user_email)
);
insert into login (email) values ('lpickup0@cnet.com');
insert into login (email) values ('pcockhill0@economist.com');*/
drop table cars;
create table cars(
	vin VARCHAR(20) primary key,
	car_year NUMERIC(4,0) not null,
	make VARCHAR(20) not null,
	model VARCHAR(20) not null,
	price NUMERIC(8,2) not null,
	offers BOOLEAN not null,
	remaining_bal NUMERIC (8,2),
	length_con INTEGER,
	user_id INTEGER references users(user_id),
	empl_id INTEGER references employees(id)
);
delete from cars where vin = '19UUA76617A789090';
insert into cars (vin, car_year, make, model, price, offers) values ('19UUA76617A789090', 2007, 'Chevrolet', 'Colorado', 79803.06, false);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('19UUA76617A789090', 2007, 'Chevrolet', 'Colorado', 79803.06, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2C3CCAPG4DH181493', 1995, 'Oldsmobile', 'Silhouette', 37028.24, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUHFAFLXAN975583', 1988, 'Ford', 'Mustang', 28221.19, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUHFAFLXAN975580', 2020, 'Ford', 'Mustang', 28221.19, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('KL4CJESBXFB218315', 2003, 'Buick', 'Century', 58464.97, true, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2C3CCABGXFH641010', 1987, 'Mitsubishi', 'Starion', 85598.18, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUVT68E45A556794', 2003, 'Volvo', 'C70', 19174.14, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUAVAFA0AN411332', 1996, 'Suzuki', 'X-90', 57695.24, true, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1GKKRNED7CJ914482', 2007, 'Cadillac', 'XLR', 92245.27, true, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('KMHGH4JF2BU027614', 1995, 'Lexus', 'GS', 39493.85, true, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1FMJU1H53AE775646', 1993, 'Plymouth', 'Acclaim', 90921.98, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('5N1AN0NU5CC031793', 1987, 'Porsche', '944', 64688.38, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2B3CJ7DJ6BH471057', 2007, 'Isuzu', 'i-370', 69884.98, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('4T1BK1EB1EU320474', 2008, 'Ford', 'Edge', 68738.47, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBA4A7C59FD516189', 2000, 'Mazda', 'B-Series', 22484.44, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBA3A9C58FF225341', 2000, 'Kia', 'Sportage', 44357.67, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBSBR93425P295627', 1988, 'Ford', 'Festiva', 55010.3, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('5N1AR2MM6FC350111', 1999, 'Dodge', 'Dakota Club', 82288.68, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBAPH7C54BA598353', 1985, 'Suzuki', 'Cultus', 70315.63, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1GT010CG5CF727500', 1992, 'Mazda', 'MX-3', 44867.04, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUBFAFL1DN568701', 1992, 'Toyota', 'Corolla', 77407.54, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBXPA93416W729213', 2008, 'Chrysler', 'Town & Country', 31236.85, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1G6DC1E38E0836876', 1994, 'Ford', 'F150', 75674.73, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBASN2C58AC188342', 2004, 'Suzuki', 'XL-7', 27878.36, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1N6AA0EC7EN783443', 2012, 'Maserati', 'GranTurismo', 98718.04, false, null, null, null, null);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2G4GN5EC0B9472638', 1992, 'Toyota', 'Supra', 31726.84, false, null, null, null, null);

insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBAYB6C58DC544318', 2006, 'Chevrolet', 'Silverado 2500', 58986.33, false, null, null, 1, 1);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('1N6AF0LX5FN811460', 2007, 'Toyota', 'Camry Hybrid', 48841.44, false, null, null, 3, 3);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('JN8AZ1FY8EW711970', 2008, 'Honda', 'Ridgeline', 83345.99, false, null, null, 4, 3);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('JM3TB2BV6E0518124', 1998, 'Mitsubishi', 'Montero', 59849.64, false, null, null, 4, 8);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2B3CA3CVXAH550758', 2000, 'Ford', 'Escape', 54394.84, false, null, null, 7, 6);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('3N1AB7AP0FY473112', 2008, 'Nissan', 'Maxima', 54744.74, false, null, null, 6, 8);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('JH4CU26629C920165', 2009, 'Suzuki', 'Equator', 18501.03, false, null, null, 8, 5);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WAUEH78E48A240095', 2011, 'Nissan', 'Altima', 89009.47, false, null, null, 3, 5);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('WBANV9C56AC786614', 2004, 'Land Rover', 'Discovery', 99225.62, false, null, null, 7, 6);
insert into cars (vin, car_year, make, model, price, offers, remaining_bal, length_con, user_id, empl_id) values ('2HNYD18661H576933', 2010, 'Honda', 'Accord Crosstour', 66801.21, false, null, null, 6, 1);

create table offers(
	id SERIAL primary key,
	status VARCHAR (10),
	offer numeric (8,2),
	vin VARCHAR references cars(vin),
	user_id INTEGER references users(user_id)
);

insert into offers (status, offer, vin, user_id) values ('Pending', 56464.97, 'KL4CJESBXFB218315', 2);
insert into offers (status, offer, vin, user_id) values ('Pending', 57695.24, 'WAUAVAFA0AN411332', 4);
insert into offers (status, offer, vin, user_id) values ('Pending', 90245.27, '1GKKRNED7CJ914482', 7);
insert into offers (status, offer, vin, user_id) values ('Pending', 39493.85, 'KMHGH4JF2BU027614', 9);

insert into offers (status, offer, vin, user_id) values ('Accepted', 58986.33, 'WBAYB6C58DC544318', 1);
insert into offers (status, offer, vin, user_id) values ('Accepted', 48841.44, '1N6AF0LX5FN811460', 3);
insert into offers (status, offer, vin, user_id) values ('Accepted', 83345.99, 'JN8AZ1FY8EW711970', 4);
insert into offers (status, offer, vin, user_id) values ('Accepted', 59849.64, 'JM3TB2BV6E0518124', 4);
insert into offers (status, offer, vin, user_id) values ('Accepted', 54394.84, '2B3CA3CVXAH550758', 7);
insert into offers (status, offer, vin, user_id) values ('Accepted', 54744.74, '3N1AB7AP0FY473112', 6);
insert into offers (status, offer, vin, user_id) values ('Accepted', 18501.03, 'JH4CU26629C920165', 8);
insert into offers (status, offer, vin, user_id) values ('Accepted', 89009.47, 'WAUEH78E48A240095', 3);
insert into offers (status, offer, vin, user_id) values ('Accepted', 99225.62, 'WBANV9C56AC786614', 7);
insert into offers (status, offer, vin, user_id) values ('Accepted', 66801.21, '2HNYD18661H576933', 6);


select e.empl_id \"e.empl_id\",e.empl_first_name \"e.empl_first_name\", e.empl_last_name \"e.empl_last_name\", e.empl_email \"e.empl_email\", e.empl_pass \"e.empl_pass\", \r\n"
					+ "m.empl_id \"m.empl_id\",m.empl_name \"m.empl_name\", m.empl_salary \"m.empl_salary\", m.empl_role \"m.empl_role\", m.empl_email \"m.empl_email\", m.empl_pass \"m.empl_pass\", m.manager_id \"m.manager_id\"\r\n"
					+ "from employees e\r\n"
					+ "join employees m\r\n"
					+ "on e.manager_id = m.empl_id;

m.user_id "m.user_id",m.car_year "m.car_year", m.make "m.make", m.model "m.model", m.price "m.price"

user_id user_first_name, user_last_name, user_email
select o.id \"o.id\",o.offer \"e.offer\", \r""m.vin \"m.vin\",m.car_year \"m.car_year\", m.make \"m.make\", m.model \"m.model\", m.price \"m.price\", \r" "from offers o\r" "join cars m\r" "on o.vin = m.vin;

select offers.id, offers.offer, offers.vin, cars.car_year, cars.make, cars.model, cars.price, offers.user_id, users.user_first_name, users.user_last_name, users.user_email from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id;

select offers.id, offers.offer, offers.vin, cars.vin, cars.car_year, cars.make, cars.model, cars.price, offers.user_id, users.user_id, users.user_first_name, users.user_last_name, users.user_email from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.vin = 'KL4CJESBXFB218315';

select offers.id, offers.status, offers.offer , offers.vin , cars.car_year , cars.make, cars.model, cars.price, offers.user_id, users.user_first_name, users.user_last_name, users.user_email  from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.user_id = 2;

select o.id \"o.id\",o.offer \"e.offer\", \r""m.vin \"m.vin\",m.car_year \"m.car_year\", m.make \"m.make\", m.model \"m.model\", m.price \"m.price\", \r" "from offers o\r" "join cars m\r" "on o.vin = m.vin;

select cars.vin, cars.car_year, cars.make, cars.model, cars.price, cars.offers, cars.remaining_bal, cars.length_con, cars.user_id, users.user_first_name, users.user_last_name, users.user_email, cars.empl_id, employees.empl_first_name, employees.empl_last_name, employees.empl_email from cars join users on cars.user_id = users.user_id join employees on cars.empl_id = employees.id where cars.vin = '2HNYD18661H576933';
select cars.vin, cars.car_year, cars.make, cars.model, cars.price, cars.offers, cars.remaining_bal, cars.length_con, cars.user_id, cars.empl_id from cars where cars.vin = '1FMJU1H53AE775646';

String sql = "select offers.id \"offers.id\", offers.status \"offers.status\", offers.offer \"offers.offer\", offers.vin \"offers.vin\", cars.car_year \"cars.car_year\", cars.make\"cars.make\", cars.model\"cars.model\", cars.price\"cars.price\", offers.user_id\"offers.user_id\", users.user_first_name\"users.user_first_name\", users.user_last_name\"users.user_last_name\", users.user_email \"users.user_email\" from offers join cars on offers.vin = cars.vin join users on offers.user_id = users.user_id where offers.status = ?";

select * from cars join users on cars.user_id = users.user_id join employees on cars.empl_id = employees.id  where vin = '2HNYD18661H576933';

select * from cars where vin = 'WBAYB6C58DC544318';
select * from offers;
--drop table login;
drop table offers;
drop table cars;
drop table sold_cars;
drop table employees;
drop table users;
create table users(
	user_id SERIAL primary key,
	user_first_name VARCHAR(50) not null,
	user_last_name VARCHAR(50) not null,
	user_email VARCHAR(75) unique,
	user_pass VARCHAR(50) not null
	--user_account NUMERIC (12,0),
	--user_route NUMERIC (10,0)
);
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Petrina', 'Cockhill', 'pcockhill0@economist.com', 'v5h0I77iOJ');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Shalom', 'Ca', 'sca1@buzzfeed.com', 'fgGK40Di');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Biddie', 'Casterton', 'bcasterton2@army.mil', 'BExzOP');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Kimberlyn', 'Bernardelli', 'kbernardelli3@yellowpages.com', 'GOp1QZR5');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Hillary', 'Norway', 'hnorway4@twitter.com', 'Gu5d9W7ot');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Durward', 'McSkeagan', 'dmcskeagan5@vimeo.com', 'QXKJGzyhO');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Randie', 'Patrone', 'rpatrone6@va.gov', 'nho2Alr');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Hillary', 'McGourty', 'hmcgourty7@delicious.com', 'JnOXffl4QF');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Sofie', 'McMeekin', 'smcmeekin8@dedecms.com', '9wygEDO2');
insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Willem', 'Fifield', 'wfifield9@seattletimes.com', 'f2FWCWC');


create table sold_cars(
	car_id SERIAL primary key,
	sold_vin VARCHAR(20) references cars(vin),
	remaining_bal NUMERIC (8,2),
	length_con INTEGER,
	dl_num NUMERIC (10,0) references users(dl_num),
	empl_id INTEGER references employees(id)
);

