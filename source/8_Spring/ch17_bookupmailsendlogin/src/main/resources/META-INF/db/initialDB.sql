-- initialDB.sql
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    mId VARCHAR2(20) PRIMARY KEY, -- 아이디
    mPw VARCHAR2(20) NOT NULL, -- 비번
    mName VARCHAR2(50) NOT NULL, -- 이름
    mMail VARCHAR2(50) NOT NULL, -- 메일주소
    mAddr VARCHAR2(200), --  주소
    mPost VARCHAR2(10)); --  우편번호
INSERT INTO MEMBER VALUES
    ('aaa','111','홍길동','hybrid190501@gmail.com', '서울시 종로구','01234');
SELECT * FROM MEMBER;
DROP TABLE BOOK CASCADE CONSTRAINTS;
CREATE TABLE BOOK(
    bNUM NUMBER(4) PRIMARY KEY, -- 책번호(시퀀스이용)
    bTITLE VARCHAR2(200) NOT NULL, -- 책이름
    bWRITER VARCHAR2(50) NOT NULL, -- 저자
    bRDATE DATE DEFAULT SYSDATE,   -- 출판일
    bIMG1 VARCHAR2(100) DEFAULT 'noimg.jpg', -- 책이미지1
    bIMG2 VARCHAR2(100) DEFAULT 'noimg.jpg', -- 책이미지2
    bINFO VARCHAR2(2000));  -- 책정보
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ;
INSERT INTO BOOK VALUES
(BOOK_SEQ.NEXTVAL, 'JSP','최범석', '19-01-01', 'noimg.jpg','noimg.jpg','좋은 스프링 책이다');
COMMIT;
