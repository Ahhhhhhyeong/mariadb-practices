-- select 연습
select 
	dept_no, 
    dept_name 
 from departments 
order by dept_no 
 limit 0,3;

select
	dept_no, 
	dept_name
 from departments;

-- alias : 칼럼 이름을 바꿈
-- 예제1: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select 
	first_name '이름',  -- as 생략 가능
	gender as '성별',
    hire_date as '입사일'
 from employees;
 
 -- 예제2: employees 테이블에서 직원의 이름(풀네임), 성별, 입사일 출력
 select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees;
 
 
 -- distinct
 -- 예제: titles 테이블에서 모든 직급의 이름 출력
 select distinct title
 from titles;
 
 
 -- where절 #1
 -- 예제1: 1991년 이전에 입사한 직원 이름, 성별, 입사일
  select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where hire_date < '1991-01-01';
 
 -- where절 #2 : 논리 연산자
 -- 예제2: 1989년 이전에 입사한 여자직원 이름, 성별, 입사일
  select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where hire_date < '1989-01-01'
   and gender = 'F';
   
   
 -- where 절 #3: in 연산자
 -- 예제: dept_emp 테이블에서 부서번호가 d005 이거나 d009에 속한 사원의 사번, 부서번호를 출력
 select
	emp_no,
    dept_no
 from dept_emp
where dept_no = 'd005'
 or dept_no = 'd009';
 
select
	emp_no,
    dept_no
 from dept_emp
where dept_no in ('d005','d009');


-- where 절 #4: like 검색
-- 예제: 1989년에 입사한 직원 이름, 성별, 입사일
select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where hire_date <= '1989-12-31'
   and hire_date >= '1989-01-01';
   
 select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where hire_date like '1989%';

 select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where hire_date between '1989-01-01' and '1989-12-31';


/*
limit : mariaDB에만 사용
top-k 검색으로 k개 나타냄
*/

-- order by 절 
-- 예제1: 남자 직원의 이름, 성별, 입사일을 입사일 순서(선임순)으로 출력
  select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where gender = 'M'
order by hire_date;


-- 예제2: 직원들의 사번, 월급을 사번과 월급순으로
select 
	 emp_no
	,salary
from salaries
order by emp_no asc, salary desc;



