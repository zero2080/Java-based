-- JOIN
-- �� 1.Join�� �ʿ伺
SELECT * FROM EMP WHERE ENAME='SMITH';
SELECT * FROM DEPT;
SELECT * FROM SALGRADE;
-- �� 2. cross join
SELECT * FROM EMP; -- 14 ROW (8�ʵ�)
SELECT * FROM DEPT; -- 4 ROW (3�ʵ�)
SELECT * FROM EMP, DEPT; -- 14*4(56) ROW (8+3=11�ʵ�)
-- �� 3. Equi join(��������)
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT EMP.*, DNAME, LOC FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO;
SELECT E.*, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
SELECT ENAME, MGR, HIREDATE, D.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- �̸�, MGR, HIREDATE, DEPTNO, DNAME, LOC
SELECT ENAME, DNAME, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND ENAME='SCOTT';
    -- 'SCOTT' �̸�, �μ���, �ٹ���
SELECT EMPNO, ENAME, SAL, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- ���, �̸�, �޿�, �μ��ڵ�, �μ���
SELECT ENAME, JOB, SAL, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000
    ORDER BY SAL;
    -- �̸�, JOB, �޿�, �μ���, �ٹ��� (�޿��� 2000�̻����� �޿������� ����)
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='CHICAGO';
    -- 'CHICAGO'�� �ٹ��ϴ� ������ �̸�, ����, �μ���, �ٹ����� ���
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND E.DEPTNO IN (10,20)
    ORDER BY SAL;
    -- �̸�, ����, �ٹ��� (�μ���ȣ�� 10�̰ų� 20�� ������ �޿���) ���
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ����, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    -- �̸�, �޿�, COMM, ����(��Ī), �μ���, �ٹ��� ���, ����=(�޿�+COMM)*12.
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0))*12 ����, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND (JOB='SALESMAN' OR JOB='MANAGER') 
    ORDER BY ���� DESC;
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM, 0))*12 ����, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB IN ('SALESMAN', 'MANAGER') 
    ORDER BY ���� DESC;
    -- ���� �������ٰ� JOB�� 'SALESMAN'�Ǵ� 'MANAGER' �� ����ϰ� ������ ū ������ ����
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL>=1200
    ORDER BY DNAME, SAL DESC;
    -- �̸�, �޿�, �Ի���, �μ��ڵ�, �μ���.
        --(����: COMM�� NULL�̰� �޿� 1200�̻�. �μ���� ����. ���� �μ����� �޿�ū��)
        
--źź1.	����(NEW YORK)���� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
--źź2.	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, 
    TO_CHAR(HIREDATE, 'YYYY"��" MM"��" DD"��" HH"��" MI"��"SS"��"') HIREDATE 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--źź3.	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--źź4.	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, TO_CHAR(SAL, '$9,999'), E.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
-- �� 4. NON-Equi join
SELECT * FROM EMP WHERE ENAME='ALLEN';
SELECT * FROM SALGRADE;
SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;
SELECT ENAME, SAL, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY GRADE, ENAME;
    -- �̸�, �޿�, ����� ���(��޼����� ����, �̸���)
    
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, GRADE||'���' GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
SELECT E.*, GRADE||'���' GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL;
    -- ���, �̸�, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, x���, 
--źź1. Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO -- EQUI JOIN
        AND SAL BETWEEN LOSAL AND HISAL -- NON-EQUI JOIN
        AND COMM IS NOT NULL;
--źź2. �̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
--źź3.	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
--źź4.	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND COMM IS NOT NULL;
--źź5.	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. 
        --����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))*12 ����, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ����;
    
--źź6.	�̸�, JOB, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. 
        --�������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, E.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND SAL BETWEEN 1000 AND 3000
    ORDER BY E.DEPTNO, JOB, SAL DESC;
--źź7.	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE LIKE '81%'
    ORDER BY GRADE DESC;
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND TO_CHAR(HIREDATE,'YY')='81'
    ORDER BY GRADE DESC;
-- �� 5. self join
SELECT W.EMPNO, W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
SELECT W.ENAME || '�� ���� ' || M.ENAME || '��' TITLE
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
    -- xx�� ���� xx��
SELECT W.EMPNO, W.ENAME, W.JOB, M.ENAME "����̸�", W.HIREDATE, W.SAL, W.COMM
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO;
    -- ���, �̸�, JOB, ����̸�, HIREDATE, SAL, COMM
SELECT W.EMPNO, W.ENAME, W.JOB, M.ENAME, W.HIREDATE, W.SAL, W.COMM, DNAME
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO;
    -- ���, �̸�, JOB, ����̸�, HIREDATE, SAL, COMM, �μ���ȣ��� �μ���
    
--źź1.	��簡 KING�� ������� �̸��� JOB(����)�� ����Ͻÿ�
SELECT W.ENAME, W.JOB, W.MGR, M.EMPNO, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';
SELECT W.ENAME, W.JOB
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME='KING';    
--źź2. SCOTT�� ������ �μ���ȣ(DEPTNO)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT E1.ENAME, E1.DEPTNO, E2.DEPTNO, E2.ENAME
    FROM EMP E1, EMP E2
    WHERE E1.ENAME='SCOTT' AND E1.DEPTNO=E2.DEPTNO;
