74-- Emp.xml�� id=empList
SELECT * FROM EMP ORDER BY EMPNO; -- 1�ܰ�
SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM EMP ORDER BY EMPNO) A; -- 2�ܰ�
SELECT * FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM EMP ORDER BY EMPNO) A)
    WHERE RN BETWEEN 6 AND 10; -- 3�ܰ� (�ϼ�)
-- Emp.xml�� id=total
SELECT COUNT(*) FROM EMP;
-- Emp.xml�� id=detail
SELECT * FROM EMP WHERE EMPNO=7499;
-- Emp.xml�� id=managerList
SELECT MGR FROM EMP;
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);

-- Eml.xml�� id=insert
INSERT INTO EMP VALUES
    (9000, 'HONG', 'IT', 7499, '19-04-02', 6000, 300, 40);
-- Emp.xml�� id=update
UPDATE EMP SET ENAME='KIM',
               JOB = 'OPPER',
               MGR=7499,
               HIREDATE='99-04-02',
               SAL = 6000,
               COMM = 200,
               DEPTNO=30
        WHERE EMPNO=9000;
-- Emp.xml�� id=delete
DELETE FROM EMP WHERE EMPNO=9000;

-- Dept.xml�� id=deptList
SELECT * FROM DEPT;

-- EmpDetp.xml�� id=empDeptList
SELECT E.*, DNAME, LOC FROM EMP e, DEPT d 
        WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO; -- 1�ܰ�

SELECT ROWNUM RN, A.* 
  FROM (SELECT E.*, DNAME, LOC 
                FROM EMP e, DEPT d WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A;--2�ܰ�

SELECT * FROM (SELECT ROWNUM RN, A.* 
    FROM (SELECT E.*, DNAME, LOC 
                    FROM EMP e, DEPT d WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A)
    WHERE RN BETWEEN 6 AND 10; -- 3�ܰ�
   
    
    
    