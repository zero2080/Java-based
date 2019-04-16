-- �׷��Լ� ( SUM, AVG, COUNT, MAX, MIN, STDDEV, VARIANCE)
-- �� 1. �׷��Լ��� ���Ͽ�
SELECT SUM(SAL) FROM EMP;
SELECT TO_CHAR(SUM(SAL), '$999,999') FROM EMP;
SELECT SUM(COMM) FROM EMP; -- �׷��Լ��� NULL�� �����ϰ� ����
SELECT COMM FROM EMP;
SELECT COUNT(*) FROM EMP;
SELECT COUNT(SAL) FROM EMP;
SELECT COUNT(COMM) FROM EMP;
SELECT SUM(ENAME) FROM EMP; -- �������� SUM, AVG, STDDEV, VARIANCE�� �Ұ�
SELECT SUM(HIREDATE) FROM EMP;-- DATE���� SUM, AVG, STDDEV, VARIANCE�� �Ұ�
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT AVG(COMM), SUM(COMM)/COUNT(COMM) FROM EMP;
SELECT MAX(SAL), MIN(SAL) FROM EMP; -- MAX, MIN�� ��� �ڷ������� ����
SELECT MIN(HIREDATE), MAX(HIREDATE) FROM EMP;
SELECT MIN(ENAME), MAX(ENAME) FROM EMP;
SELECT ROUND(AVG(SAL),2), ROUND(VARIANCE(SAL),2), ROUND(STDDEV(SAL),2) FROM EMP;
SELECT SAL FROM EMP;
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
SELECT VARIANCE(SAL), STDDEV(SAL)*STDDEV(SAL) FROM EMP;
SELECT COUNT(DISTINCT JOB) FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT COUNT(DISTINCT  DEPTNO) FROM EMP;
--źź1. �ֱ��Ի���, �ֱ��Ի��ѻ���Ǳٹ��ϼ�
SELECT MAX(HIREDATE), TRUNC(SYSDATE-MAX(HIREDATE)) FROM EMP;
--źź1-1. �����Ի���, �����Ի����ѻ���� �ٹ��ϼ�
SELECT MIN(HIREDATE), TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '99,999') FROM EMP;
--źź2. 10�� �μ��� ����� �߿��� �󿩱�(COMM)�� �ִ� ����� ��
SELECT COUNT(COMM) FROM EMP WHERE DEPTNO=10;
SELECT COUNT(*) FROM EMP WHERE DEPTNO=10 AND COMM IS NOT NULL;
-- �� 2. GROUP BY �� : �׷��Լ��� ���� � �÷����� �������� �׷��Լ��� �����ϰ��� �� ��
    -- GROUP BY ������ ��Ī�� ����� �� ���� �÷����̳� �÷����� �̿��� ����
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;
SELECT * FROM DEPT;
SELECT DEPTNO, AVG(SAL), DECODE(DEPTNO, 10, 'ACCOUNTING',
                                        20, 'RESEARCH',
                                        30, 'SALES',
                                        'OPERATIONS') FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO �μ�, AVG(SAL), STDDEV(SAL) FROM EMP 
        WHERE DEPTNO != 10
        GROUP BY DEPTNO
        ORDER BY �μ�;
SELECT EXTRACT(YEAR FROM HIREDATE), AVG(SAL) FROM EMP 
        GROUP BY EXTRACT(YEAR FROM HIREDATE);
-- źź������ : �μ����� ��ձ޿��� �˻��Ͻÿ�.
SELECT DNAME, AVG(SAL) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME;
-- �� 3. HAVING �� : �׷��Լ��� ���� ������
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL)>2000;

-- �� 4. �ǹ����̺�
SELECT JOB, SUM(SAL) FROM EMP GROUP BY JOB;
SELECT JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(JOB);
SELECT JOB, AVG(SAL) FROM EMP GROUP BY ROLLUP(JOB);
SELECT AVG(SAL) FROM EMP;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;
SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);
SELECT JOB, DEPTNO, SUM(SAL) FROM EMP GROUP BY JOB, DEPTNO;

SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO, JOB; -- �������� ���� ���� �ǹ�
SELECT DEPTNO, SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLEARK",
               SUM(DECODE(JOB, 'MANAGER', SAL, 0)) "MANAGER",
               SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) "PRESIDENT",
               SUM(DECODE(JOB, 'ANALYST', SAL, 0)) "ANALYST",
               SUM(DECODE(JOB, 'SALESMAN',SAL, 0)) "SALESMAN",
               SUM(SAL) "�Ұ�" FROM EMP
        GROUP BY ROLLUP(DEPTNO);
               
--     CLERK MANAGER PRESIDENT ANALYST SALESMAN
-- 10   1300  2450      5000      0        0
-- 20   1900     0         0     6000
-- 30





-- �� �ɿ�������
--1.��� ���̺��� �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ����Ͽ� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;

--2.������̺��� ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB;

--3.������̺��� �ִ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL) FROM EMP;

--4.�μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ����ϵ� 
    --�޿��� ���� ���� ������ ���
SELECT DEPTNO, COUNT(*), AVG(SAL), MIN(SAL), MAX(SAL), SUM(SAL) �� FROM EMP 
    GROUP BY DEPTNO
    ORDER BY �� DESC;

--5.�μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ���
    --(��°���� �μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) FROM EMP
    GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
    
--6.������, �μ��� �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���� ����϶�.
    --(��°���� ������, �μ���ȣ �� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) FROM EMP
    GROUP BY JOB, DEPTNO ORDER BY JOB, DEPTNO;
    
--7.������� 5���̻� �Ѵ� �μ���ȣ�� ����� ���
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO HAVING COUNT(*)>=5;

--8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*) FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO
    GROUP BY DNAME HAVING COUNT(*)>=5;
    
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���
SELECT JOB, AVG(SAL), SUM(SAL) FROM EMP GROUP BY JOB HAVING AVG(SAL)>=3000;

--10.��ü �޿��� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿��հ踦 ���.
    --��, �޿� �հ�� �������� ����
SELECT JOB, SUM(SAL) FROM EMP 
    GROUP BY JOB  HAVING SUM(SAL)>5000 ORDER BY SUM(SAL) DESC;
    
--11.�μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, AVG(SAL), SUM(SAL), MIN(SAL) FROM EMP GROUP BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, 
    --�μ��� �ּұ޿��� �ִ�ġ�� ����϶�
SELECT MAX(AVG(SAL)), MAX(SUM(SAL)), MAX(MIN(SAL)) FROM EMP GROUP BY DEPTNO;

--13. 
    --H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
    --		80	  1		    800		    800		    800		    800
    --		81	 10		    950		    5000		2282.5		22825
    --		82	  2		    1300		3000		2150		4300
    --		83	  1		    1100		1100		1100		1100
SELECT TO_CHAR(HIREDATE, 'YY') H_YEAR, 
        COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YY');
    
--14.�ǹ��ƴ� �� ����
SELECT TO_CHAR(HIREDATE, 'YYYY'), COUNT(*) FROM EMP 
    GROUP BY TO_CHAR(HIREDATE, 'YYYY');
    
SELECT TO_CHAR(HIREDATE, 'YYYY'), COUNT(*) FROM EMP 
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'));
    
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'),'TOTAL'), COUNT(*) FROM EMP 
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'));
--�ǹ��� ���߿�
    --TOTAL		1980	1981	1982	1983
    --14		1	    10	    2	    1
-- �ǹ������ܰ�
SELECT DECODE(EXTRACT(YEAR FROM HIREDATE), 1980, 1, 0) "1980",
       DECODE(EXTRACT(YEAR FROM HIREDATE), 1981, 1, 0) "1981",
       DECODE(EXTRACT(YEAR FROM HIREDATE), 1982, 1, 0) "1982",
       DECODE(EXTRACT(YEAR FROM HIREDATE), 1983, 1, 0) "1983" FROM EMP;
