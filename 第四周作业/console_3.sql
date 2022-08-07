-- 创建数据库
create database if not exists lanshan;

-- 创建表
drop table if exists employees;
create table if not exists employees(
    emp_no int,
    birth_data timestamp,
    first_name varchar(20),
    last_name varchar(20),
    gender char(1)
)comment '员工表';

-- 添加数据
insert into employees values (10001,'1953-09-02','Georgi','Facello','M'),
                             (10002,'1964-06-02','Bezalel','Simmel','F'),
                             (10003,'1959-12-03','Parto','Bamford','M'),
                             (10004,'1954-05-01','Chris tian','Koblick','M');

-- 查找employees里最晚入职员工的所有信息
select * from employees order by emp_no desc limit 1;


-- 创建表并添加数据
drop table if exists  film ;
drop table if exists  category  ;
drop table if exists  film_category  ;
CREATE TABLE IF NOT EXISTS film (
  film_id smallint(5)  NOT NULL DEFAULT '0',
  title varchar(255) NOT NULL,
  description text,
  PRIMARY KEY (film_id));
CREATE TABLE category  (
   category_id  tinyint(3)  NOT NULL ,
   name  varchar(25) NOT NULL, `last_update` timestamp,
  PRIMARY KEY ( category_id ));
CREATE TABLE film_category  (
   film_id  smallint(5)  NOT NULL,
   category_id  tinyint(3)  NOT NULL, `last_update` timestamp);
INSERT INTO film VALUES(1,'ACADEMY DINOSAUR','A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies');
INSERT INTO film VALUES(2,'ACE GOLDFINGER','A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China');
INSERT INTO film VALUES(3,'ADAPTATION HOLES','A Astounding Reflection of a Lumberjack And a Car who must Sink a Lumberjack in A Baloon Factory');

INSERT INTO category VALUES(1,'Action','2006-02-14 20:46:27');
INSERT INTO category VALUES(2,'Animation','2006-02-14 20:46:27');
INSERT INTO category VALUES(3,'Children','2006-02-14 20:46:27');
INSERT INTO category VALUES(4,'Classics','2006-02-14 20:46:27');
INSERT INTO category VALUES(5,'Comedy','2006-02-14 20:46:27');
INSERT INTO category VALUES(6,'Documentary','2006-02-14 20:46:27');
INSERT INTO category VALUES(7,'Drama','2006-02-14 20:46:27');
INSERT INTO category VALUES(8,'Family','2006-02-14 20:46:27');
INSERT INTO category VALUES(9,'Foreign','2006-02-14 20:46:27');
INSERT INTO category VALUES(10,'Games','2006-02-14 20:46:27');
INSERT INTO category VALUES(11,'Horror','2006-02-14 20:46:27');

INSERT INTO film_category VALUES(1,6,'2006-02-14 21:07:09');
INSERT INTO film_category VALUES(2,11,'2006-02-14 21:07:09');

-- 使用join查询方式找出没有分类的电影id以及其电影名称
select distinct film.film_id,film.title from film join film_category on film.film_id not in (select film_category.film_id from film_category);


-- 创建表并添加数据
drop table if exists employees;
CREATE TABLE `employees` (
`emp_no` int(11) NOT NULL,
`birth_date` date NOT NULL,
`first_name` varchar(14) NOT NULL,
`last_name` varchar(16) NOT NULL,
`gender` char(1) NOT NULL,
`hire_date` date NOT NULL,
PRIMARY KEY (`emp_no`));

INSERT INTO employees VALUES(10001,'1953-09-02','Georgi','Facello','M','1986-06-26');
INSERT INTO employees VALUES(10002,'1964-06-02','Bezalel','Simmel','F','1985-11-21');
INSERT INTO employees VALUES(10003,'1959-12-03','Parto','Bamford','M','1986-08-28');
INSERT INTO employees VALUES(10004,'1954-05-01','Chirstian','Koblick','M','1986-12-01');
INSERT INTO employees VALUES(10005,'1955-01-21','Kyoichi','Maliniak','M','1989-09-12');
INSERT INTO employees VALUES(10006,'1953-04-20','Anneke','Preusig','F','1989-06-02');
INSERT INTO employees VALUES(10007,'1957-05-23','Tzvetan','Zielinski','F','1989-02-10');
INSERT INTO employees VALUES(10008,'1958-02-19','Saniya','Kalloufi','M','1994-09-15');
INSERT INTO employees VALUES(10009,'1952-04-19','Sumant','Peac','F','1985-02-18');
INSERT INTO employees VALUES(10010,'1963-06-01','Duangkaew','Piveteau','F','1989-08-24');
INSERT INTO employees VALUES(10011,'1953-11-07','Mary','Sluis','F','1990-01-22');


-- 分页查询employees表，每5行一页，返回第2页的数据
select * from employees limit 5,5;



-- 创建表并添加数据
CREATE TABLE actor  (
   actor_id  smallint(5)  NOT NULL PRIMARY KEY,
   first_name  varchar(45) NOT NULL,
   last_name  varchar(45) NOT NULL,
   last_update  datetime NOT NULL);

-- 查看索引
show index from actor;

-- 对first_name创建唯一索引uniq_idx_firstname，对last_name创建普通索引idx_lastname
create unique index uniq_idx_firstname on actor(first_name);
create index idx_lastname on actor(last_name);




-- 创建表
drop table if exists passing_number;
create table if not exists passing_number(
    id tinyint primary key auto_increment,
    number tinyint
);

-- 插入数据
insert into passing_number(number) values (4),(3),(3),(2),(5),(4);

-- 排序
select * ,
dense_rank() over (order by number desc) t_rank from passing_number;