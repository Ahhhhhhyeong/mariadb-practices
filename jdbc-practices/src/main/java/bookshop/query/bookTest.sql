-- bookshop

-- schema check
desc book;
desc author;

-- AuthorDao:insert
insert into author values (null, '스테파니메이어');
select * from author;

-- BookDao:insert
-- insert into book values (null, 'title', '재고있음', 1);

-- BookDao:Select
select a.no, a.title, b.name, a.state_code
  from book a, author b
where a.author_no = b.no
order by a.no asc;

