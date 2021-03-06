-- DML (INSERT, UPDATE, DELETE, SELECT)
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
--★ INSERT INTO table_name (column_name, ..) VALUES (column_values, …);
INSERT INTO DEPT01 (DEPTNO, LOC, DNAME) VALUES (50, '관철동','IT');
INSERT INTO DEPT01 VALUES (50, 'OPERATIONS', '남산');
INSERT INTO DEPT01 VALUES (60, '전산',NULL); -- 명시적으로 NULL입력
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, '회계'); -- 묵시적인 NULL 입력
SELECT * FROM DEPT01;
-- 예제 : SAM01테이블의 구조 : EMPNO(사번) ? NUMBER(4)
                        --  ENAME(이름) ? VARCHAR2(10)
                        --  JOB(직책) ? VARCHAR2(9)
                        -- SAL(급여) ? NUMBER(7,2)
        -- INSERT :	EMPNO	ENAME	JOB		    SAL
                --	1000	APPLE	POLICE		10000
                --	1010	BANANA	NURSE		15000
                --	1020	ORANGE	DOCTOR		25000
DROP TABLE SAM01;
CREATE TABLE SAM01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2));
INSERT INTO SAM01 (EMPNO, ENAME, JOB, SAL) VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
SELECT * FROM SAM01;
 -- INSERT :	EMPNO	ENAME	JOB		    SAL
            --	1030	VERY				25000
            --	1040	CAT				    2000
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL, 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040, 'CAT', 2000);
SELECT * FROM SAM01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- CREATE문의 서브쿼리
CREATE TABLE DEPT02 AS SELECT * FROM DEPT WHERE 1=0; -- 컬럼 구조 만 
SELECT * FROM DEPT02;

INSERT INTO DEPT02 SELECT * FROM DEPT;
-- SAM01 테이블에 EMP테이블의 일부 내용을 서브쿼리를 이용해서 INSERT
    --EMPNO	ENAME		JOB		    SAL
    --7782	CLARK		MANAGER	    2450
    --7839	KING		PRESIDENT	5000
    --7934	MILLER		CLERK		1300
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO=10;
SELECT * FROM SAM01;

SELECT * FROM BOOK;
INSERT INTO BOOK (BOOKID, BOOKNAME, PULISHER, PRICE)
    VALUES (11, '스포츠의학', '한빛',20000);
INSERT INTO BOOK VALUES (12, 'ORACLE', '에이콘',10000);

--★ UPDATE 테이블이름 SET 필드명1=값1, 필드명2=값2,.....WHERE 조건;
SELECT * FROM EMP01;
UPDATE EMP01 SET DEPTNO=30;
UPDATE EMP01 SET SAL=SAL*1.1, HIREDATE=SYSDATE;
    -- EMP01 테이블의 모든 사원의 SAL을 10%인상시키고 입사일을 지금이시점으로 수정
SELECT TO_CHAR(HIREDATE, 'YY-MM-DD HH24:MI:SS') FROM EMP01;
SELECT * FROM BOOK;
UPDATE BOOK SET PRICE = 12000 WHERE BOOKID=12;
UPDATE EMP01 SET JOB='CLERK' WHERE JOB='SALESMAN';
    -- EMP01테이블의 JOB이 SALESMAN인 사원을 CLERK 으로 수정
SELECT * FROM EMP01;
UPDATE EMP01 SET SAL=SAL*1.1 WHERE SAL>=3000;
    -- 급여가 3000 이상인 사원들만 급여 10%인상
UPDATE EMP01 SET DEPTNO=20 WHERE JOB='CLERK';
    -- JOB이 CLERK인 사원들을 20번 부서로 이동
UPDATE EMP01 SET SAL=SAL+5000 
    WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');
    -- DALLAS에 근무하는 사원들의 급여를 5000달러씩 인상
UPDATE EMP01 SET DEPTNO=20, JOB='MANAGER', COMM=400 WHERE ENAME='SCOTT';
    -- SCOTT의 부서를 20번 부서로 이동, JOB이 MANAGER로, COMM을 400으로 수정
