-- ★ ★ ★ Member.xml ★ ★ ★
-- Member.xml의 idConfirm (id중복체크)
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';

-- Member.xml의 id=joinMember(회원가입)
INSERT INTO MEMBER VALUES
    ('bbb','111','홍길동','hybrid190501@gmail.com',
    '서울시 종로구','01234');
    
-- Memeber.xml의 id=getMember(mid로 회원정보 가져오기)
SELECT * FROM MEMBER WHERE MID='aaa';

-- Member.xml의 id=modifyMember(회원정보수정하기)
UPDATE MEMBER SET
    MPW='111',
    MNAME='문길동',
    MMAIL='hybrid@tj.com',
    MADDR='서울시 용산구',
    MPOST='01234'
    WHERE MID='aaa';
commit;
-- ★ ★ ★ Book.xml ★ ★ ★
-- Book.xml의 id=bookListAll (신상순서대로 모든 책 리스트)
SELECT * FROM BOOK order by brdate DESC;
-- Book.xml의 id=bookListPaging(책제목 순서대로 top-N구문)
SELECT * FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM BOOK order by btitle) A)
    WHERE RN BETWEEN 1 AND 3;
-- Book.xml의 id=getBook(책번호로 책정보 가져오기)
SELECT * FROM BOOK WHERE BNUM=1;
-- Book.xml의 id=registerBook(책등록)
INSERT INTO BOOK VALUES
    (BOOK_SEQ.NEXTVAL, 'Java','윤길동',SYSDATE,
                'noimg.jpg','noimg.jpg','좋은 JSP 책이다');
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG1, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'html','최범석',SYSDATE,
    'noimg.jpg','좋은 JSP 책이다');   
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'JavaScript','최범석',SYSDATE,
    'noimg.jpg','좋은 JSP 책이다');    
INSERT INTO BOOK (BNUM, BTITLE, BWRITER, BRDATE, BINFO) VALUES
    (BOOK_SEQ.NEXTVAL, 'python','홍길동',SYSDATE,'좋은 JSP 책이다');
-- Book.xml의 id=modifyBook(책정보수정)
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg1='noimg.jpg',
    bimg2='noimg.jpg',
    binfo='좋은 책'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg1='noimg.jpg',
    binfo='좋은 책'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    bimg2='noimg.jpg',
    binfo='좋은 책'
    WHERE BNUM=2;
UPDATE BOOK SET
    btitle='jsp servlet',
    bwriter='최',
    brdate=sysdate,
    binfo='좋은 책'
    WHERE BNUM=2;
-- Book.xml의 id=cntBook(등록된 책갯수)
SELECT COUNT(*) FROM BOOK;
COMMIT;