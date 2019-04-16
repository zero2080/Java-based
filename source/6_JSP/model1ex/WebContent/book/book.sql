DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
DROP TABLE BOOK;
CREATE TABLE BOOK(
    bId NUMBER(5) PRIMARY KEY,
    bTitle VARCHAR2(100) NOT NULL,
    bPrice NUMBER(10) NOT NULL,
    bImage1 VARCHAR2(100) DEFAULT 'nothing.jpg',
    bImage2 VARCHAR2(100) DEFAULT 'nothing.jpg',
    bContent VARCHAR2(1000),
    bDiscount NUMBER(3));
-- 책 등록
INSERT INTO BOOK (bId, bTitle, bPrice, bImage1, bImage2, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP', 20000, 'nothing.jpg','nothing.jpg','좋은책',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bImage1, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'jQuery', 20000, 'nothing.jpg','좋은jQuery',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bImage2, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'Spring', 20000, 'nothing.jpg','좋은Spring',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'UI test', 20000, '좋은 test',0);
    
-- 전체 등록된 책 갯수
SELECT COUNT(*) FROM BOOK;

-- 전체 책 출력
SELECT * FROM BOOK ORDER BY bTitle;

-- ? ~ ?번째까지 책 출력(PAGING)
SELECT * FROM BOOK ORDER BY bTitle; -- 1단계
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A; -- 2단계
SELECT * FROM (
    SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A)
    WHERE RN BETWEEN 2 AND 3;