create table employees(
	id SERIAL primary key,
	empl_first_name VARCHAR(50) not null,
	empl_last_name VARCHAR(50) not null,
	--empl_role VARCHAR(20),
	--empl_salary NUMERIC(8,2),
	empl_email VARCHAR(75) unique,
	empl_pass VARCHAR(50) not null
);

insert into employees (empl_first_name, empl_last_name, empl_email, empl_pass) values ('first', 'last', 'mm.com', 'password');

create table cars(
	vin VARCHAR(20) primary key,
	car_year NUMERIC(4,0) not null,
	make VARCHAR(20) not null,
	model VARCHAR(20) not null,
	price NUMERIC(8,2) not null,
//	offers BOOLEAN not null,
//	remaining_bal NUMERIC (8,2),
//	length_con INTEGER,
//	user_id INTEGER references users(user_id),
//	empl_id INTEGER references employees(id)
);

insert into cars (vin, car_year, make, model, price) values ('XXXXXXXXXXXXXXXXX', 2007, 'Fake', 'Fake', 1.00);
insert into cars (vin, car_year, make, model, price) values ('XXXXXXXXXXXXXXXXY', 2007, 'Fake', 'Fake', 1.00);


create table offers(
	id SERIAL primary key,
	status VARCHAR (10),
	offer numeric (8,2),
	vin VARCHAR references cars(vin),
	user_id INTEGER references users(user_id)
);

create table users(
	user_id SERIAL primary key,
	user_first_name VARCHAR(50) not null,
	user_last_name VARCHAR(50) not null,
	user_email VARCHAR(75) unique,
	user_pass VARCHAR(50) not null
	--user_account NUMERIC (12,0),
	--user_route NUMERIC (10,0)
);

insert into users (user_first_name, user_last_name, user_email, user_pass) values ('Bob', 'Forapples', 'bf.com', 'password');

