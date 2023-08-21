
create table account(
id int not null auto_increment,
name varchar(50) not null,
amount double not null,
primary key(id)
);
insert into account values(null,'Joseph',5000.250);
insert into account values(null,'Shaun',5000.500);
insert into account values(null,'Kang',15000.150);