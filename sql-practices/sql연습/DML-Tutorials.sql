-- Basic Query

-- 1. 버전과 날짜 검색
-- 대소문자 구분이 없다.
SELECT VERSION(), CURRENT_DATE();

-- 2. 수학함수
select sin(pi()/4), (4+1)*4;

-- 3-1. 테이블 삭제
drop table pet;

-- 3-2. 테이블 생성
create table pet(
	name varchar(20),
    owner varchar(20),
    species varchar(20),
    gender char(1),
    birth date,
    death date
);

-- 4. schema 확인
desc pet;

-- 5. insert / 데이터 입력(생성, create)
insert into pet values('누렁이', '고모', 'dog', 'F', '2018-03-13', null);

-- 6. select / 데이터 검색(읽기, read)
select name, owner, species, gender, birth, death from pet;

-- 7. delete / 데이터 삭제
delete from pet where name = '누렁이';

-- 8. load data local inFile
load data local infile 'd:\\pet.txt' into table pet;

-- 9. update / 데이터 수정
update pet set death = null where name != 'Bowser';

-- 조회(검색) 연습1 : where
-- 1990년 이후에 태어난 아이들은?
select name, species, birth
	from pet 
where birth >='1990-12-31';

-- Gwen과 같이 사는 아이들은?
select name, owner, species
	from pet
where owner = 'Gwen';

-- null 다루기 1
-- 살아 있는 애들은?
select name, species, death
	from pet
where death is null;	-- death = null 은 안됨

-- 죽은 애들은?
select name, species, death
	from pet
where death is not null;

-- like 검색(패턴매칭)
-- 이름이 b로 시작하는 애들 검색 
select name, species
	from pet
where name like 'b%';

-- like 검색2
-- 이름이 b로 시작하는 아이들중 이름이 6자인 아이들 검색
select name, species
	from pet
where name like 'b_____';

-- 집계함수(통계)
select count(name) from pet;

select count(death) from pet;
select count(*) from pet where death is not null;


-- order by
-- 나이가 어린 아이 순으로 이름, 종, 생일로 출력 하세요
select name, species, birth
	from pet
order by birth desc;
-- 뒤에 조건을 더 붙일 수 있음

