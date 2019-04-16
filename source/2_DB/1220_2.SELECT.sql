-- SQL문 중 SELECT문 = 데이터 검색
--★ 1. 간단한 SELECT
SELECT * FROM TAB; -- 내 계정이 소유한 테이블들 검색
SELECT * FROM DEPT; -- DEPT 테이블의 모든 필드 전체 검색
DESC DEPT;  -- DEPT 테이블의 구조 보기
SELECT * FROM EMP; -- EMP테이블의 모든 필드 전체 검색
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- 특정필드의 전체 행 검색
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB AS "직책" FROM EMP;
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP;
SELECT EMPNO 사번, ENAME 이름, SAL 급여 FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL S FROM EMP; -- 필드명의 별명 사용
--★ 2. WHERE절(조건절) - 비교연산자
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<>3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL^=3000;
SELECT * FROM EMP WHERE DEPTNO=10; -- 10번 부서인 사원의 모든 필드를 검색
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='FORD'; -- ENAME이 FORD인 직원의 사번, 이름, 급여를 검색
select empno, ename, sal from emp where ename='FORD';
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='ford';
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP WHERE SAL>=2000 ;
    -- sal이 2000이상인 사원의 사번(empno), 이름(ename), 급여(sal), 입사일(hiredate)
SELECT * FROM EMP WHERE HIREDATE<'82/01/01';
    -- 1982년 1월 1일 이전에 입사한 사원의 모든 필드 검색
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE FROM EMP WHERE ENAME < 'C';
    -- ENAME이 'A'나 'B'로 시작하는 행의 사번, 이름, JOB, MGR, HIREDATE를 검색

--★ 3. WHERE절 - 논리연산자(AND, OR, NOT)
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<3000; -- SAL이 2000대인 직원의 모든 필드를 검색
SELECT * FROM EMP WHERE DEPTNO=10 AND JOB='MANAGER';-- DEPNO가 10이고, JOB = 'MANAGER'인 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';-- 부서가 10번이거나 JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE NOT DEPTNO=10;
--★ 4. 산술연산식
SELECT EMPNO, ENAME, SAL, SAL+300 FROM EMP;
SELECT EMPNO, ENAME, SAL, SAL*12 "1년치월급" FROM EMP;
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+COMM 연봉 FROM EMP; -- NULL을 포함하면 결과도 NULL
SELECT ENAME, COMM, NVL(COMM, 0) FROM EMP;
    --NVL: 첫인자가 NULL일 경우 두번째 인자의 값으로 대치한다. 인자 둘이 같은 타입
SELECT ENAME, NVL(MGR, '사장') FROM EMP;
SELECT * FROM EMP WHERE SAL>NVL(COMM,0)*2;
--ex1.	emp 테이블의 구조 출력
DESC EMP;
--ex2.	emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--ex3.	이 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--ex4.	emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--ex5.	emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--ex6.	emp 테이블에서 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='82/02/01';
--ex7.	emp 테이블에서 업무가 SALESMAN인 사람들 모든 필드 출력
SELECT * FROM EMP WHERE JOB='SALESMAN';
--ex8. 업무(job)가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE NOT JOB='CLERK';
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
--ex9.	급여(sal)가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--ex10.	부서코드(deptno)가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30; -- ★
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN(10,30);
--ex11.	업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--ex12.	급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--ex13.	emp 테이블의 “ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력
SELECT ENAME||'은 '||JOB||' 업무이고 연봉은 '||(SAL*12+NVL(COMM,0))||'다'
    FROM EMP;
-- ★ 5. 연결연산자 (||)
SELECT ENAME || ' ' || JOB AS "employees_Details" FROM EMP;
SELECT ENAME||'의 연봉은 '|| (SAL*12+NVL(COMM,0))||'$다' FROM EMP;  
            -- "XX의 연봉은 XX$다"(SAL*12+COMM)
SELECT ENAME || '의 직책은 '||JOB||'다' TITLE
    FROM EMP 
    WHERE SAL>=2000 AND SAL<3000;-- xx(ENAME)의 직책은 xx(JOB)다. 단, SAL이 2000대
