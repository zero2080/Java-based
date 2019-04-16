-- VIEW : 가상테이블
-- 단순뷰(하나의 테이블로 만든 VIEW), 복합뷰(2개 이상의 테이블로 VIEW)
CREATE OR REPLACE VIEW EMPv1
    AS SELECT * FROM EMP WHERE DEPTNO=20;
SELECT * FROM EMPv1;
INSERT INTO EMPv1 VALUES (1001, '홍',NULL, NULL, SYSDATE, 900, NULL, 20);
SELECT * FROM EMP;
SELECT * FROM EMPv1;
UPDATE EMPv1 SET JOB='MANAGER' WHERE EMPNO=1001;
DELETE FROM EMPv1 WHERE EMPNO=1001;
SELECT * FROM EMP;
SELECT * FROM EMPv1;
INSERT INTO EMPv1 VALUES (1002, '박',NULL, NULL, SYSDATE, 900, NULL,30);--가능
-- WITH CHECK OPTION을 이용한 VIEW
CREATE OR REPLACE VIEW EMPv1
    AS SELECT * FROM EMP WHERE DEPTNO=20 WITH CHECK OPTION;
SELECT * FROM EMPv1;
INSERT INTO EMPv1 VALUES (1100, '유',NULL, NULL, SYSDATE, 900, NULL, 20);
UPDATE EMPv1 SET DEPTNO=30 WHERE EMPNO=1100;
INSERT INTO EMPv1 VALUES (1101,'김',NULL, NULL, SYSDATE, 900, NULL, 10);
-- WITH READ ONLY
CREATE OR REPLACE VIEW EMPv1
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP WITH READ ONLY;
SELECT * FROM EMPv1 ORDER BY EMPNO;
INSERT INTO EMPv1 VALUES (2000,'하',40);
SELECT * FROM EMP;
DELETE FROM EMP WHERE EMPNO<3000;
COMMIT;
CREATE OR REPLACE VIEW SALv1
    AS SELECT EMPNO, ENAME, SAL*12 SALARY FROM EMP; -- 연산자가 들어가는 경우-별칭필요
SELECT * FROM SALv1;
INSERT INTO SALv1 VALUES (1000, '홍', 9600); -- 안 됨
SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
CREATE OR REPLACE VIEW DEPTv1
    AS SELECT DNAME, MIN(SAL) MINSAL, MAX(SAL) MAXSAL, AVG(SAL) AVGSAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
CREATE OR REPLACE VIEW DEPTv1 (DNAME, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DNAME, MIN(SAL), MAX(SAL), AVG(SAL)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
    -- 부서별로 부서명, 최소급여, 최대급여, 평균급여를 포함하는 DEPTv1 (뷰생성)
SELECT * FROM DEPTv1;
-- InLINE VIEW ; FROM 절의 SUBQUERY
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    -- 급여가 2000을 초과하는 사원의 평균 급여를 출력
SELECT ENAME, SAL, DEPTNO FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
SELECT ENAME, SAL, A.DEPTNO FROM EMP A, 
                        (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B
      WHERE A.DEPTNO=B.DEPTNO AND A.SAL>B.AVGSAL;
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;
    --부서급여평균보다 높은 사원의 이름, 급여, 부서번호를 부여주는 SQL문
SELECT ENAME, SAL, A.DEPTNO, AVGSAL
    FROM EMP A, (SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B
    WHERE A.DEPTNO=B.DEPTNO AND SAL>AVGSAL;
    --부서급여평균보다 높은 사원의 이름, 급여, 부서번호, 부서평균를 부여주는 SQL문
-- ★ TOP-N 구문 ★ -- 
SELECT EMPNO, ENAME, SAL FROM EMP ORDER BY SAL DESC;
SELECT ROWNUM, EMPNO, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM<=5;
-- RANK
SELECT EMPNO, ENAME, SAL, ROWNUM RANK FROM (SELECT * FROM EMP ORDER BY SAL DESC);

SELECT EMPNO, ENAME, SAL, RANK() OVER(ORDER BY SAL DESC) "RANK" FROM EMP;
SELECT EMPNO, ENAME, SAL, DENSE_RANK() OVER(ORDER BY SAL DESC) "D_RANK" FROM EMP;
SELECT EMPNO, ENAME, SAL, ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER" FROM EMP;
-- TOP-6부터 TOP-10까지 검색(SAL 내림차순 기준으로)
SELECT EMPNO, ENAME, SAL, ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUM FROM EMP
    WHERE ROW_NUM BETWEEN 6 AND 10; -- RANK관련 함수 필드는 WHERE 절에서 불가

SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);

SELECT ROWNUM, RN, ENAME, SAL FROM 
  (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC))
  WHERE RN BETWEEN 6 AND 10; -- ★★★
SELECT ROWNUM, RN, ENAME, SAL FROM
  (SELECT ENAME, SAL, ROW_NUMBER() OVER(ORDER BY SAL DESC) RN FROM EMP)
  WHERE RN BETWEEN 6 AND 10;

-- 탄탄1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 탄탄2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME WORKER, M.ENAME MANAGER FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 탄탄3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수)
SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC;
SELECT DEPTNO, SUMSAL, ROWNUM 
    FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP 
            GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);

-- 탄탄4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 탄탄5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 순으로 5명을 출력
SELECT ROWNUM, A.* 
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM<=5;
    
-- 탄탄6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 
        --6번째로 늦은 사원부터 10번째 사원까지 출력
