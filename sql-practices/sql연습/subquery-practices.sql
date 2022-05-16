-- subquery
-- 쿼리 안에 쿼리가 들어감

-- 1) select 절
-- 2) from 절 
select now() as a, sysdate() as b, 3 + 1 as c;
select s.a, s.b, s.c
  from (select now() as a, sysdate() as b, 3 + 1 as c) s;
  
-- 3) where 절
-- 예제: 현재, Fai Bale이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름을 출력해보세요.
select a.dept_no
  from dept_emp a, employees b
where a.emp_no = b.emp_no
  and a.to_date = '9999-01-01'
  and concat(b.first_name, ' ' ,b.last_name) = 'Fai Bale';

select b.emp_no, b.first_name
from dept_emp a, employees b
where a.emp_no = b.emp_no
  and a.to_date = '9999-01-01'
  and a.dept_no = 'd004';
  
-- solution
SELECT 
    b.emp_no, b.first_name
FROM
    dept_emp a,
    employees b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND a.dept_no = ( SELECT 
								a.dept_no
							FROM
								dept_emp a,
								employees b
							WHERE
								a.emp_no = b.emp_no
							AND a.to_date = '9999-01-01'
							AND CONCAT(b.first_name, ' ', b.last_name) = 'Fai Bale');
  
  
  
-- 3-1) 단일행 연산자: =, >, <, <=, >=, <>, != 
-- 실습문제: 현재 전체사원의 평균 연봉보다 적은 급여를 받는 사원의  이름, 급여를 나타내세요.
SELECT 
    CONCAT(b.first_name, b.last_name) AS name, a.salary
FROM
    salaries a,
    employees b
WHERE
    a.emp_no = b.emp_no
    AND a.to_date = '9999-01-01'
    AND salary < (SELECT AVG(salary) FROM salaries WHERE to_date = '9999-01-01')
	AND a.salary;

-- 실습문제: 현재 가장적은 평균 급여의 직책과 해당 직책의 평균 급여
SELECT Min(s.salary)
FROM titles a,
		(SELECT 
			AVG(a.salary) salary, b.title
		FROM
			salaries a, titles b
		WHERE
			a.emp_no = b.emp_no
		AND a.to_date = '9999-01-01'
		AND	b.to_date = '9999-01-01'
		GROUP BY b.title) s
WHERE a.title = s.title
AND a.to_date = '9999-01-01';

SELECT a.title, avg(salary) salary
 FROM titles a, salaries b
WHERE a.emp_no = b.emp_no
and a.to_date = '9999-01-01'
and b.to_date = '9999-01-01'
group by a.title
having avg(salary) = (SELECT Min(s.salary)
						FROM titles a,
							(SELECT 
								AVG(a.salary) salary, b.title
							FROM
								salaries a, titles b
							WHERE
								a.emp_no = b.emp_no
							AND a.to_date = '9999-01-01'
							AND	b.to_date = '9999-01-01'
							GROUP BY b.title) s
					WHERE a.title = s.title
					AND a.to_date = '9999-01-01');

-- 3-2) 복수행 연산자: IN, NOT IN, ANY, ALL
-- ANY 사용법
-- 1. =any : in
-- 2. >any , >=any: 최소값
-- 3. <=any, <any : 최대값
-- 4. <>any : not in

-- ALL 사용법
-- 1. =all : x
-- 2. >all, >=all: 최대값
-- 3. <=all, <all : 최소값
-- 4. <>all 


-- 실습문제3: 현재 급여가 50000이상인 직원 이름 출력
-- subquery 사용
SELECT 
    CONCAT(first_name, last_name) AS name
FROM
    employees
WHERE
    emp_no = ANY (SELECT 
            emp_no
        FROM
            salaries
        WHERE
            salary >= 50000
                AND to_date = '9999-01-01');
-- join 사용
SELECT 
    CONCAT(a.first_name, a.last_name) AS name
FROM
    employees a,
    salaries b
WHERE
    a.emp_no = b.emp_no
        AND b.salary >= 50000
        AND b.to_date = '9999-01-01';

-- 실습문제4: 현재 각 부서별로최고 월급을 받는 직원의 이름과 월급을 출력하시오.
SELECT 
    CONCAT(a.first_name, a.last_name) AS name,
    s.salary,
    s.dept_name
FROM
    employees a,
    (SELECT 
        MAX(salary) AS salary, MAX(a.emp_no) AS emp_no, c.dept_name
		FROM
			salaries a, dept_emp b, departments c
		WHERE
			a.emp_no = b.emp_no
				AND b.dept_no = c.dept_no
				AND a.to_date = '9999-01-01'
				AND b.to_date = '9999-01-01'
		GROUP BY c.dept_name) s
WHERE
    a.emp_no = s.emp_no;


/*************************************************************************************/
-- sol1) where subquery : in(=any)
SELECT 
    b.first_name, d.dept_name                                                                                                                                                                                                                                 
FROM
    dept_emp a,
    employees b,
    salaries c,
    departments d
WHERE
    a.emp_no = b.emp_no
        AND b.emp_no = c.emp_no
        AND d.dept_no = a.dept_no
        AND a.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND (a.dept_no , c.salary) IN (SELECT 
            a.dept_no, MAX(b.salary)
        FROM
            dept_emp a,
            salaries b
        WHERE
            a.emp_no = b.emp_no
                AND a.to_date = '9999-01-01'
                AND b.to_date = '9999-01-01'
        GROUP BY a.dept_no);


------------------------------------------------------------