-- ★ 6. 중복제거 : DISTINCT
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB, DEPTNO FROM EMP;
-- ★ 7. 기타 SQL연산자 LIKE pattern, IN(10,20), BETWEEN a AND b, IS NULL
SELECT * FROM EMP WHERE ENAME LIKE '%A%';
       -- LIKE %(0글자이상) / LIKE _(한글자이상)
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
    -- 82년도에 입사한 사원의 사번, 이름, JOB, 급여, 입사일, 부서번호를 출력
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82/%';
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 2999;--BETWEEN a AND b (a,b포함)
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP 
    WHERE EMPNO=7902 OR EMPNO=7788 OR EMPNO=7566;
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP 
    WHERE EMPNO IN (7902, 7788, 7566);
    -- 사번이 7902, 7788, 7566인 사원의 사번, 이름, job, 급여, 입사일을 검색
SELECT * FROM EMP WHERE ENAME LIKE '%M%';
    -- 이름에 M이 들어가는 사원의 모든 필드를 검색
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    -- 이름이 M으로 시작하는 사원의 모든 필드를 검색
SELECT * FROM EMP WHERE ENAME LIKE '%M';
    -- 이름이 M으로 끝나는 사원의 모든 필드를 검색
SELECT * FROM EMP WHERE ENAME LIKE '_M%';
    -- 이름의 두번째 글자가 M인 사원의 모든 필드를 검색
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
    -- 이름에 %가 들어간 사원을 모든 필드 검색
SELECT * FROM EMP WHERE COMM IS NULL;
    -- COMM이 NULL인 사원의 모든 필드 검색
SELECT * FROM EMP WHERE COMM IS NOT NULL;
SELECT * FROM EMP WHERE NOT COMM IS NULL;
    -- COMM이 NULL이 아닌 사원의 모든 필드 검색
SELECT * FROM EMP WHERE ENAME NOT LIKE '%A%';
SELECT * FROM EMP WHERE SAL NOT BETWEEN 2000 AND 2999;
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,30);
-- ★ 8. 정렬을 위한 ORDER BY 절
SELECT * FROM EMP ORDER BY SAL, ENAME; -- 오름차순 정렬
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC, HIREDATE DESC; -- 내림차순 정렬
SELECT ENAME, SAL 급여 FROM EMP ORDER BY 급여 DESC;
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) 연봉 
    FROM EMP 
    WHERE SAL*12+NVL(COMM,0)>=1000
    ORDER BY 연봉 DESC;
  -- 연봉(SAL*12+COMM)이 10000이상인 직원의 이름과 급여, 연봉를 연봉순(내림차순)으로 출력

-- work181220.sql
--ex1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;

--ex2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;

--ex3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12+NVL(COMM,0) >= 24000 ORDER BY SAL;

--ex4.	EMP 테이블에서 hiredate가 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의
    --ename,job,hiredate을 출력하는 SELECT 문장을 작성 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
    
--ex5.	EMP 테이블에서 deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;

--ex6.	EMP 테이블에서 sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
    --(단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly_Salary" 
    FROM EMP WHERE SAL>=1500 AND (DEPTNO=10 OR DEPTNO=30);
--ex7.	EMP 테이블에서 hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__';

--ex8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME>='C' AND ENAME<'Q' ORDER BY ENAME;
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' ORDER BY ENAME;

--ex9.EMP 테이블에서 comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금 출력
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>SAL*1.1;

--ex10.	EMP 테이블에서 job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 
    --모든 사원의 정보를 출력
SELECT * FROM EMP 
    WHERE JOB IN ('CLERK', 'ANALYST') AND SAL NOT IN (1000,3000,5000);
    
--ex11.	EMP 테이블에서 ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 
    --사원의 모든 정보를 출력
SELECT * FROM EMP 
    WHERE ENAME LIKE '%L%L%' AND DEPTNO=30 OR MGR=7782;
    
--ex12.	사원 테이블에서 입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
    WHERE HIREDATE>='81/01/01' AND HIREDATE<='81/12/31';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
    WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
    
--ex13.	사원 테이블에서 입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 
    --사번, 사원명, 입사일, 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '81/%' AND JOB!='SALESMAN';
    
--ex14.	사원 테이블의 사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
    --급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;

--ex15.	사원 테이블에서 사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--ex16.	사원 테이블에서연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE SAL*12>=35000;





