-- SQL�� �� SELECT�� = ������ �˻�
--�� 1. ������ SELECT
SELECT * FROM TAB; -- �� ������ ������ ���̺�� �˻�
SELECT * FROM DEPT; -- DEPT ���̺��� ��� �ʵ� ��ü �˻�
DESC DEPT;  -- DEPT ���̺��� ���� ����
SELECT * FROM EMP; -- EMP���̺��� ��� �ʵ� ��ü �˻�
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; -- Ư���ʵ��� ��ü �� �˻�
SELECT EMPNO AS "���", ENAME AS "�̸�", SAL AS "�޿�", JOB AS "��å" FROM EMP;
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP;
SELECT EMPNO ���, ENAME �̸�, SAL �޿� FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL S FROM EMP; -- �ʵ���� ���� ���
--�� 2. WHERE��(������) - �񱳿�����
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL!=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<>3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL^=3000;
SELECT * FROM EMP WHERE DEPTNO=10; -- 10�� �μ��� ����� ��� �ʵ带 �˻�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='FORD'; -- ENAME�� FORD�� ������ ���, �̸�, �޿��� �˻�
select empno, ename, sal from emp where ename='FORD';
SELECT EMPNO, ENAME, SAL FROM EMP WHERE ENAME='ford';
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP WHERE SAL>=2000 ;
    -- sal�� 2000�̻��� ����� ���(empno), �̸�(ename), �޿�(sal), �Ի���(hiredate)
SELECT * FROM EMP WHERE HIREDATE<'82/01/01';
    -- 1982�� 1�� 1�� ������ �Ի��� ����� ��� �ʵ� �˻�
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE FROM EMP WHERE ENAME < 'C';
    -- ENAME�� 'A'�� 'B'�� �����ϴ� ���� ���, �̸�, JOB, MGR, HIREDATE�� �˻�

--�� 3. WHERE�� - ��������(AND, OR, NOT)
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<3000; -- SAL�� 2000���� ������ ��� �ʵ带 �˻�
SELECT * FROM EMP WHERE DEPTNO=10 AND JOB='MANAGER';-- DEPNO�� 10�̰�, JOB = 'MANAGER'�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';-- �μ��� 10���̰ų� JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE NOT DEPTNO=10;
--�� 4. ��������
SELECT EMPNO, ENAME, SAL, SAL+300 FROM EMP;
SELECT EMPNO, ENAME, SAL, SAL*12 "1��ġ����" FROM EMP;
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+COMM ���� FROM EMP; -- NULL�� �����ϸ� ����� NULL
SELECT ENAME, COMM, NVL(COMM, 0) FROM EMP;
    --NVL: ù���ڰ� NULL�� ��� �ι�° ������ ������ ��ġ�Ѵ�. ���� ���� ���� Ÿ��
SELECT ENAME, NVL(MGR, '����') FROM EMP;
SELECT * FROM EMP WHERE SAL>NVL(COMM,0)*2;
--ex1.	emp ���̺��� ���� ���
DESC EMP;
--ex2.	emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--ex3.	�� �������� ��밡���� ���̺� ���
SELECT * FROM TAB;
--ex4.	emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--ex5.	emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
--ex6.	emp ���̺��� �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE>='82/02/01';
--ex7.	emp ���̺��� ������ SALESMAN�� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE JOB='SALESMAN';
--ex8. ����(job)�� CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE NOT JOB='CLERK';
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
--ex9.	�޿�(sal)�� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--ex10.	�μ��ڵ�(deptno)�� 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30; -- ��
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO IN(10,30);
--ex11.	������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--ex12.	�޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB='MANAGER';
--ex13.	emp ���̺��� ��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���
SELECT ENAME||'�� '||JOB||' �����̰� ������ '||(SAL*12+NVL(COMM,0))||'��'
    FROM EMP;
-- �� 5. ���Ῥ���� (||)
SELECT ENAME || ' ' || JOB AS "employees_Details" FROM EMP;
SELECT ENAME||'�� ������ '|| (SAL*12+NVL(COMM,0))||'$��' FROM EMP;  
            -- "XX�� ������ XX$��"(SAL*12+COMM)
SELECT ENAME || '�� ��å�� '||JOB||'��' TITLE
    FROM EMP 
    WHERE SAL>=2000 AND SAL<3000;-- xx(ENAME)�� ��å�� xx(JOB)��. ��, SAL�� 2000��
