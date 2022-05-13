-- 함수: 수학

-- abs
select abs(-1), abs(1);

-- mod
select mod(10, 3);

-- ceil
select ceil(3.14), ceiling(3.14);

-- floor
select floor(3.14);

-- round(x) : x 반올림
-- round(x, d) : d자리에서 반올림
select round(3.14), round(3.141592, 2);


-- power(x, y), pow(x, y) : x의 y승
select power(2, 10), pow(2, 10);

-- sign(x)
select sign(20), sign(-20), sign(0);

-- greatest(x, y...), least(x,y,q,a,s,...) 괄호안의 데이터 중 최대or최소값
select greatest(18,16,2,95,445,22), least(18,16,2,95,445,22);
select greatest('b','z','c'), greatest('hello', 'hellq','helzp');







