-- �� �ֿ��Լ�=�������Լ� (SQL������ �Լ��� �������Լ��� �׷��Լ�)
SELECT ENAME, TO_CHAR(HIREDATE, 'YY-MM') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, 'L0,000.00') FROM EMP;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
-- �� 0. DUAL ���̺� : ��� �������� ������� ����Ŭ���� �����ϴ� �׽�Ʈ�� ���̺�
DESC DUAL;
SELECT * FROM DUAL;
SELECT ABS(-12*4) FROM DUAL;
DESC DUMMY;
SELECT * FROM DUMMY;
SELECT 12*5 FROM DUMMY;
-- �� 1. �����Լ�
SELECT ABS(-15), -15 FROM DUAL;
SELECT 34.5678, FLOOR(34.5678) FROM DUAL; -- �Ҽ��� ���� ����
SELECT 34.5678, TRUNC(34.5678, 0) FROM DUAL;
SELECT 34.5678, TRUNC(34.5678) FROM DUAL;
SELECT 34.5678, ROUND(34.5678) FROM DUAL; -- �Ҽ��� ���� �ݿø�
SELECT 34.5678, CEIL(34.5678) FROM DUAL; -- �Ҽ��� ���� �ø�

SELECT 34.5678, TRUNC(34.5678, 3) FROM DUAL;-- �Ҽ��� ����° �ڸ����� ����(34.567)
SELECT 34.5678, ROUND(34.5678, 3) FROM DUAL;-- �Ҽ��� ����° �ڸ����� �ݿø�(34.568)

SELECT 34.5678, TRUNC(34.5678, -1) FROM DUAL;-- ���� �ڸ� ���� ����(30)
SELECT 35.5678, ROUND(35.5678, -1) FROM DUAL;-- ���� �ڸ� ���� �ݿø�

SELECT MOD(9,2) FROM DUAL; -- �ڹٿ����� 9%1
SELECT (2+3)/2 FROM DUAL; -- 2.5
SELECT POWER(2,3) FROM DUAL; -- 2�� 3��
SELECT * FROM EMP WHERE MOD(EMPNO, 2)=1;
    -- EMP���̺��� ���(EMPNO)�� Ȧ���� ����� ��� �ʵ带 ���
SELECT MOD('10',2) FROM DUAL;
-- �� 2. �����Լ�
SELECT 'Welcome to Oracle', LOWER('Welcome to Oracle') FROM DUAL; -- �ҹ��ڷ�
SELECT LOWER(ENAME) FROM EMP;
SELECT 'WELcome to oracle', UPPER('WELcome to oracle') FROM DUAL; -- �빮�ڷ�
SELECT ENAME, UPPER(ENAME) FROM EMP;
SELECT 'WELCOME TO oracle', INITCAP('WELCOME TO oracle') FROM DUAL; --ù�ڸ� �빮��
SELECT ENAME, INITCAP(ENAME) FROM EMP;
SELECT CONCAT('ABC', 'DEF') FROM DUAL; -- ABCDEF
SELECT CONCAT(CONCAT('AB','CD'),'EF') FROM DUAL; -- 'AB'+ 'CD' + 'EF'
SELECT 'AB'||'CD'||'EF' FROM DUAL;
SELECT CONCAT(CONCAT(CONCAT(ENAME, '('),SAL),')') FROM EMP;
    -- �Ʒ��� ����� �����ϰ� ��µǵ��� �ϰ�, CONCAT�Լ��� �̿�
SELECT ENAME || '(' || SAL || ')' FROM EMP;
    -- EMP���̺��� �̸�(�޿�)
SELECT SUBSTR('Welcome to oracle', 4, 3) FROM DUAL; -- 4��° ���ں��� 3���� ������
SELECT SUBSTR('Welcome to oracle', -4, 3) FROM DUAL;
SELECT ENAME, SUBSTR(HIREDATE, 1,2) ��, SUBSTR(HIREDATE, 4,2) �� FROM EMP;
    -- EMP���̺��� ����� �̸��� �Ի��, �Ի���� ���
SELECT SUBSTR('WELCOME TO',3,4), SUBSTRB('WELCOME TO', 3, 4) FROM DUAL;
    -- SUBSTR('WELCOME TO',3,4) : 3��° ���ں��� 4���� ����
    -- SUBSTRB('WELCOME TO', 3, 4) : 3��° BYTE���� 4BYTE ����
SELECT SUBSTR('���Ŀ���Ŭ', 3,3), SUBSTRB('���Ŀ���Ŭ', 3,4) FROM DUAL;
SELECT LENGTH('oRACLE'), LENGTHB('ORACLE') FROM DUAL; -- ���ڱ���, BYTE����
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ') FROM DUAL;

