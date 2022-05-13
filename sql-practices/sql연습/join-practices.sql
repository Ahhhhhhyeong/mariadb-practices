/*
inner join
 ANSI/ISO SQL 1999 JION' 
 natural join (x)
 join ~ using  (x)
 join ~ on(o)

outer join
+ ANSI/ISO SQL1999 JOIN 
 left join ~ on
 right join ~ on
 full join ~ on
*/

-- inner join

-- 예제1: 현재 근무하고 있는 직원의 이름과 직책을 출력하세요.
select e.first_name, t.title
 from employees as e, titles as t
where e.emp_no = t.emp_no			-- join 조건
  and t.to_date = '9999-01-01';
 


-- 예제2: 현재 직원의 이름과 직책을 출력하되, 여성 엔지니어(Engineer)만 출력
select a.first_name, b.title
	from employees as a, titles as b
 where a.emp_no = b.emp_no
	and a.gender = 'f'
	and b.title = 'engineer';


--
-- ANSI/ISO SQL1999 JOIN 표준문법
--
-- 1) natural join
-- 두 테이블에 이름이 같은 공통 컬럼이 있으면 별다른 조인 조건을 명시하지 않아도
-- 암묵적으로 조인을 할 수 있다.
select a.emp_no, a.first_name, b.title
	from employees as a 
natural join titles as b
 where b.to_date = '9999-01-01';
 

-- 2) join ~ using
select count(*) 
	from salaries a join titles b 
using(emp_no)
	where a.to_date = '9999-01-01'
	  and b.to_date = '9999-01-01';


-- 3) join ~ on
select b.title, avg(a.salary) avg
	from salaries a join titles b 
	  on a.emp_no = b.emp_no
	where a.to_date = '9999-01-01'
	  and b.to_date = '9999-01-01'
	group by b.title
    order by avg desc;
