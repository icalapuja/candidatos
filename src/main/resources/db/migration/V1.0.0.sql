create table candidates(
	id int auto_increment primary key,
	name varchar(100) not null,
	email varchar(100) not null,
	gender char(1),
	salary_expected double
);
