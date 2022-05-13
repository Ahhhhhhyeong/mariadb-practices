-- 함수: 문자열

-- upper
select upper('busan'), upper('ulsan'), upper('Douzone'); 
select upper(first_name) from employees;

-- lower
select lower('BUSAN'), lower('ULsan'), lower('Douzone'); 
select lower(first_name) from employees;

-- substring(문자열, index, length)
select substring('Hello World', 1, 5);

-- 예제: 1989년에 입사한 직원 이름, 성별, 입사일
select 
	concat(first_name,last_name) as '이름', 
	gender as '성별',
    hire_date as '입사일'
 from employees
 where substring(hire_date,1,4) = '1989';
 
 
 -- lpad(오른쪽 정렬), rpad(왼쪽 정렬)
 select lpad('1234', 10, '-');
 select rpad('1234', 10, '-');
-- 예제: 직원들의 월급을 오른쪽 정렬(빈공간은 *)
select lpad(salary, 10, '*') as '월급'
 from salaries;
 
 
 -- trim, ltrim, rtrim
 select concat('---',rtrim('     hello world       '), '---')
		,concat('---',ltrim('     hello world       '),'---')
		,concat('---', '    hello world   ', '---')
        ,trim(both 'x' from 'xxxxhelloxxxxx');


