create table tickets (
	ticket_id serial primary key,
	user_id int,
	amount NUMERIC(100,2),
	description varchar(1000),
	date_sub date,
	status bool,
	date_proc date,
	approved bool
);

create table users (
	user_id serial,
	email varchar(200),
	first_name varchar(200),
	last_name varchar(200),
	"password" varchar(200),
	pos_role varchar(200),
	ticket_id int,
	constraint pk_user primary key (user_id),
	constraint fk_user_ticket foreign key (ticket_id) references tickets (ticket_id)
);