SELECT ROWNUM, RN, EMPNO, ENAME, HIREDATE FROM
    (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE 
        FROM (SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;

-- 탄탄7. 사번을 기준으로 내림차순으로 4~6번째 사원의 모든 정보를 출력
-- ① ORDER BY
SELECT * FROM EMP ORDER BY EMPNO DESC;
-- ② INLINE-VIEW
SELECT ROWNUM, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO DESC) A;
-- ③ INLINE-VIEW 2단계
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO DESC) A)
    WHERE RN BETWEEN 4 AND 6;
    
SELECT ROWNUM, EMP.* FROM EMP;

-- SEQUENCE
DROP SEQUENCE ORDER_NO;
CREATE SEQUENCE order_no
    INCREMENT BY 1  -- 1씩 증가되는 시퀀드
    START WITH 1    -- 1부터 증가
    MAXVALUE 9999   -- 최대 9999까지 증가
    MINVALUE -9999  -- 최소값이 -9999
    NOCYCLE         
    NOCACHE;
SELECT ORDER_NO.NEXTVAL FROM DUAL;   -- 자동증감되는 시퀀스값 : NEXTVAL
SELECT ORDER_NO.CURRVAL FROM DUAL;   -- 현재의 시퀀스값 : CURRVAL
DROP TABLE FRIENDS;
CREATE TABLE FRIENDS(
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(50) NOT NULL,
    TEL VARCHAR2(50),
    LAST_MODIFIED DATE DEFAULT SYSDATE);
DROP SEQUENCE FRIENDS_SEQ;
CREATE SEQUENCE FRIENDS_SEQ
    MAXVALUE 9999.0 NOCYCLE NOCACHE;
INSERT INTO FRIENDS (ID, NAME, TEL) VALUES (FRIENDS_SEQ.NEXTVAL, '홍','999-999');

SELECT * FROM FRIENDS;
DROP SEQUENCE EX_SEQ;
CREATE SEQUENCE EX_SEQ START WITH 1 MAXVALUE 9999 NOCYCLE NOCACHE;
SELECT EX_SEQ.NEXTVAL FROM DUAL;

--1~4 다음과 같은 구조의 테이블을 생성하기 위한 테이블 생성하는 SQL문을 작성.
--  (단, 테이블이 있을시 테이블을 삭제하고 생성하시오) 
--  (조건1. 시퀀스를 생성한 뒤, 이를 이용하여 cno의 번호를 자동 생성한다.)
--  (조건2. customer테이블의 levelno는 cus_level테이블의 levelno 와 외래키 연결)
-- 데이터 입력 SQL문을 순서대로 작성하시오.
--[ customer 테이블 ] - cno가 주키, phone은 다른사람과 다르게 입력되도록 제한함
		      --joindate는 입력하지 않을시 현재날짜로 입력
--  cno    cname   joindate    phone         point  levelno
--   1   홍길동   17/10/17  010-9999-9999     300     1
--   2   이철수   16/09/06  010-9999-9888    NULL     2
--   3   홍길순   16/09/07  010-9999-7777      50     3
--[ cus_level 테이블 ] - levelno가 주키, levelname은 NOT NULL 조건.
       --levelno     levelname
   	--1            VVIP
   	--2             VIP           
   	--3            NORMAL
   	--4            BLACK
DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR2(10) NOT NULL);
DROP SEQUENCE CUSTOMER_SEQ;
CREATE SEQUENCE CUSTOMER_SEQ MAXVALUE 9999999999 NOCYCLE NOCACHE;
CREATE TABLE CUSTOMER(
    CNO NUMBER(10) PRIMARY KEY,
    CNAME VARCHAR2(20),   
    JOINDATE DATE DEFAULT SYSDATE,
    PHONE VARCHAR2(20) UNIQUE,
    POINT NUMBER(10),
    LEVELNO NUMBER(1) REFERENCES CUS_LEVEL(LEVELNO));
INSERT INTO CUS_LEVEL VALUES (1, 'VVIP');
INSERT INTO CUS_LEVEL VALUES (2, 'VIP');
INSERT INTO CUS_LEVEL VALUES (3, 'NORMAL');
INSERT INTO CUS_LEVEL VALUES (4, 'BLACK');
INSERT INTO CUSTOMER VALUES 
    (CUSTOMER_SEQ.NEXTVAL, '홍길동',SYSDATE, '010-9999-9999',300,1);
INSERT INTO CUSTOMER VALUES 
    (CUSTOMER_SEQ.NEXTVAL, '이철수',
    TO_DATE('20160619','YYYYMMDD'), '010-9999-9888',NULL,1);
INSERT INTO CUSTOMER VALUES 
    (CUSTOMER_SEQ.NEXTVAL, '홍길순',TO_DATE('20160907','YYYYMMDD'), 
    '010-9999-7777',50,3);
--5. 위와 같은 두개의 테이블을 이용하여 아래와 같이 출력하는 SQL문도 작성하시오
--  cno    cname   joindate    phone         point  levelname
   --1   홍길동   2017-10-17  010-9999-9999     300     VVIP
   --2   이철수   2016-09-06  010-9999-9888    NULL     VIP
   --3   홍길순   2016-09-07  010-9999-7777      50     NORMAL
SELECT CNO, CNAME, TO_CHAR(JOINDATE,'YYYY-MM-DD'), PHONE, POINT, LEVELNAME
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO=L.LEVELNO ORDER BY CNO;












