--Create event_type reference table
--drop table event_type cascade;
create table event_type(
	event_type varchar(50) primary key,
	reinburstment decimal(4, 2),
	format_id int default 2
);

--Create grade_format reference table
--drop table grade_format cascade;
create table grade_format(
	format_id int primary key,
	format_desc text
);

--Populate grade_format with reference data
--delete from grade_format;
insert into grade_format values(0, 'letter');
insert into grade_format values(1,'percent');
insert into grade_format values(2,'pass/fail');

--Populate event_type table with reference data
--delete from event_type;
insert into event_type values('University Courses', 0.8, 0), ('Seminars', 0.6, 2), 
	('Certification Preparation Classes', 0.75, 1), ('Certification', 1.00, 1), 
	('Technical Training', 0.9, 2), ('Other', 0.30, default);

alter table event_type
add constraint fk_event_type_grade_format
foreign key(format_id) references grade_format(format_id);

--alter table event_type
--drop constraint fk_event_type_grade_format;

--Create grade_letter reference table
--drop table grade_letter;
create table grade_letter(
	grade_value char primary key,
	grade_result boolean
);

--Populate with reference data
--delete from grade_letter;
insert into grade_letter values('A', true), ('B', true), ('C', true), ('D', false), ('F', false), ('I', false), ('W', false);

--Create grade_percent reference table
--drop table grade_percent;
create table grade_percent(
	grade_value int primary key,
	grade_result boolean
);

--Populate with reference data
--delete from grade_percent;
insert into grade_percent values(100, true), (99, true), (98, true), (97, true), (96, true), (95, true), (94, true), (93, true), (92, true), (91, true),
								(90, true), (89, true), (88, true), (87, true), (86, true), (85, true), (84, true), (83, true), (82, true), (81, true),
								(80, true), (79, true), (78, true), (77, true), (76, true), (75, true), (74, true), (73, true), (72, true), (71, true),
								(70, true), (69, true), (68, true), (67, true), (66, true), (65, true), (64, false), (63, false), (62, false), (61, false),
								(60, false), (59, false), (58, false), (57, false), (56, false), (55, false), (54, false), (53, false), (52, false), (51, false),
								(50, false), (49, false), (48, false), (47, false), (46, false), (45, false), (44, false), (43, false), (42, false), (41, false),
								(40, false), (39, false), (38, false), (37, false), (36, false), (35, false), (34, false), (33, false), (32, false), (31, false),
								(30, false), (29, false), (28, false), (27, false), (26, false), (25, false), (24, false), (23, false), (22, false), (21, false),
								(20, false), (19, false), (18, false), (17, false), (16, false), (15, false), (14, false), (13, false), (12, false), (11, false),
								(10, false), (9, false), (8, false), (7, false), (6, false), (5, false), (4, false), (3, false), (2, false), (1, false);
								

--Create grade_pass_fail reference table
--drop table grade_pass_fail;
create table grade_pass_fail(
	grade_value text primary key,
	grade_result boolean
);

--Populate with reference data
--delete from grade_pass_fail;
insert into grade_pass_fail values('pass', true), ('fail', false);

--Create sequence to increment emp_id
create sequence if not exists emp_id_inc
as int
increment by 1
minvalue 0
start with 0;


--Create employee table
drop table employee;
create table employee(
	emp_id integer primary key default nextval('emp_id_inc'),
	fname text not null,
	lname text not null,
 	deptname text not null,
	username varchar(20) not null unique,
	pw varchar(20) not null,
	reimbursement decimal(6, 2) not null default 1000.00
);

alter sequence emp_id_inc owned by employee.emp_id;

--Create some employees
--delete from employee;
insert into employee values(0, 'James', 'Todd', 'Development', 'jtodd3', 'qwe', default);
insert into employee values(1, 'Ryan', 'Crnich', 'Develoment', 'rchrinch', '123', default);
insert into employee values(2, 'Lucy', 'Stapleton', 'Development', 'lStapleton', 'asd', default);

--Create supervisor table
--drop table supervisor;
create table supervisor(
	sup_id integer primary key,
	fname text not null,
	lname text not null,
 	deptname text not null,
	username varchar(20) not null unique,
	pw varchar(20) not null,
	isdepthead boolean
);

--Create a few supervisors and a department head or two
--delete from supervisor;
insert into supervisor values(0, 'John', 'Tallow', 'Production', 'JTall', 'JT123', true);
insert into supervisor values(1, 'Lea', 'Sharpe', 'Development', 'SLea', 'Sea', true);
insert into supervisor values(2, 'Tom', 'Frank', 'Sales', 'ToFran', 'TF10', false);
insert into supervisor values(3, 'Candi', 'Kane', 'Sales', 'CandiKane', 'Peppermint1', true);

--Create benefits_coordinator table
--drop table benefits_coordinator;
create table benefits_coordinator(
	bc_id integer primary key,
	fname text not null,
	lname text not null,
	username varchar(20) not null unique,
	pw varchar(20) not null
);
    
--Create Benefits Coordinator
--delete from benefits_coordinator;
insert into benefits_coordinator values(0,'Hans', 'Zimmer', 'H_Zim', '123');

--Create sequence for form id
--alter sequence form_id_inc owned by none;
--drop sequence form_id_inc cascade;
create sequence if not exists form_id_inc
as int
increment by 1
minvalue 0
start with 0;

--Create form table
--drop table form cascade;
create table form(
	form_id int primary key default nextval('form_id_inc'),
	urgent boolean,
    event_type text not null,
    first_name text not null,
    last_name text not null,
    department text not null,
    email text not null,
    loc text not null,
    justification text not null,
    start_date date not null,
    end_date date not null,
    start_time time not null,
    end_time time not null,
    grade_format text not null,
    grade_cutoff text not null,
    costs decimal(6, 2) not null,
    reimbursement decimal(6, 2) not null,
    presentation boolean,
    filename text,
    s_accept integer default 0,
    dh_accept integer default 0,
    bc_accept integer default 0,
    fail_desc text
);

alter sequence form_id_inc owned by form.form_id;

--create table to store files
--drop table file cascade;
create table file(
	filename text primary key,
	file bytea
);

alter table form
add constraint fk_form_file
foreign key(filename) references file(filename);

--select * from form
--insert into form values(1, true, 'terp', 'first', 'last', 'department', '7-12-2012', 
--						  '12-12-2012', '7:30am', '9:30pm', 'gradeF', 'gradeC', 12.50,
--						  1000.00, true, 1, 1, 1
--						  );