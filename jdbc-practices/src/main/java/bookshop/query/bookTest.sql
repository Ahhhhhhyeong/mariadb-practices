-- bookshop

-- schema check
desc book;
desc author;

-- AuthorDao:insert
insert into author values (null, '스테파니메이어');
select * from author;



-- BookDao:insert
 -- insert into book values (null, 'title', '재고있음', 1);
select * FROM book;
-- delete from book;
-- BookDao:Select
select a.no, a.title, b.name, a.state_code
  from book a, author b
where a.author_no = b.no
order by a.no asc;

-- author, book 지우기
-- set FOREIGN_KEY_CHECKS = 0; -- 외래키 체크 해제
-- truncate table author;
-- truncate table book;
-- set FOREIGN_KEY_CHECKS = 1; -- 외래키 체크 설정
select * from book;

select a.no, a.title, b.name, a.state_code, b.no 
from book a, author b 
where a.author_no = b.no 
and a.no = 4 
order by a.no asc