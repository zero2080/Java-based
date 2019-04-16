INSERT INTO DEPT VALUES (50, 'IT','JONGRO');
commit;

SELECT * FROM DEPT;
-- 사용자에게 수정할 부서번호?
-- 입력한 부서번호가 있는지 보고
SELECT * FROM DEPT WHERE DEPTNO=10;
-- 1. 부서번호가 있는 경우 : 아래의 쿼리 수행(dname, loc 질문 후 수정)
UPDATE DEPT SET DNAME='XX', LOC='YY'
    WHERE DEPTNO=50;
-- 2. 부서번호가 없는 경우 : 부서번호 없다고 출력