UPDATE DEPT01 SET LOC=(SELECT LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO=20;
SELECT * FROM DEPT01;
    -- DEPT01테이블에서 20번 부서의 지역명을 40부서의 지역명으로 수정
UPDATE EMP01 SET SAL=(SELECT SAL FROM EMP01 WHERE ENAME='KING'),
             HIREDATE=(SELECT HIREDATE FROM EMP01 WHERE ENAME='KING');
UPDATE EMP01 SET (SAL, HIREDATE) = 
                (SELECT SAL, HIREDATE FROM EMP01 WHERE ENAME='KING');
SELECT * FROM EMP01;
    -- EMP01테이블에서 모든 사원의 급여와 입사일을 KING의 급여와 입사일로 수정
COMMIT;
--★  DELETE FROM 테이블명 WHERE 조건;
SELECT * FROM DEPT01;
DELETE FROM DEPT01; -- WHERE절이 없으면 테이블내 모든 데이터 삭제 DML(복구가능)
TRUNCATE TABLE DEPT01; -- DDL (복구 불가)
ROLLBACK;
DROP TABLE DEPT01;
CREATE TABLE DEPT01 AS SELECT * FROM DEPT;
DELETE FROM DEPT01 WHERE DEPTNO=30;
    -- DEPT01테이블에서 30번 부서의 데이터를 삭제
DELETE FROM EMP01 WHERE MGR IS NULL;
    -- EMP01테이블에서 MGR이 NULL인 사원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
    -- EMP01테이블에서 부서명이 SALES인 사원을 삭제
DELETE FROM EMP01 WHERE DEPTNO=(SELECT DEPTNO FROM DEPT01 WHERE DNAME='RESEARCH');
    -- EMP01테이블에서 RESEARCH 부서 소속 사원들 삭제

-- EMP1과 DEPT1 생성(제약조건이름을 명시하지 않음)과 INSERT
DROP TABLE EMP1;
DROP TABLE DEPT1;
CREATE TABLE DEPT1 (
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13));
    
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) ,
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    PRIMARY KEY(EMPNO),
    UNIQUE(JOB),
    CHECK (SAL>=0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO));
    
INSERT INTO DEPT1 (DEPTNO, DNAME, LOC) VALUES (10,'회계','종로');
INSERT INTO DEPT1 VALUES (20, '설계','용산');
INSERT INTO DEPT1 VALUES (30, '영업', NULL);
INSERT INTO DEPT1 (DEPTNO, DNAME) VALUES (40, '전산');
SELECT * FROM DEPT1;

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1001,'홍','회장',NULL,9000,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1002,'박','부장',NULL,9000,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1003,'박','과장',NULL,9000,90);   
INSERT INTO EMP1 VALUES (1004,'정','대리',1003, 
                            TO_DATE('20181212','YYYYMMDD'),8000,10,30);
UPDATE EMP1 SET SAL = -10 WHERE EMPNO=1004;
SELECT * FROM EMP1;
    
-- EMP1과 DEPT1 생성(제약조건이름을 명시)과 INSERT
DROP TABLE EMP1;
DROP TABLE DEPT1;
CREATE TABLE DEPT1 (
    DEPTNO NUMBER(2) CONSTRAINT DEPT1_PK PRIMARY KEY,
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13));
    
CREATE TABLE EMP1(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) CONSTRAINT EMP1_NOTNULL NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2) ,
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    CONSTRAINT EMP1_PK PRIMARY KEY(EMPNO),
    CONSTRAINT EMP1_UQ UNIQUE(JOB),
    CONSTRAINT EMP1_SALCHK CHECK (SAL>=0),
    CONSTRAINT EMP1_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO));
SELECT * FROM USER_CONSTRAINTS;
    
INSERT INTO DEPT1 (DEPTNO, DNAME, LOC) VALUES (10,'회계','종로');
INSERT INTO DEPT1 VALUES (20, '설계','용산');
INSERT INTO DEPT1 VALUES (30, '영업', NULL);
INSERT INTO DEPT1 (DEPTNO, DNAME) VALUES (40, '전산');
SELECT * FROM DEPT1;

INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1001,'홍','회장',NULL,9000,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1002,'박','부장',NULL,9000,10);
INSERT INTO EMP1 (EMPNO, ENAME, JOB, MGR, SAL, DEPTNO)
    VALUES (1003,'박','과장',NULL,9000,90);   
INSERT INTO EMP1 VALUES (1004,'정','대리',1003, 
                            TO_DATE('20181212','YYYYMMDD'),8000,10,30);
UPDATE EMP1 SET SAL = -10 WHERE EMPNO=1004;
SELECT * FROM EMP1;
    
-- 트랜젝션(COMMIT, ROLLBACK, SAVEPOINT)
INSERT INTO DEPT01 VALUES (30, 'SALES','SEOUL');
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT;  ------------------- 트랜잭션 시작
DELETE FROM DEPT01 WHERE DEPTNO=30;
SAVEPOINT C1;
DELETE FROM DEPT01 WHERE DEPTNO=20;
SAVEPOINT C2;
DELETE FROM DEPT01 WHERE DEPTNO=10;
ROLLBACK TO C2;
SELECT * FROM DEPT01;