-- �� 6. �ߺ����� : DISTINCT
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB, DEPTNO FROM EMP;
-- �� 7. ��Ÿ SQL������ LIKE pattern, IN(10,20), BETWEEN a AND b, IS NULL
SELECT * FROM EMP WHERE ENAME LIKE '%A%';
       -- LIKE %(0�����̻�) / LIKE _(�ѱ����̻�)
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
    -- 82�⵵�� �Ի��� ����� ���, �̸�, JOB, �޿�, �Ի���, �μ���ȣ�� ���
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE LIKE '82/%';
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE, DEPTNO FROM EMP
    WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 2999;--BETWEEN a AND b (a,b����)
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP 
    WHERE EMPNO=7902 OR EMPNO=7788 OR EMPNO=7566;
SELECT EMPNO, ENAME, JOB, SAL, HIREDATE FROM EMP 
    WHERE EMPNO IN (7902, 7788, 7566);
    -- ����� 7902, 7788, 7566�� ����� ���, �̸�, job, �޿�, �Ի����� �˻�
SELECT * FROM EMP WHERE ENAME LIKE '%M%';
    -- �̸��� M�� ���� ����� ��� �ʵ带 �˻�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    -- �̸��� M���� �����ϴ� ����� ��� �ʵ带 �˻�
SELECT * FROM EMP WHERE ENAME LIKE '%M';
    -- �̸��� M���� ������ ����� ��� �ʵ带 �˻�
SELECT * FROM EMP WHERE ENAME LIKE '_M%';
    -- �̸��� �ι�° ���ڰ� M�� ����� ��� �ʵ带 �˻�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
    -- �̸��� %�� �� ����� ��� �ʵ� �˻�
SELECT * FROM EMP WHERE COMM IS NULL;
    -- COMM�� NULL�� ����� ��� �ʵ� �˻�
SELECT * FROM EMP WHERE COMM IS NOT NULL;
SELECT * FROM EMP WHERE NOT COMM IS NULL;
    -- COMM�� NULL�� �ƴ� ����� ��� �ʵ� �˻�
SELECT * FROM EMP WHERE ENAME NOT LIKE '%A%';
SELECT * FROM EMP WHERE SAL NOT BETWEEN 2000 AND 2999;
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,30);
-- �� 8. ������ ���� ORDER BY ��
SELECT * FROM EMP ORDER BY SAL, ENAME; -- �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC, HIREDATE DESC; -- �������� ����
SELECT ENAME, SAL �޿� FROM EMP ORDER BY �޿� DESC;
SELECT ENAME, SAL, SAL*12+NVL(COMM,0) ���� 
    FROM EMP 
    WHERE SAL*12+NVL(COMM,0)>=1000
    ORDER BY ���� DESC;
  -- ����(SAL*12+COMM)�� 10000�̻��� ������ �̸��� �޿�, ������ ������(��������)���� ���

-- work181220.sql
--ex1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000;

--ex2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO=7788;

--ex3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12+NVL(COMM,0) >= 24000 ORDER BY SAL;

--ex4.	EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� �����
    --ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE;
    
--ex5.	EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;

--ex6.	EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
    --(�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly_Salary" 
    FROM EMP WHERE SAL>=1500 AND (DEPTNO=10 OR DEPTNO=30);
--ex7.	EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP WHERE HIREDATE LIKE '82/__/__';

--ex8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME>='C' AND ENAME<'Q' ORDER BY ENAME;
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' ORDER BY ENAME;

--ex9.EMP ���̺��� comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱� ���
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>SAL*1.1;

--ex10.	EMP ���̺��� job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� 
    --��� ����� ������ ���
SELECT * FROM EMP 
    WHERE JOB IN ('CLERK', 'ANALYST') AND SAL NOT IN (1000,3000,5000);
    
--ex11.	EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� 
    --����� ��� ������ ���
SELECT * FROM EMP 
    WHERE ENAME LIKE '%L%L%' AND DEPTNO=30 OR MGR=7782;
    
--ex12.	��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81%';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/__/__';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
    WHERE HIREDATE>='81/01/01' AND HIREDATE<='81/12/31';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
    WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
    
--ex13.	��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ 
    --���, �����, �Ի���, ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE LIKE '81/%' AND JOB!='SALESMAN';
    
--ex14.	��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
    --�޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;

--ex15.	��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

--ex16.	��� ���̺�������(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE SAL*12>=35000;