SELECT INSTR('ABC_ABC_ABC', 'B') FROM DUAL;-- 1��°���� �˻��ؼ� ù 'B'�� ��ġ ���
SELECT INSTR('ABC_ABC_ABC', 'B', 3) FROM DUAL; -- 3��°���� �˻��ؼ� ù 'B'��ġ
SELECT INSTR('ABC_ABC_ABC','B',3, 2) FROM DUAL;
    -- 3��° ���ں��� �˻��ؼ� 2��° ������ 'B'�� ��ġ
SELECT INSTR('����������','��') FROM DUAL; -- 2 ��° ����
SELECT INSTR('����������','��',3) FROM DUAL; -- 4
SELECT INSTR('����������','��',3,2) FROM DUAL; --6 
SELECT INSTRB('����������','��') FROM DUAL; -- 4��° BYTE
SELECT INSTRB('����������','��',3) FROM DUAL; -- 4��° BYTE
SELECT INSTRB('����������','��',3,2) FROM DUAL; --6��° BYTE
SELECT INSTR('����������','��',-1) FROM DUAL;

SELECT LPAD('ORACLE', 20,'#') FROM DUAL;
SELECT RPAD('ORACLE', 20, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL, 10, '*') FROM EMP;
SELECT ENAME, RPAD(SAL, 10, '*') FROM EMP;
SELECT RPAD(SUBSTR(ENAME,2,1), LENGTH(ENAME), '*'), SAL FROM EMP;
    -- �̸��� ù���ڸ� ������ �������� *�� ��� S****, W***, F***, M*****
--źź1. 9���� �Ի��� ����� ��� �ʵ带 ����� ���ÿ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/09/%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)='09';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)=9;
--źź2. 83�⵵�� �Ի��� ������ �˾Ƴ��� ���� SUBSTR �Լ��� �̿��Ͽ� HIREDATE �÷����� 
    --ù ���ں��� 2���� �����Ͽ� �� ���� 83������ üũ�ϴ� ������ε� ���� ������ �ϼ���. 
SELECT * FROM EMP WHERE HIREDATE LIKE '83%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1,2)='83';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1,2)=83;
--źź3. ������ �̸��� E�� ������ ����� �˻��� ������ �սô�. SUBSTR �Լ� �̿�
SELECT * FROM EMP WHERE SUBSTR(ENAME, -1, 1) ='E';
SELECT * FROM EMP WHERE ENAME LIKE '%E';
--źź4. �����, �̸�, JOB(�̸��� ���ڿ� �� ��ŭ�� ǥ��)���� ������ �����͸� ȭ�鿡 LIST
    -- 7369   SMITH   CLERK
    -- 7499   ALLEN   SALES
SELECT EMPNO, ENAME, SUBSTR(JOB, 1, LENGTH(ENAME)) FROM EMP;

--źź5. EMP ���̺��� ����̸��� 2�ڸ��� ��µǰ� �������� *�� ���⵵�� ���
SELECT RPAD(SUBSTR(ENAME, 1, 2), LENGTH(ENAME), '*') FROM EMP;
--źź6.	1982�� 12��1�� ~1982��12��31�� �Ի��� ����� �̸��� �Ի��Ϸ� ���;
    -- ��¥���̹��������� �ڵ� ����ȯ
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '82/12/01' AND '82/12/31';
SELECT ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 1, 5)='82/12';

SELECT ENAME, SAL, TRANSLATE(SAL, '0123456789','�����̻�����ĥ�ȱ�') FROM EMP;
SELECT REPLACE('ABCABC','A','X') FROM DUAL;

SELECT TRIM('   ORA CLE  ') T FROM DUAL; -- �¿� ���� ����
SELECT LTRIM('   ORA CLE     ') T FROM DUAL;-- ���� ���� ����
SELECT RTRIM('   ORA CLE     ') T FROM DUAL;
SELECT TRIM('A' FROM 'AAAAORACLEAAA') FROM DUAL; -- �¿� 'A' ����
-- źź �̸��� ����°�ڸ��� R�� ����� ��� �ʵ带 ���(LIKE, INSTR, SUBSTR)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R',3)=3; -- RRRXX���� ����
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1)='R';

