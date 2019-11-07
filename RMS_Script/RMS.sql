create table format(
event_type varchar(50) unique,
reinburstment decimal(4, 2)
)

insert into format values('University Courses', 0.8), ('Seminars', 0.6), 
('Certification Preparation Classes', 0.75), ('Certification', 1.00), 
('Technical Training', 0.9), ('Other', 0.30)

truncate format
drop table format
select * from format


create table Employees(
emp_id integer primary key,
fName varchar(30),
lName varchar(30),
deptName varchar(50),
user varchar(20),
pw varchar(20),
reimbursement decimal(6, 2) default 1000.00

)

create table Supervisor(
emp_id integer primary key,
fName varchar(30),
lName varchar(30),
deptName varchar(50),
user varchar(20),
pw varchar(20),
isDeptHead boolean
    )
    
create table Benefits_Coordinator(
emp_id integer primary key,
fName varchar(30),
lName varchar(30),
deptName varchar(50),
user varchar(20),
pw varchar(20)
   )
    
create table form(
	form_id integer primary key,
	urgent boolean,
    event_type text,
    first_name text,
    last_name text,
    department text,
    start_date date,
    end_date date,
    start_time time,
    end_time time,
    grade_format text,
    grade_cutoff text,
    cost decimal(6, 2),
    reimbursement decimal(6, 2),
    presentation boolean,
    s_accept integer,
    dh_accept integer,
    bc_accept integer
)

select * from form
drop table form
insert into form values(1, true, 'terp', 'first', 'last', 'department', '7-12-2012', '12-12-2012', '7:30am', '9:30pm', 'gradeF', 'gradeC', 12.50, 1000.00, true, 1, 1, 1)