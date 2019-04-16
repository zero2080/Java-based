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

-- stratRow ~ endRow까지 책 출력(PAGING)
SELECT * FROM BOOK ORDER BY bTitle; -- 1단계
SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A; -- 2단계
SELECT * FROM (
    SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTitle) A)
    WHERE RN BETWEEN 2 AND 3;

-- 특정책의 상세보기
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
 
-- CustomerDao의 confirmId와 회원가입
SELECT * FROM CUSTOMER WHERE CID='aaa';
INSERT INTO CUSTOMER (cid, cpw, cname, ctel, cemail, cgender, caddr)
    VALUES ('aaa','111','홍길동','9999-9999','hong@tj.com','m','서울시 종로');

commit;
-- 메인화면에서 쓸 회원정보 리스트(페이징에서 회원수 가져오기)
SELECT COUNT(*) FROM CUSTOMER;
-- 메인화면에서 쓸 회원정보 리스트(페이징 안되는거)
SELECT * FROM CUSTOMER ORDER BY CID;
-- 메인화면에서 쓸 회원정보 리스트(페이징 되는 거 만들어보자)
SELECT ROWNUM RN, A.* FROM
    (SELECT * FROM CUSTOMER ORDER BY CID) A;
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
        (SELECT * FROM CUSTOMER ORDER BY CID) A)
    WHERE RN BETWEEN 2 AND 3;
-- CustomerDao의 로그인, 중복체크, 회원정보 수정시 dto가져오기
SELECT * FROM CUSTOMER WHERE CID='aaa';
-- CustomerDao의 회원정보 수정
UPDATE CUSTOMER SET CPW='111', CNAME='홍길동',
    CTEL='010-9999-9999', CEMAIL='hong@s.com', CGENDER='f',
    CADDR='서울시 종로구' WHERE CID='aaa';
commit;

-- FILEBoardDao의 글갯수 리턴
SELECT COUNT(*) TOTCNT FROM FILEBOARD;
-- FILEBoardDao의 글 입력
INSERT INTO FILEBOARD 
    (fNum, cId, fSubject, fContent, 
        fFilename, fReadcount, fPw, fRef, fRe_step, fRe_level,fIp, fRdate)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa','제목','본문\n입니다',
        NULL,0,'11',fileboard_seq.CURRVAL, 0,0,'127.0.0.1',SYSDATE);

-- 답변글 추가 전 해야할 ⓐ STEP   
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP+1 WHERE FREF=1 AND FRE_STEP>0;

-- 글 갯수
SELECT COUNT(*) TOTCNT FROM FILEBOARD;

-- FILEBoardDao의 글목록
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC;
SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY FNUM DESC) A;
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ORDER BY fref DESC, fre_step) A)
    WHERE RN BETWEEN 2 AND 4; -- 페이징처리에서 쓸 TOP-N구문

-- FILEBoardDao의 글 상세보기
UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM=1;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID AND F.FNUM=11;
SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID=C.CID ;
-- 글 수정
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