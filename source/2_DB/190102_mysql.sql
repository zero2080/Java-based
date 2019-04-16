show databases;
create database kimdb;
use kimdb; -- kimdb database 공간으로 들어감
select database();-- 내가 있는 database공간이 어딘지 확인
-- major : 학과번호, 학과이름
drop table if exists major;
create table major(
	major_code int primary key auto_increment,
    major_name varchar(30));
alter database kimdb charset=utf8;
alter table major charset = utf8;
ALTER TABLE major CONVERT TO CHARACTER SET utf8;
insert into major (major_name) values ('조리');
insert into major (major_name) values ('컴공');
select * from major;
-- student : 학번, 이름, 학과번호
drop table if exists student;
create table student(
	stu_id int primary key,
    name varchar(15) not null,
    major_code int,
    foreign key(major_code) references major(major_code)); 
insert into student values (1000, '홍', 3);
select * from student;
select stu_id, name, major_name from major m, student s
	where m.major_code=s.major_code;
-- JDBC(java Database connect) 프로그래밍 준비
drop table if exists division;
create table division(
	dno int primary key, -- 부서번호
    dname varchar(30),   -- 부서명
    phone varchar(30),   -- 부서전화
    position varchar(30));
show tables; -- select * from tab;
use kimdb;
insert into division values (10, 'finance', '999-9999','노원');
insert into division values (20, 'research', '888-8888','동작');
insert into division values (30, 'sales', '777-7777','종로');
insert into division values (40, 'marketing','555-5555','강남');
select * from division;
drop table if exists personal;
create table personal(
	pno int primary key, -- 사번
    pname varchar(30) not null,   -- 사원명
    job   varchar(30) not null,   -- 직책
    manager   int,  -- 직속상사의 사번
    startdate date, -- 입사일
    pay       int,  -- 급여
    bonus     int,  -- 상여금
    dno       int,
    foreign key(dno) references division(dno));
select * from personal;
desc personal;

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select * from personal;
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;

-- 2. 급여가 2000~5000 사이
select * from personal where pay between 2000 and 5000;
select * from personal 
	where pay>=2000 and pay<=5000;

-- 3. 부서코드가 10또는 20인 사원의 사번, 이름, 부서코드
select pno, pname, dno from personal
	where dno in (10,20);
select pno, pname, dno from personal 
	where dno=10 || dno=20;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal
	where bonus is null order by pay desc;

-- 5. 사번, 이름, 부서코드, 급여 부서코드 순 정열 같으면 큰 순
select pno, pname, dno, pay from personal 
	order by dno, pay desc;

-- 6. 사번, 이름, 부서명
select pno, pname, dname from division d, personal p
	where d.dno=p.dno;
    
-- 7. 사번, 이름, 관리자명
select w.pno, w.pname, m.pname from personal w, personal m
	where w.manager=m.pno;

-- 8. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';

-- 9. 사번, 이름, 급여, 부서명, 관리자명
select w.pno, w.pname, w.pay, dname, m.pname
	from personal w, division d, personal m
    where w.dno=d.dno and w.manager=m.pno;
    
-- 10. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay) from personal group by dno;

-- 11. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*) 
	from personal p, division d
	where p.dno=d.dno
    group by dname;

-- 12. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*) from personal
	group by dno having count(*)>=4;

-- 13. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay from personal
	where pay = (select max(pay) from personal);

-- 14. 회사 평균보다 급여를 많이 받는 사람 이름, 급여
select pname, pay from personal
	where pay>(select avg(pay) from personal);

-- 15. 14번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, dname from personal p, division d
	where p.dno=d.dno &&
		pay>(select avg(pay) from personal)
	order by dname, pay desc;

-- 16. 자기부서평균보다 급여를 많이 받는 사람 이름, 급여
select pname, pay from personal my
	where pay>
		(select avg(pay) from personal where dno=my.dno);

select pname, pay
	from personal p, 
	(select dno, avg(pay) avgp from personal group by dno) X
	where p.dno=x.dno and p.pay>x.avgp;

-- 17. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname from personal p, division d
	where p.dno=d.dno 
		and startdate=(select min(startdate) from persnoal);
        
-- Oracle과 다른 점
-- (1) 단일행 함수
select concat(pname, '(', job, ')') from personal;
	-- pname || '(' || job || ')'
select round(35.678, 1);
select reverse('Hello'); -- olleH
select year(startdate) from personal;
select month(startdate) from personal;
select monthname(startdate) from personal;
select dayname(startdate) from personal; -- Tuesday
select weekday(startdate) from personal; -- 월0, 화1, ...
select dayofyear(sysdate());
select sysdate(), now() ; -- 현재 날짜과 현재 시간
select current_date(), curdate();    -- 현재 날짜
select current_time(), curtime();    -- 현재 시간
select date_format(now(), '%y년 %m월 %d일');
	-- y:19 / Y:2019 / m:01 / M:January / d:02 / e:2
select pname, pay, bonus, pay*12+ifnull(bonus,0) -- NVL()
	from personal;
select pname, pay, if(pay>3000, 'GOOD', 'BAD') output
	from personal;
-- (2) Top-N 구문
select pname, pay from personal 
	order by pay desc limit 0, 3; -- 1등부터 3등까지
select pname, pay from personal
	order by pay desc limit 3, 3; -- ★★★
	-- Top-4 부터 6까지
-- (3) outer join
select * from division; -- 10, 20, 30, 40번 부서
select * from personal; -- 10, 20, 30번 부서
select pno, pname, d.dno, dname 
	from division d left outer join personal p
    on d.dno=p.dno;
select w.pname, ifnull(m.pname, '-')
	from personal w left outer join personal m
    on w.manager=m.pno;
    -- 사원명, 직속상사명(직속상사가 없으면 '-')












