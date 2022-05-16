-- 서브쿼리(SUBQUERY)(혼합) SQL 문제입니다.
-- 문제1. 
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까? 
SELECT 
    COUNT(b.emp_no) AS name
FROM
    salaries a,
    employees b
WHERE
    a.emp_no = b.emp_no
    AND a.to_date = '9999-01-01'
    AND salary > (SELECT AVG(salary) FROM salaries WHERE to_date = '9999-01-01')
	AND a.salary;
 

-- 문제2.  
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다.
SELECT 
    a.emp_no,
    CONCAT(a.first_name, a.last_name) AS name,
    c.dept_name,
    d.salary
FROM
    employees a,
    dept_emp b,
    departments c,
    salaries d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = d.emp_no
        AND b.dept_no = c.dept_no
        AND (d.salary , b.dept_no) IN (SELECT 
            MAX(salary) AS salary, b.dept_no
        FROM
            salaries a,
            dept_emp b
        WHERE
            a.emp_no = b.emp_no
                AND a.to_date = '9999-01-01'
                AND b.to_date = '9999-01-01'
        GROUP BY dept_no)
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
ORDER BY d.salary DESC;
	  

-- 문제3. 
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요   
select a.emp_no, concat(first_name, last_name) name, d.salary
 from employees a, dept_emp b, departments c, salaries d,(select AVG(salary) as salary, b.dept_no
												from salaries a, dept_emp b
												where a.emp_no = b.emp_no
												and a.to_date = '9999-01-01'
												and b.to_date = '9999-01-01'
												group by dept_no) s
where a.emp_no = b.emp_no 
and b.dept_no = c.dept_no
and b.dept_no = s.dept_no
and a.emp_no = d.emp_no
and d.salary > s.salary
and d.to_date = '9999-01-01'
and b.to_date = '9999-01-01';
 
 

-- 문제4. 
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요. 
SELECT 
    a.emp_no,
    concat(a.first_name, a.last_name) as name,
    concat(e.first_name, e.last_name) as manager,
    c.dept_name
FROM
    employees a,
    dept_emp b,
    departments c,
    dept_manager d,
    employees e
WHERE
    a.emp_no = b.emp_no					-- 부서테이블과 사원테이블 emp_no 연결
        AND b.dept_no = c.dept_no		
        AND d.dept_no = c.dept_no
        AND d.emp_no = e.emp_no			-- 매니저테이블과 사원테이블 emp_no 연결
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01';




-- 문제5. 
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요. 
SELECT 
    a.emp_no,
    CONCAT(a.first_name, a.last_name) name,
    c.title,
    d.salary
FROM
    employees a,
    dept_emp b,
    titles c,
    salaries d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND a.emp_no = d.emp_no
        AND b.dept_no = (SELECT 
							s.dept_no
						FROM
							(SELECT 
								AVG(a.salary) AS salary, b.dept_no
							FROM
								salaries a, dept_emp b
							WHERE
								a.emp_no = b.emp_no
							GROUP BY b.dept_no) s
						ORDER BY s.salary DESC
						LIMIT 1)
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
ORDER BY salary;



-- 문제6. 
-- 평균 연봉이 가장 높은 부서는?  
SELECT 
    s.dept_no, d.dept_name
FROM
    departments d,
    (SELECT 
        AVG(a.salary) AS salary, b.dept_no
    FROM
        salaries a, dept_emp b
    WHERE
        a.emp_no = b.emp_no
    GROUP BY b.dept_no) s
WHERE
    d.dept_no = s.dept_no
ORDER BY s.salary DESC
LIMIT 1;



-- 문제7. 
-- 평균 연봉이 가장 높은 직책? 
SELECT 
    AVG(salary) salary, a.title
FROM
    titles a,
    salaries b
WHERE
    a.emp_no = b.emp_no
GROUP BY a.title
ORDER BY AVG(salary) DESC
LIMIT 1;



-- 문제8. 
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은? 
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다. 

-- join만으로 풂(8.344sec 걸림)
SELECT 
    c.dept_name,
    CONCAT(a.first_name, a.last_name) AS name,
    MAX(ae.salary) AS employee_salary,
    CONCAT(da.first_name, da.last_name) AS manager,
    e.salary AS manager_salary
FROM
    employees a,
    salaries ae,
    dept_emp b,
    departments c,
    dept_manager d,
    employees da,
    salaries e
WHERE
    a.emp_no = b.emp_no
        AND b.dept_no = c.dept_no
        AND d.dept_no = c.dept_no
        AND a.emp_no = ae.emp_no
        AND d.emp_no = e.emp_no
        AND d.emp_no = da.emp_no
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND e.to_date = '9999-01-01'
        AND ae.salary > e.salary
GROUP BY c.dept_name , a.first_name , a.last_name , da.first_name , da.last_name , e.salary;

-- subquery 사용(5.578sec 걸림)
SELECT 
    c.dept_name,
    CONCAT(a.first_name, a.last_name) AS name,
    MAX(ae.salary) AS employee_salary,
    s.name AS manager,
    s.salary AS manager_salary
FROM
    employees a,
    salaries ae,
    dept_emp b,
    departments c,
	(SELECT concat(e.first_name, e.last_name) name, s.salary, d.dept_no
	  FROM dept_manager d, employees e, salaries s
	  where d.emp_no = e.emp_no
	  and d.emp_no = s.emp_no
	  and d.to_date = '9999-01-01'
	  and s.to_date = '9999-01-01')s
where a.emp_no = ae.emp_no
and	 a.emp_no = b.emp_no
and  b.dept_no = c.dept_no
and  s.dept_no = c.dept_no
and  ae.to_date = '9999-01-01'
and  b.to_date = '9999-01-01' 
group by c.dept_name, a.first_name, a.last_name, s.name, s.salary;
	  
  