SELECT E2.ENAME FROM EMP E1, EMP E2 
    WHERE E1.DEPTNO=E2.DEPTNO AND E1.ENAME='SCOTT' AND E2.ENAME<>'SCOTT';
--źź3. SCOTT�� ������ �ٹ���(LOC)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT E2.ENAME
    FROM EMP E1, DEPT D, EMP E2
    WHERE E1.DEPTNO=D.DEPTNO AND D.DEPTNO=E2.DEPTNO 
        AND E1.ENAME='SCOTT' AND E2.ENAME<>'SCOTT';
 -- ��50�μ�, DALLAS �Է� -> ��EMP���̺� 50�μ� ���� �Է� -> ��źź3 -> �굥���Ϳ��󺹱�
 -- ��
 DESC DEPT;
 INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
 SELECT * FROM DEPT;
 -- ��
 DESC EMP;
 INSERT INTO EMP VALUES (9999,'KIM',NULL,NULL,NULL,NULL,NULL,50);
 SELECT * FROM EMP;
 --�� 'SCOTT'�� ���� LOC���� �ٹ��ϴ� ����̸�
 SELECT E1.ENAME, D1.LOC, E2.ENAME, D2.LOC
    FROM EMP E1, EMP E2, DEPT D1, DEPT D2
    WHERE E1.ENAME='SCOTT'
        AND E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO
        AND D1.LOC=D2.LOC;
  SELECT E2.ENAME
    FROM EMP E1, EMP E2, DEPT D1, DEPT D2
    WHERE E1.ENAME='SCOTT' AND E2.ENAME<>'SCOTT'
        AND E1.DEPTNO=D1.DEPTNO AND E2.DEPTNO=D2.DEPTNO
        AND D1.LOC=D2.LOC;
 --�� ���󺹱�(50�� �Է�,50�� �μ�����Է� ���)
 ROLLBACK;
 SELECT * FROM DEPT;
 SELECT * FROM EMP;
 
-- �� 6. outer join
SELECT D.DEPTNO, DNAME, ENAME FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO;
SELECT * FROM EMP;
SELECT * FROM DEPT;
SELECT W.ENAME "����", NVL(M.ENAME,'����') "���"
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);

SELECT W.ENAME "����", NVL(M.ENAME,'����') "���"
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO;
SELECT M.ENAME, M.JOB, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR(+)=M.EMPNO AND W.ENAME IS NULL;
    -- �̸�, JOB, �μ��ڵ带 ���(���������� ���� ����)
SELECT D.DEPTNO, DNAME, ENAME FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO(+);
SELECT NVL(ENAME,'��'), NVL(JOB, '��'), NVL(TO_CHAR(E.DEPTNO),'��'), DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+)=D.DEPTNO;
    -- �̸�, ����, �μ��ڵ�, �μ���(������ ���� �μ������ ���)
--źź1.FORD�� �Ŵ����� JONES�Դϴ�. (�Ŵ����� ���� ��� �̸���� '��')
SELECT W.ENAME || '�� �Ŵ����� '|| NVL(M.ENAME,'��') ||'�Դϴ�'
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
--źź2. �̸�, �μ���ȣ, �μ����� ���(������ ���� 40�� �μ��� ���)
SELECT ENAME, D.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO(+)=D.DEPTNO;

-- �� �� ��������
--1. �̸�, ���ӻ��
SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;

--2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME FROM EMP W, EMP M WHERE W.MGR=M.EMPNO;

--3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���. 
    --��簡 ���� �� ������������ ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����') FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
    
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO;
    
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, 
    --(��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, M.ENAME 
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO;
    
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL>=2000;
        
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ���� ����)
SELECT W.ENAME, W.SAL, GRADE, DNAME, M.ENAME 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO(+) AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME;
        
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL;
        
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, GRADE, DNAME, (W.SAL+NVL(W.COMM,0))*12 ����, M.ENAME 
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO 
        AND W.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, SAL DESC;

--1. ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;

--2. NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ���
SELECT ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC='NEW YORK';
    
--3. EMP ���̺��� ���ʽ�(COMM)�� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL AND COMM <>0;
    
--4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE '%L%';
    
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO ASC;
    
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������
SELECT EMPNO, ENAME, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL>=2000 
    ORDER BY SAL DESC;
    
--7. ���, �����, ����, �޿�, �μ����� ���. 
    --�� ������ MANAGER�̸� �޿��� 2500�̻��� ����� ���Ͽ� ����� ���� ������������ ����
SELECT EMPNO, ENAME, JOB, SAL, DNAME FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER' AND SAL>=2500
    ORDER BY EMPNO;
    
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. 
    --����� �޿��� ���Ѱ��� ���Ѱ� ������ ���Եǰ� �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
    
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);

--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME, M.ENAME, MM.ENAME
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO AND M.MGR=MM.EMPNO;

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME, M.ENAME, MM.ENAME
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR=M.EMPNO(+) AND M.MGR=MM.EMPNO(+);