-- �� 3. ��¥�Լ�
SELECT SYSDATE FROM DUAL; -- SYSDATE : ������
SELECT TO_CHAR(SYSDATE, 'MM DD HH24:MI') FROM DUAL;
SELECT SYSDATE-1 "������ð�", SYSDATE "�����̽ð�", SYSDATE+1 "���Ͽ�ð�" FROM DUAL;
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE)/7) �ּ� FROM EMP;
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
SELECT ADD_MONTHS(SYSDATE, 2) FROM DUAL;
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) FROM EMP; -- 3�� ��
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;
ALTER SESSION SET NLS_LANGUAGE=KOREAN;
            -- SYSDATE�κ��� ���ʷ� �����ϴ� �Ͽ���
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM EMP; -- ����
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) ù���޳� FROM EMP;
-- DATE���� �ݿø�, ����
SELECT SYSDATE, ROUND(SYSDATE, 'YEAR') FROM DUAL; -- 'YEAR'�� �ݿø��� ����� 1��1��
SELECT SYSDATE, ROUND(SYSDATE, 'MONTH') FROM DUAL; -- 'MONTH'�� �ݿø��� ����� 1��
SELECT SYSDATE, ROUND(SYSDATE, 'DAY') FROM DUAL; -- 'DAY'�� �ݿø��� ����� �Ͽ����� ��
SELECT ROUND(SYSDATE+2, 'DAY') FROM DUAL;
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL;
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;
SELECT TO_CHAR(TRUNC(SYSDATE), 'MM DD HH24:MI') FROM DUAL;

-- źź1. EMP���̺��� ����̸��� �ٹ��ϼ�, �ٹ��� �ּ�, �ٹ�������, �ٹ������ ���
SELECT ENAME, TRUNC(SYSDATE-HIREDATE) "�ٹ��ϼ�",
        TRUNC((SYSDATE-HIREDATE)/7) "�ٹ��ּ�",
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�������",
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "�ٹ����" FROM EMP;

-- źź2. EMP���̺��� ����̸��� �Ի��� ���� 1���� ���
SELECT ENAME, TRUNC(HIREDATE, 'MONTH') FROM EMP;
-- źź3. EMP���̺��� ����̸��� �Ի��ϰ� �Ի����� 6������ ���� ���� ���
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
-- źź4. EMP���̺��� ����̸��� �Ի��� ���� ������ ���
SELECT ENAME, LAST_DAY(HIREDATE) FROM EMP;
-- �� 4. ����ȯ�Լ�
-- NUMBER��, DATE��, ������
--(1)TO_CHAR(��¥������, '����') :DATE��->������
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS') FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"��"MM"��"DD"��" DY"����" AM HH:MI:SS') 
    FROM DUAL;
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"��"MM"��"DD"��" DAY AM HH24:MI:SS') 
    FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MON') FROM DUAL;
--(2)TO_CHAR(���ڵ�����, '����') :NUMBER��->������
    -- L(������ȭ��ȣ) $ , . 9(�ڸ����� ���� �� ä���� �ʴ´�) 0(�ڸ����� ��� ä��)
SELECT TO_CHAR(SAL, 'L0,000.99') FROM EMP;
SELECT TO_CHAR(123456789, '9,999,999,999') FROM DUAL;
--(3)TO_DATE(���ڵ�����, '����') :������->DATE��
SELECT HIREDATE FROM EMP;
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 1,2)=82;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY')=82;
-- 1982.10.20�� �Ի��� ������ ���
SELECT * FROM EMP WHERE HIREDATE=TO_DATE('19801217','YYYYMMDD');
SELECT * FROM EMP WHERE HIREDATE='82/10/20';
ALTER SESSION SET NLS_DATE_FORMAT='DD-MON-YYYY';
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('19821201','YYYYMMDD')
                                AND TO_DATE('19821231','YYYYMMDD');
SELECT TRUNC(SYSDATE - TO_DATE('19931224','YYYYMMDD')) FROM DUAL;
  -- �¾ ������ ���ݱ��� ������ �������� ���
--(4)TO_NUMBER(���ڵ�����, ����) : ������->NUMBER��
SELECT '1,000'-'500' FROM DUAL;
SELECT TO_NUMBER('1,000', '9,999')-TO_NUMBER('500','999') FROM DUAL;
-- �� 5. NVL(����, ����)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO'), TO_CHAR(SAL, '$9,999'), NVL(COMM, 0)
    FROM EMP;
    --EMP ���̺��� �̸�, MGR(NULL�� ��� : CEO), SAL($9,999), COMM(NULL�� ��� : 0)
SELECT W.ENAME, NVL(TO_CHAR(W.MGR),'CEO'), NVL(M.ENAME , 'CEO')
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO(+);
    --EMP���̺��� �̸�, �����, ����̸� ���(��簡 ���� ��� ������� �̸��� 'CEO')
