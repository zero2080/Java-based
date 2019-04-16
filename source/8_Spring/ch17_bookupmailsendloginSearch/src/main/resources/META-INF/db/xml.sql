-- Memeber.xml의 id=getMember
SELECT * FROM MEMBER WHERE MID='aaa';
-- Member.xml의 id=joinMember
INSERT INTO MEMBER VALUES
    ('bbb','111','홍길동','uxui.userid@gmail.com',
    '서울시 종로구','01234');
-- Member.xml의 id=modifyMember
UPDATE MEMBER SET
    MPW='111',
    MNAME='문길동',
    MMAIL='uxui@h.com',
    MADDR='서울시 용산구',
    MPOST='01234'
    WHERE MID='aaa';
-- Member.xml의 idConfirm
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';
commit;
-- Book.xml의 id=bookListAll
SELECT * FROM BOOK order by brdate desc;
-- Book.xml의 id=bookListPaging
SELECT * FROM (SELECT ROWNUM RN, A.*
FROM (SELECT * FROM BOOK order by btitle) A)
WHERE RN BETWEEN 1 AND 33;
-- Book.xml의 id=getBook
SELECT * FROM BOOK WHERE BNUM=21;
-- Book.xml의 id=registerBook
INSERT INTO BOOK VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','최범석',SYSDATE,
    'noimg.jpg','noimg.jpg','좋은 JSP 책이다');
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','최범석',SYSDATE,
    'noimg.jpg','좋은 JSP 책이다');    
-- Book.xml의 id=modifyBook
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg1='noimg.jpg',
    bimg2='noimg.jpg',
    binfo='좋은 책'
    WHERE BNUM=2;
-- Book.xml의 id=cntBook
SELECT COUNT(*) FROM BOOK;
select count(*) from book where bwriter like '%'||'김'||'%';
COMMIT;