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
-- å ���
INSERT INTO BOOK (bId, bTitle, bPrice, bImage1, bImage2, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'JSP', 20000, 'nothing.jpg','nothing.jpg','����å',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bImage1, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'jQuery', 20000, 'nothing.jpg','����jQuery',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bImage2, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'Spring', 20000, 'nothing.jpg','����Spring',0);
    
INSERT INTO BOOK (bId, bTitle, bPrice, bContent, bDiscount)
    VALUES (BOOK_SEQ.NEXTVAL, 'UI test', 20000, '���� test',0);
    
-- ��ü ��ϵ� å ����
SELECT COUNT(*) FROM BOOK;

-- ��ü å ���
SELECT * FROM BOOK ORDER BY bTitle;

-- ? ~ ?��°���� å ���(PAGING)
SELECT * FROM BOOK ORDER BY bTitle; -- 1�ܰ�
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A; -- 2�ܰ�
SELECT * FROM (
    SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A)
    WHERE RN BETWEEN 2 AND 3;