-- �� 6. DECODE(ǥ����, ����1, ��1, ����2, ��2, ����3, ��3, �⺻��)
SELECT ENAME, DEPTNO, DECODE(DEPTNO, 10, 'ACCOUNTING', 20,'RESEARCH',
                        30, 'SALES', 40,'OPERATIONS', '�⺻��') AS DNAME FROM EMP;
SELECT ENAME, DEPTNO, 
        CASE WHEN DEPTNO=10 THEN 'ACCOUNTING'
            WHEN DEPTNO=20 THEN 'RESEARCH'
            WHEN DEPTNO=30 THEN 'SALES'
            WHEN DEPTNO=40 THEN 'OPERATIONS'
            ELSE '�⺻��'
        END
    FROM EMP;
SELECT ENAME, SAL "����޿�", 
    DECODE(JOB, 'ANALYST', SAL*1.1, 'SALESMAN', SAL*1.2, 'MANAGER', SAL*1.3, 
                'CLERK', SAL*1.4, SAL)
    "�λ�޿�" FROM EMP;
    -- JOB�� ���� �޿��λ��� �ϵ��� �Ѵ�. JOB 'ANALYST'�� 10%�λ�. 'SALESMAN'��20%�λ�
    --  'MANAGER'�� 30% �λ�, 'CLERK' 40%�λ�
-- �� 7. �׿� EXTRACT(YEAR FROM ��¥��������), LEVEL-START WITH-CONNECT BY PRIOR
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY')='1982';
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE)=1982;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')='09';
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=9;
-- LEVEL-START WITH-CONNECT BY PRIOR : ������ ������ �����ϰ� �����ְ� ���� ��
SELECT LPAD(' ', 3*(LEVEL-1))||'��'||ENAME, LEVEL, EMPNO, MGR FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;

-- �� �� ��������
--1.���� ��¥�� ����ϰ� ���� Ÿ��Ʋ�� Current Date�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

--2.���� �޿��� 15%�� ������ �޿��� �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),
    --������(Increase)�� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 Increase FROM EMP;

--3.�̸�,�Ի���,�Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ���.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6),'��') FROM EMP;

--4.�̸�,�Ի���, �ٹ�������,�޿�, ������� ���� �޿��� �Ѱ踦 ���.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)),SAL,
    SAL*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))
        +NVL(COMM,0)*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12)
    FROM EMP;
    
--5.��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;

--6.��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ���
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY') FROM EMP;

--7.�̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>=6;

--8.��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM, 0) FROM EMP;

--9.������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10.��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)='12';
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')='12';

--11.������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
    --EMPNO		ENAME		�޿�
    --7369		SMITH		*******800
    --7499		ALLEN		******1600
    --����.
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') FROM EMP;

--12.������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
    --EMPNO	 ENAME 	�Ի���
    --7369	  SMITH		1980-12-17
    --...
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;

--13.��� ���̺��� �޿��� ���� ���, �̸�, �޿�, ����� �˻��ϴ� SQL ������ �ۼ� �Ͻÿ�. 
-- �޿��� 0~1000 E / 1001~2000 D / 2001~3000 C / 3001~4000 B / 4001~5000 A
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC((SAL-1)/1000), 0,'E', 1,'D',2,'C',
                                            3,'B', 4, 'A') FROM EMP;
SELECT EMPNO, ENAME, SAL,
    CASE WHEN SAL>=0 AND SAL<=1000 THEN 'E'
        WHEN SAL>=1001 AND SAL<=2000 THEN 'D'
        WHEN SAL>=2001 AND SAL<=3000 THEN 'C'
        WHEN SAL>=3001 AND SAL<=4000 THEN 'B'
        WHEN SAL>=4001 AND SAL<=5000 THEN 'A'
    END FROM EMP;    
   --(cf) �޿���- 0~999 E / 1000~1999 D / 2000~2999 C / 3000~3999 B / 4000�̻� A
SELECT EMPNO, ENAME, SAL, DECODE(TRUNC(SAL/1000), 0,'E', 1,'D',2,'C',
                                            3,'B', 'A') ��� FROM EMP;
SELECT EMPNO, ENAME, SAL,
    CASE WHEN SAL>=0 AND SAL<=999 THEN 'E'
        WHEN SAL>=1000 AND SAL<=1999 THEN 'D'
        WHEN SAL>=2000 AND SAL<=2999 THEN 'C'
        WHEN SAL>=3000 AND SAL<=3999 THEN 'B'
        WHEN SAL>=4000 AND SAL<=4999 THEN 'A'
    END ��� FROM EMP;

--14. ��� ���̺��� �μ���ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�
    --(�޿��� �տ� $�� �����ϰ� 3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$9,999,999') FROM EMP WHERE DEPTNO=20;