-- �ǹ�
SELECT COUNT(*) TOTAL,
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), 1980, 1, 0)) "1980",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), 1981, 1, 0)) "1981",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), 1982, 1, 0)) "1982",
       SUM(DECODE(EXTRACT(YEAR FROM HIREDATE), 1983, 1, 0)) "1983" FROM EMP;
       
--15.������̺��� �Ʒ��� ����� ����ϴ� SELECT �� �ۼ�(JOB ������ �������� ����)
--�ǹ��ƴ� �ź���
SELECT JOB, DEPTNO, SUM(SAL) FROM EMP 
    GROUP BY ROLLUP(JOB, DEPTNO) ORDER BY JOB, DEPTNO;
    
--�ǹ��� ���߿�
    --JOB		DEPTNO10	DEPTNO20	DEPTNO30     TOTAL
    --ANALYST	     0		   6000		    0		6000
    --CLERK		  1300		   1900		  950		4150
    --��.
    --SALESMAN	      0	 		0	    5600		 5600
--�ǹ������ܰ� - DECODE
SELECT JOB, DECODE(DEPTNO, 10, SAL, 0) DEPTNO10,
            DECODE(DEPTNO, 20, SAL, 0) DEPTNO20,
            DECODE(DEPTNO, 30, SAL, 0) DEPTNO30 FROM EMP;
-- �ǹ� (������ �׷��Լ� �̿�)
SELECT JOB, SUM(DECODE(DEPTNO, 10, SAL, 0)) DEPTNO10,
            SUM(DECODE(DEPTNO, 20, SAL, 0)) DEPTNO20,
            SUM(DECODE(DEPTNO, 30, SAL, 0)) DEPTNO30,
            SUM(SAL) TOTAL FROM EMP GROUP BY JOB;
            
--(16)	 ������̺��� �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���Ͻÿ�
SELECT MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL) FROM EMP;	

--(17)	 ������̺��� �μ��� �ο����� ���Ͻÿ�
SELECT DEPTNO, COUNT(*) FROM EMP GROUP BY DEPTNO;

--(18)	 ��� ���̺��� �μ��� �ο����� 6���̻��� �μ��ڵ带 ���Ͻÿ�
SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING COUNT(*)>=6;

--(19)	 ������̺��� ������ ���� ����� ������ �Ͻÿ�
--�ǹ� �ƴѰ� ����
SELECT DNAME, JOB, SUM(SAL) FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO GROUP BY DNAME, JOB ORDER BY DNAME;
    --DNAME               CLERK    MANAGER   PRESIDENT    ANALYST   SALESMAN
    --ACCOUNTING            1300       2450       5000          0          0
    --RESEARCH              1900       2975          0       6000          0
    --SALES                 950        2850          0          0       5600
--�ǹ� ���߿�
SELECT DNAME, SUM(DECODE(JOB, 'CLERK', SAL, 0)) "CLERK",
              SUM(DECODE(JOB, 'MANAGER', SAL, 0)) "MANAGER",
              SUM(DECODE(JOB, 'PRESIDENT', SAL, 0)) "PRESIDENT",
              SUM(DECODE(JOB, 'ANALYST', SAL, 0)) "ANALYST",
              SUM(DECODE(JOB, 'SALESMAN', SAL, 0)) "SALESMAN" FROM EMP E, DEPT D
            WHERE E.DEPTNO=D.DEPTNO
            GROUP BY DNAME;

--(20)������̺��� �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�.
        --(��Ʈ self join, group by, count���)
    --	ENAME	    ���
    --	________________________
    --	KING		1
    --	SCOTT		2
    --	FORD		2
    --	JONES		4
    --	����
SELECT E1.ENAME, E2.ENAME FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL AND E1.ENAME='SCOTT';

SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK FROM EMP E1, EMP E2
    WHERE E1.SAL<E2.SAL(+) GROUP BY E1.ENAME 
    ORDER BY RANK;











