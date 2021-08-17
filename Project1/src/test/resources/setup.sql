drop table if exists reimbursement;
drop table if exists users;
drop table if exists reimbursementstatus;
drop table if exists roles;
drop table if exists reimbursementtype;

create table if not exists reimbursementstatus(

	stat_id SERIAL not null primary key,
	status VARCHAR(10) not null

);

create table if not exists reimbursementtype(

	type_id SERIAL not null primary key,
	type VARCHAR(10) not null

);

create table if not exists roles(

	role_id SERIAL not null primary key,
	user_role VARCHAR(10) not null

);


create table if not exists users(

	user_id SERIAL primary key not null,
	username VARCHAR(50) unique not null,
	password VARCHAR(50) not null,
	first_name VARCHAR(100) not null,
	last_name VARCHAR(100) not null,
	email VARCHAR(150) unique not null,
	role_id INTEGER not null references ers_user_roles(ers_user_role_id)

);

create table if not exists reimbursement(

	reimb_id SERIAL primary key not null,
	reimb_amount FLOAT not null,
	reimb_sub TIMESTAMP not null,
	reimb_res TIMESTAMP,
	reimb_des VARCHAR(250),
	receipt BYTEA,
	author INTEGER not null references users(user_id),
	resolver INTEGER references users(user_id),
	stat_id INTEGER not null references reimbursementstatus(stat_id),
	type_id INTEGER not null references reimbursementtype(type_id)

);


insert into reimbursementtype (type) values ('LODGING');
insert into reimbursementtype (type) values ('TRAVEL');
insert into reimbursementtype (type) values ('FOOD');
insert into reimbursementtype (type) values ('OTHER');

insert into roles (user_role) values ('Manager');
insert into roles (user_role) values ('Employee');

insert into reimbursementstatus(status) values ('Pending');
insert into reimbursementstatus(status) values ('Accepted');
insert into reimbursementstatus(status) values ('Denied');

insert into users (username, password, first_name, last_name, email, role_id)
values ('user', 'pass', 'first', 'last', 'user.com', 1);
insert into users (username, password, first_name, last_name, email, role_id)
values ('emp', 'pass', 'first', 'last', 'emp.com', 2);

insert into reimbursement (reimb_amount, reimb_sub, reimb_des, author, stat_id, type_id)
values (100, current_timestamp, 'Paid for Lodging', 1, 1, 1);
insert into reimbursement (reimb_amount, reimb_sub, author, stat_id, type_id)
values (150, current_timestamp, 'Paid for Lodging', 2, 1, 1);