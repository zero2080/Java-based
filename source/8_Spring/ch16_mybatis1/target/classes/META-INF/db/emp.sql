-- Emp.xml(mapper) id=empList
SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%'||'S'||'%';
SELECT * FROM EMP WHERE JOB LIKE '%'||'E'||'%';
SELECT * FROM EMP WHERE DEPTNO=20;
SELECT * FROM EMP WHERE ENAME LIKE '%'||'S'||'%'
                    AND JOB LIKE '%'||'E'||'%'
                    AND DEPTNO=20;
-- Dept.xml(mapper) id=deptList
SELECT * FROM DEPT;