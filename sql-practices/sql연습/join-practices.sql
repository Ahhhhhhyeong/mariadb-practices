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
SELECT 
    a.emp_no, a.first_name, b.title
FROM
    employees AS a
        NATURAL JOIN
    titles AS b
WHERE
    b.to_date = '9999-01-01';
 

-- 2) join ~ using
SELECT 
    COUNT(*)
FROM
    salaries a
        JOIN
    titles b USING (emp_no)
WHERE
    a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01';


-- 3) join ~ on
SELECT 
    b.title, AVG(a.salary) avg
FROM
    salaries a
        JOIN
    titles b ON a.emp_no = b.emp_no
WHERE
    a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY b.title
ORDER BY avg DESC;



-- 실습문제 1: 현재 회사 상황을 반영한 직원별 근무부서를 사번, 직원 전체 이름, 근무부서 형태로 출력해 보세요
SELECT 
    a.emp_no, a.first_name, c.dept_name
FROM
    employees a,
    dept_emp b,
    departments c
WHERE
    a.emp_no = b.emp_no
        AND b.dept_no = c.dept_no
        AND b.to_date = '9999-01-01';

-- 실습문제 2: 현재 회사에서 지급되고 있는 급여체계를 반영한 결과를 출력
SELECT 
    a.emp_no, a.first_name, b.salary
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.to_date = '9999-01-01'
ORDER BY b.salary DESC;

-- 실습문제 3: 현재 직책별로 평균 연봉과 인원수롤 구하되 직책별로 인원이 100명 이상인 직책만 출력하세요.
SELECT 
    a.title, b.salary
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY a.title
HAVING COUNT(*);
  
  
  
-- 실습문제4: 현재 부서별로 현재 직책인 Engineer인 직원들의 대해서만 평균 급여 구하기
SELECT 
    d.dept_name, AVG(c.salary) AS salary
FROM
    dept_emp a,
    titles b,
    salaries c,
    departments d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND a.dept_no = d.dept_no
        AND b.title = 'Engineer'
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY d.dept_name;


-- outer 조인
