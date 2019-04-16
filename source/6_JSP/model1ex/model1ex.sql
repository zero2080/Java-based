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

-- stratRow ~ endRow���� å ���(PAGING)
SELECT * FROM BOOK ORDER BY bTitle; -- 1�ܰ�
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A; -- 2�ܰ�
SELECT * FROM (
    SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A)
    WHERE RN BETWEEN 2 AND 3;

-- Ư��å�� �󼼺���
SELECT * FROM BOOK WHERE BID=5;
commit;
 
DROP TABLE FILEBOARD;
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    cId VARCHAR2(30) PRIMARY KEY,
    cPw VARCHAR2(30) NOT NULL,
    cName VARCHAR2(30) NOT NULL,
    cTel VARCHAR2(30),
    cEmail VARCHAR2(30) NOT NULL,
    cGender VARCHAR2(10),
    cAddr VARCHAR2(100));
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE FILEBOARD(
    fNum NUMBER(5) PRIMARY KEY,
    cId VARCHAR2(30),
    fSubject VARCHAR2(300) NOT NULL,
    fContent VARCHAR2(1000) NOT NULL,
    fFilename VARCHAR2(100),
    fReadcount NUMBER(5) NOT NULL,
    fPw        VARCHAR2(30) NOT NULL,
    fRef       NUMBER(5) NOT NULL,
    fRe_step   NUMBER(5) NOT NULL,
    fRe_level  NUMBER(2) NOT NULL,
    fIp        VARCHAR2(20) NOT NULL,
    fRdate     DATE NOT NULL,
    FOREIGN KEY(cId) REFERENCES CUSTOMER(cId));
 
-- CustomerDao�� confirmId�� ȸ������
SELECT * FROM CUSTOMER WHERE CID='aaa';
INSERT INTO CUSTOMER (cid, cpw, cname, ctel, cemail, cgender, caddr)
    VALUES ('aaa','111','ȫ�浿','9999-9999','hong@tj.com','m','����� ����');

commit;
-- ����ȭ�鿡�� �� ȸ������ ����Ʈ(����¡���� ȸ���� ��������)
SELECT COUNT(*) FROM CUSTOMER;
-- ����ȭ�鿡�� �� ȸ������ ����Ʈ(����¡ �ȵǴ°�)
SELECT * FROM CUSTOMER ORDER BY CID;
-- ����ȭ�鿡�� �� ȸ������ ����Ʈ(����¡ �Ǵ� �� ������)
SELECT ROWNUM RN, A.* FROM
    (SELECT * FROM CUSTOMER ORDER BY CID) A;
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
        (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 2 AND 3;
-- CustomerDao�� �α���, �ߺ�üũ, ȸ������ ������ dto��������
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- CustomerDao�� ȸ������ ����
UPDATE CUSTOMER SET CPW='111', CNAME='ȫ�浿',
    CTEL='010-9999-9999', CEMAIL='hong@s.com', CGENDER='f',
    CADDR='����� ���α�' WHERE CID='aaa';
commit;

-- FILEBoardDao�� �۰��� ����
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
-- FILEBoardDao�� �� �Է�
INSERT INTO FILEBOARD 
    (fNum, cId, fSubject, fContent, 
        fFilename, fReadcount, fPw, fRef, fRe_step, fRe_level,fIp, fRdate)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','����','����\n�Դϴ�',
        NULL,0,'11',fileboard_seq.CURRVAL, 0,0,'127.0.0.1',SYSDATE);

-- �亯�� �߰� �� �ؾ��� �� STEP   
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP+1 WHERE FREF=1 AND FRE_STEP>0;

-- �� ����
SELECT COUNT(*) TOTCNT FROM FILEBOARD;

-- FILEBoardDao�� �۸��
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC;
SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY fref DESC, fre_step) A)
    WHERE RN BETWEEN 2 AND 4; -- ����¡ó������ �� TOP-N����

-- FILEBoardDao�� �� �󼼺���
UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM=1;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID AND F.FNUM=11;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ;
-- �� ����
UPDATE FILEBOARD SET 
    FSUBJECT = 'TITLE',
    FFILENAME = NULL,
    FCONTENT = 'CONTENT',
    FPW = '11',
    FIP = '127.0.0.1'
    WHERE FNUM = 1;

DELETE FROM FILEBOARD WHERE FNUM=111 AND FPW='11';
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID;
COMMIT;